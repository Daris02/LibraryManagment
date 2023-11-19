package com.prog.model;


import java.sql.Date;

public class Book {
    private String id;
    private String bookName;
    private Author author;
    private String topic;
    private Date releaseDate;

    public Book(String id, String bookName, Author author, String topic, Date releaseDate) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.topic = topic;
        this.releaseDate = releaseDate;
    }

    public Book(String bookName, Author author, String topic, Date releaseDate) {
        this.bookName = bookName;
        this.author = author;
        this.topic = topic;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "\n\tid='" + id + '\'' +
                ", \n\tbookName='" + bookName + '\'' +
                ", \n\tauthor=" + author +
                ", \n\ttopic=" + topic +
                ", \n\treleaseDate=" + releaseDate +
                "\n}";
    }
}
