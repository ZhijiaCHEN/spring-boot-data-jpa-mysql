package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bezkoder.spring.datajpa.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByStatus(String status);
    List<Article> findByTopicId(Long topicId);
    List<Article> findByStoryId(Long storyId);
    List<Article> findByOutletId(Long outletId);
    List<Article> findByGid(String gid);
    //List<Article> findByPublishedTimeBetween(Timestamp dayBegin, Timestamp dayEnd);
}
