.MODEL	TINY ; ΢ģ�ʹ洢��ʽαָ��
EXTRN	Display8:NEAR  ;���ù���ģ��:�������ʾ����Display8
IO8259_0	EQU	0F000H  ;�������8259A�˿ڵ�ַ(ż��ַ)
IO8259_1	EQU	0F001H  ;�������8259A�˿ڵ�ַ(���ַ)
	.STACK      100     ;��ջ�ζ���
	.DATA               ;���ݶζ���
BUFFER          DB      8 DUP(?);��ʾ������
Counter		DB	?       ;�жϴ���������
ReDisplayFlag	DB	0   ;��ʾ��־

	.CODE               ;�����
START:  	MOV     AX,@DATA ;�����ݶε�ַ
        	MOV     DS,AX
        	MOV	    ES,AX
        	NOP
        	CALL	Init8259 ;���ó�ʼ��8259A�ӳ���
        	CALL	WriIntver;���ó�ʼ���ж�ʸ���ӳ���
		MOV	Counter,0	;�жϴ�����������0
		MOV	ReDisplayFlag,1	;������ʾ��־(1Ϊ��Ҫ��ʾ,0Ϊ����ʾ)
		STI			;���ж�
START1:		CMP	ReDisplayFlag,0
		    JZ	START1
		CALL	LedDisplay  ;Ҫ��ʾ,������ʾ�����ӳ���
		MOV	ReDisplayFlag,0 ;������ʾ��־Ϊ0
		JMP	START1         ;ѭ��,�ȴ��ж�
Init8259	PROC	NEAR  ;��ʼ��8259A�ӳ���
		MOV	DX,IO8259_0   ;ż�˿ڵ�ַ��DX
		MOV	AL,13H        ;доƬ���Ƴ�ʼ��������(ICW1),13H��ʾҪ�趨8259A�Ĺ�
;����ʽΪ��Ƭ��ʽ,�źŴ�����ʽΪ�������ش���,������ICW4
		OUT	DX,AL  ; доƬ���Ƴ�ʼ��������(ICW1)
		MOV	DX,IO8259_1; ��˿ڵ�ַ��DX
		MOV	AL,08H ;�趨�ж����ͺŻ�ֵ(��IR0��Ӧ���ж����ͺ�Ϊ08H)
		OUT	DX,AL;д�ж����ͺų�ʼ��������(ICW2)
		MOV	AL,09H; �����жϷ�ʽ,09H��ʾ�жϷ�ʽΪ����,���Զ�����
		OUT	DX,AL;д�жϷ�ʽ���Ƴ�ʼ��������(ICW4)
		MOV	AL,0FEH; 0FEH��ʾ����IR0���ж�,��������
		OUT	DX,AL ;д�ж����ο�����(OCW1)
		RET
Init8259	ENDP
;**�ж�������ʼ������,��ָ���������жϷ���������ڵ�ַ���ж����ͺ�08H����Ӧ���ж���������.
WriIntver	PROC	NEAR; �ж�������ʼ���ӳ���,
		PUSH	ES
		MOV	AX,0
		MOV	ES,AX
		MOV	DI,20H;�ж��������ж����ͺ�*4����,�����ж����ͺ�Ϊ08H ,��DI��ֵΪ20H
		LEA	AX,INT_0;�жϷ���������ƫ�Ƶ�ַ��AX
		STOSW    ;д�ִ�ָ��(AX)��(ES:DI),���жϷ���������ƫ�Ƶ�ַ�͵�[20H],[21H]��Ԫ��
		MOV	AX,CS
		STOSW   ;���жϷ��������ڶε�ַ�͵�[22H],[23H]��Ԫ��
		POP	ES
		RET
WriIntver	ENDP

LedDisplay	PROC	NEAR; ��ʾ�����ӳ���
		MOV	AL,Counter;���жϴ����ۼ�ֵ��AL
		MOV	AH,AL     ;�ݴ�AH��
		AND	AL,0FH    ;�����,ȡ����ֵ�ĸ�λ
		MOV	Buffer,AL ;��������ܻ�����Buffer+0��Ԫ�� 
		AND	AH,0F0H   ;�����, ���ε���λ
		ROR	AH,4      ;ѭ������4��,ȡ����ֵ��ʮλ
		MOV	Buffer + 1,AH;������ֵ��ʮλ��������ܻ�����Buffer+1��Ԫ��
		MOV	Buffer + 2,10H		;����λ����Ҫ��ʾ
		MOV	Buffer + 3,10H
		MOV	Buffer + 4,10H
		MOV	Buffer + 5,10H
		MOV	Buffer + 6,10H
		MOV	Buffer + 7,10H
		LEA	SI,Buffer;������ܻ�����Buffer�׵�ַ��SI
		CALL	Display8;�����������ʾģ��
		RET
LedDisplay	ENDP

INT_0:		PUSH	DX;�жϷ����ӳ���
		PUSH	AX
		MOV	AL,Counter  
		ADD	AL,1;�ۼ��жϸ���
		DAA      ;ʮ���Ƶ���
		MOV	Counter,AL;�������ֵ 
		MOV	ReDisplayFlag,1;������ʾ��־
		MOV	DX,IO8259_0  ;8259Aż�˿ڵ�ַ��DX    ???ICW2�������ַ����������
		MOV	AL,20H       ;����ICW2,��EOI����������,�����ж�
		OUT	DX,AL
		POP	AX
		POP	DX
		IRET  ;�жϷ���
END	START


