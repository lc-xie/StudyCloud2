package com.example.stephen.studycloud2.bean;

/**
 * Created by stephen on 17-5-15.
 */

public class ExamPaper {
  /*  public static final int SUBJECT_MATH=1;
    public static final int SUBJECT_CHINESE=2;
    public static final int SUBJECT_ENGLISH=3;
*/
    private String subject;
    private String title;
    private double price;
    private String detail;
    private int ammount;

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String sunbject) {
        this.subject = sunbject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
