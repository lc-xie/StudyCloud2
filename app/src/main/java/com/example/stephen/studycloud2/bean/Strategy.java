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
    private String writedTime;
    private String mark;

    public String getWritedTime() {
        return writedTime;
    }

    public void setWritedTime(String writedTime) {
        this.writedTime = writedTime;
    }

    public String getAuthor() {
        return author;

    }

    public void setAuthor(String author) {
        this.author = author;
    }

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
