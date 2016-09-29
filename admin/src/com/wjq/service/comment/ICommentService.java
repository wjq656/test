package com.wjq.service.comment;

import org.springframework.stereotype.Service;

import com.wjq.bean.Comment;

@Service
public interface ICommentService {
	
	public int saveComment(Comment comment);
}
