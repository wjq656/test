package com.wjq.service.comment.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjq.bean.Comment;
import com.wjq.dao.comment.ICommentDao;
import com.wjq.service.comment.ICommentService;

@Service
public class CommentService implements ICommentService{
	
	@Autowired
	private ICommentDao commentDao;
	@Override
	public int saveComment(Comment comment) {
		return commentDao.saveComment(comment);
	}

}
