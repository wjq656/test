.MODEL	TINY ; 微模型存储格式伪指令
EXTRN	Display8:NEAR  ;调用共享模块:数码管显示程序Display8
IO8259_0	EQU	0F000H  ;本仿真机8259A端口地址(偶地址)
IO8259_1	EQU	0F001H  ;本仿真机8259A端口地址(奇地址)
	.STACK      100     ;堆栈段定义
	.DATA               ;数据段定义
BUFFER          DB      8 DUP(?);显示缓冲区
Counter		DB	?       ;中断次数计数器
ReDisplayFlag	DB	0   ;显示标志

	.CODE               ;代码段
START:  	MOV     AX,@DATA ;送数据段地址
        	MOV     DS,AX
        	MOV	    ES,AX
        	NOP
        	CALL	Init8259 ;调用初始化8259A子程序
        	CALL	WriIntver;调用初始化中断矢量子程序
		MOV	Counter,0	;中断次数计数器清0
		MOV	ReDisplayFlag,1	;设置显示标志(1为需要显示,0为不显示)
		STI			;开中断
START1:		CMP	ReDisplayFlag,0
		    JZ	START1
		CALL	LedDisplay  ;要显示,调用显示处理子程序
		MOV	ReDisplayFlag,0 ;设置显示标志为0
		JMP	START1         ;循环,等待中断
Init8259	PROC	NEAR  ;初始化8259A子程序
		MOV	DX,IO8259_0   ;偶端口地址送DX
		MOV	AL,13H        ;写芯片控制初始化命令字(ICW1),13H表示要设定8259A的工
;作方式为单片方式,信号触发形式为上升边沿触发,需设置ICW4
		OUT	DX,AL  ; 写芯片控制初始化命令字(ICW1)
		MOV	DX,IO8259_1; 奇端口地址送DX
		MOV	AL,08H ;设定中断类型号基值(即IR0对应的中断类型号为08H)
		OUT	DX,AL;写中断类型号初始化命令字(ICW2)
		MOV	AL,09H; 设置中断方式,09H表示中断方式为缓冲,非自动结束
		OUT	DX,AL;写中断方式控制初始化命令字(ICW4)
		MOV	AL,0FEH; 0FEH表示允许IR0开中断,其它屏蔽
		OUT	DX,AL ;写中断屏蔽控制字(OCW1)
		RET
Init8259	ENDP
;**中断向量初始化程序,用指令来设置中断服务程序的入口地址到中断类型号08H所对应的中断向量表中.
WriIntver	PROC	NEAR; 中断向量初始化子程序,
		PUSH	ES
		MOV	AX,0
		MOV	ES,AX
		MOV	DI,20H;中断向量由中断类型号*4决定,本例中断类型号为08H ,故DI的值为20H
		LEA	AX,INT_0;中断服务程序入口偏移地址送AX
		STOSW    ;写字串指令(AX)→(ES:DI),把中断服务程序入口偏移地址送到[20H],[21H]单元中
		MOV	AX,CS
		STOSW   ;把中断服务程序入口段地址送到[22H],[23H]单元中
		POP	ES
		RET
WriIntver	ENDP

LedDisplay	PROC	NEAR; 显示处理子程序
		MOV	AL,Counter;将中断次数累计值送AL
		MOV	AH,AL     ;暂存AH中
		AND	AL,0FH    ;与操作,取计数值的个位
		MOV	Buffer,AL ;存入数码管缓冲区Buffer+0单元中 
		AND	AH,0F0H   ;与操作, 屏蔽低四位
		ROR	AH,4      ;循环右移4次,取计数值的十位
		MOV	Buffer + 1,AH;将计数值的十位存入数码管缓冲区Buffer+1单元中
		MOV	Buffer + 2,10H		;高六位不需要显示
		MOV	Buffer + 3,10H
		MOV	Buffer + 4,10H
		MOV	Buffer + 5,10H
		MOV	Buffer + 6,10H
		MOV	Buffer + 7,10H
		LEA	SI,Buffer;将数码管缓冲区Buffer首地址送SI
		CALL	Display8;调用数码管显示模块
		RET
LedDisplay	ENDP

INT_0:		PUSH	DX;中断服务子程序
		PUSH	AX
		MOV	AL,Counter  
		ADD	AL,1;累计中断个数
		DAA      ;十进制调整
		MOV	Counter,AL;保存计数值 
		MOV	ReDisplayFlag,1;设置显示标志
		MOV	DX,IO8259_0  ;8259A偶端口地址送DX    ???ICW2不是奇地址？？？？？
		MOV	AL,20H       ;定义ICW2,发EOI结束命令字,结束中断
		OUT	DX,AL
		POP	AX
		POP	DX
		IRET  ;中断返回
END	START


