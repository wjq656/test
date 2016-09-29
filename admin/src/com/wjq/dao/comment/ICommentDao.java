package com.wjq.dao.comment;

import org.springframework.stereotype.Component;

import com.wjq.bean.Comment;

@Component
public interface ICommentDao {
	
	 public int saveComment(Comment comment);
}
