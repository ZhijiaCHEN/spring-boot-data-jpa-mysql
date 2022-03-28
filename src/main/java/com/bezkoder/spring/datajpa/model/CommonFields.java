package com.bezkoder.spring.datajpa.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class CommonFields {

    static String type = "object";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(name = "title")
    protected String title;

    @Column(name = "url")
    protected String url;

    @Column(name = "gid")
    protected String gid;

    @Column(name = "status")
    protected String status;

    @Column(name = "run")
    protected boolean run;

    @Column(name = "retrievedTime")
    protected Timestamp retrievedTime;

    @Column(name = "startTime")
    protected Timestamp startTime;

    @Column(name = "endTime")
    protected Timestamp endTime;

    @Column(name = "lastVisitTime")
    protected Timestamp lastVisitTime;

    @Column(name = "policyName")
    protected String policyName;

    public CommonFields() {

    }

    public CommonFields(String title, String url, String gid, String status, boolean run, Timestamp retrievedTime, Timestamp startTime, Timestamp endTime, Timestamp lastVisitTime, String policyName) {
        this.title = title;
        this.url = url;
        this.gid = gid;
        this.status = status;
        this.run = run;
        this.retrievedTime = retrievedTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lastVisitTime = lastVisitTime;
        this.policyName = policyName;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getGid() {
        return gid;
    }

    public String getStatus() {
        return status;
    }

    public boolean getRun() {
        return run;
    }

    public Timestamp getRetrievedTime() {
        return retrievedTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public Timestamp getLastVisitTime() {
        return lastVisitTime;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void setRetrievedTime(Timestamp retrievedTime) {
        this.retrievedTime = retrievedTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setLastVisitTime(Timestamp lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    @Override
    public String toString(){
        return type + "(" + title + "[" + url + "]" + ")";
    }

}
