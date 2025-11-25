package com.cszy.po;

import java.util.Date;

public class Articles {
    private Integer id;
    private String articType;
    private String articTitle;
    private String articContent;
    private String author;
    private Date publishDate;
    
    public Articles() {
        super();
    }
    
    public Articles(Integer id, String articType, String articTitle, String articContent, String author, Date publishDate) {
        super();
        this.id = id;
        this.articType = articType;
        this.articTitle = articTitle;
        this.articContent = articContent;
        this.author = author;
        this.publishDate = publishDate;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getArticType() {
        return articType;
    }
    
    public void setArticType(String articType) {
        this.articType = articType;
    }
    
    public String getArticTitle() {
        return articTitle;
    }
    
    public void setArticTitle(String articTitle) {
        this.articTitle = articTitle;
    }
    
    public String getArticContent() {
        return articContent;
    }
    
    public void setArticContent(String articContent) {
        this.articContent = articContent;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Date getPublishDate() {
        return publishDate;
    }
    
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}