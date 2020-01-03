package com.tensquare.article.dao;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jiange
 * @version 1.0
 * @date 2019/12/30 15:34
 */
public interface CommentDao extends MongoRepository<Comment, String> {

}
