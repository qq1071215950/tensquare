package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author jiange
 * @version 1.0
 * @date 2019/12/30 20:28
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {

    /**
     * 搜索文章
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}

