package com.bezkoder.spring.datajpa.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = NewsStructures.article)
public class Article extends CommonFields{
    final static String type = NewsStructures.article;

    @Column(name = "topic_id")
    private long topicId;

    @Column(name = "story_id")
    private long storyId;

    @Column(name = "outlet_id")
    private long outletId;

    @Column(name = "author")
    private String author;

    @Column(name = "publishedTime")
    private Timestamp publishedTime;

    @Column(name = "comment_count")
    private int commentCount;

    @Column(name = "tweet_count")
    private int tweetCount;

    @Column(name = "reddit_count")
    private int redditCount;

    public Article(long topicId, long storyId, long outletId, String author, Timestamp publishedTime, int commentCount, int tweetCount, int redditCount, String title, String url, String gid, String status, boolean run, Timestamp retrievedTime, Timestamp startTime, Timestamp endTime, Timestamp lastVisitTime, String policyName) {
        super(title, url, gid, status, run, retrievedTime, startTime, endTime, lastVisitTime, policyName);
        this.topicId = topicId;
        this.storyId = storyId;
        this.outletId = outletId;
        this.author = author;
        this.publishedTime = publishedTime;
        this.commentCount = commentCount;
        this.tweetCount = tweetCount;
        this.redditCount = redditCount;
    }

    public Article() {

    }

    public long getTopicId() {
        return topicId;
    }

    public long getStoryId() {
        return storyId;
    }

    public long getOutletId() {
        return outletId;
    }

    public String getAuthor() {
        return author;
    }

    public Timestamp getPublishedTime() {
        return publishedTime;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getTweetCount() {
        return tweetCount;
    }

    public int getRedditCount() {
        return redditCount;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public void setStoryId(long storyId) {
        this.storyId = storyId;
    }

    public void setOutletId(long outletId) {
        this.outletId = outletId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedTime(Timestamp publishedTime) {
        this.publishedTime = publishedTime;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setTweetCount(int tweetCount) {
        this.tweetCount = tweetCount;
    }

    public void setRedditCount(int redditCount) {
        this.redditCount = redditCount;
    }
}
