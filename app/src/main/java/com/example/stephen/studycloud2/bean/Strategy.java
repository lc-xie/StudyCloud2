package com.example.stephen.studycloud2.bean;

import java.util.Date;

/**
 * Created by stephen on 17-4-16.
 */

public class Strategy {
    private int readtimes;
    private String title;
    private String content;
    private String author;
    private Date writedTime;
    private String mark;

    public int getReadtimes() {
        return readtimes;
    }

    public void setReadtimes(int readtimes) {
        this.readtimes = readtimes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
