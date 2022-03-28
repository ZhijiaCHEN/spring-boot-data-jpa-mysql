package com.bezkoder.spring.datajpa.controller;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Article;
import com.bezkoder.spring.datajpa.repository.ArticleRepository;

@RestController
@RequestMapping("/data")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    // @GetMapping("/article")
    // public ResponseEntity<List<Article>> getAllTutorials(@RequestParam(required = false) Date publishedDate) {
    //     try {
    //         List<Article> article = new ArrayList<Article>();

    //         if (publishedDate == null)
    //             articleRepository.findAll().forEach(article::add);
    //         else
    //             articleRepository.findByPublishedTimeBetween(new Timestamp(publishedDate.getTime()), new Timestamp((publishedDate + 1).getTime())).forEach(article::add);

    //         if (article.isEmpty()) {
    //             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //         }

    //         return new ResponseEntity<>(article, HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") long id) {
        Optional<Article> article = articleRepository.findById(id);

        if (article.isPresent()) {
            return new ResponseEntity<>(article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/article")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        try {
            Article _article = articleRepository
                    .save(new Article(article.getTopicId(), article.getStoryId(), article.getOutletId(), article.getAuthor(), article.getPublishedTime(), article.getCommentCount(), article.getTweetCount(), article.getRedditCount(), article.getTitle(), article.getUrl(), article.getGid(), article.getStatus(), article.getRun(), article.getRetrievedTime(), article.getStartTime(), article.getEndTime(), article.getLastVisitTime(), article.getPolicyName()));
            return new ResponseEntity<>(_article, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody Article article) {
        Optional<Article> articleData = articleRepository.findById(id);

        if (articleData.isPresent()) {
            Article _article = articleData.get();
            _article.setAuthor(article.getAuthor());
            _article.setCommentCount(article.getCommentCount());
            _article.setEndTime(article.getEndTime());
            _article.setGid(article.getGid());
            _article.setLastVisitTime(article.getLastVisitTime());
            _article.setOutletId(article.getOutletId());
            _article.setPolicyName(article.getPolicyName());
            _article.setPublishedTime(article.getPublishedTime());
            _article.setRedditCount(article.getRedditCount());
            _article.setRetrievedTime(article.getRetrievedTime());
            _article.setRun(article.getRun());
            _article.setStartTime(article.getStartTime());
            _article.setStatus(article.getStatus());
            _article.setStoryId(article.getStoryId());
            _article.setTitle(article.getTitle());
            _article.setTopicId(article.getTopicId());
            _article.setTweetCount(article.getTweetCount());
            _article.setUrl(article.getUrl());
            return new ResponseEntity<>(articleRepository.save(_article), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @DeleteMapping("/article/{id}")
    // public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    //     try {
    //         articleRepository.deleteById(id);
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @DeleteMapping("/article")
    // public ResponseEntity<HttpStatus> deleteAllTutorials() {
    //     try {
    //         articleRepository.deleteAll();
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @GetMapping("/article/by status/{status}")
    public ResponseEntity<List<Article>> findByStatus(@PathVariable("status") String status) {
        try {
            List<Article> article = articleRepository.findByStatus(status);

            if (article.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(article, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/article/by story/{storyId}")
    public ResponseEntity<List<Article>> findByStory(@PathVariable("storyId") Long storyId) {
        try {
            System.out.println("Find by story id of " + storyId.toString());
            List<Article> article = articleRepository.findByStoryId(storyId);

            if (article.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(article, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/article/by topic/{topicId}")
    public ResponseEntity<List<Article>> findByTopic(@PathVariable("topicId") Long topicId) {
        try {
            List<Article> article = articleRepository.findByTopicId(topicId);

            if (article.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(article, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/article/by gid/{gid}")
    public ResponseEntity<List<Article>> findByGid(@PathVariable("gid") String gid) {
        try {
            List<Article> article = articleRepository.findByGid(gid);

            if (article.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(article, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/article/by outlet/{outletId}")
    public ResponseEntity<List<Article>> findByOutlet(@PathVariable("outletId") Long outletId) {
        try {
            List<Article> article = articleRepository.findByOutletId(outletId);

            if (article.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(article, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
