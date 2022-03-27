package com.bezkoder.spring.datajpa.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = NewsStructures.story)
public class Story extends CommonFields{
    final static String type = NewsStructures.article;

    @Column(name = "topic_id")
    private long topicId;

    public Story(long topicId, String title, String url, String gid, String status, boolean run, Timestamp retrievedTime, Timestamp startTime, Timestamp endTime, Timestamp lastVisitTime, String policyName) {
        super(title, url, gid, status, run, retrievedTime, startTime, endTime, lastVisitTime, policyName);
        this.topicId = topicId;
    }

    public Story() {

    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }
}
