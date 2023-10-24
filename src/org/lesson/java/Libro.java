package org.lesson.java;

public class Libro {

    // VARIABILI
    private String title;
    private int numberOfPage;
    private String author;
    private String publisher;

    // COSTRUTTORI
    public Libro(String title, int numberOfPage, String author, String publisher) throws IllegalArgumentException{

        validateTitle(title);
        validatePageNumber(numberOfPage);
        validateAuthorName(author);
        validatePublisher(publisher);
        this.title = title;
        this.numberOfPage = numberOfPage;
        this.author = author;
        this.publisher = publisher;
    }

    // METODI
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        validatePageNumber(numberOfPage);
        numberOfPage = numberOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        validateAuthorName(author);
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        validatePublisher(publisher);
        this.publisher = publisher;
    }

    // Validatori
    private void validateTitle(String title) {
        if(title.isEmpty()) {
            throw new IllegalArgumentException("The title's name cannot be empty");
        }
    }

    private void validatePageNumber(int numberOfPage) {
        if(numberOfPage <= 0) {
            throw new IllegalArgumentException("The number of pages must be greater than 0");
        }
    }

    private void validateAuthorName(String author) {
        if(author.isEmpty()) {
            throw new IllegalArgumentException("The author's name cannot be empty");
        }
    }

    private void validatePublisher(String publisher) {
        if(publisher.isEmpty()) {
            throw new IllegalArgumentException("The publisher's name cannot be empty");
        }
    }

    // toString
    @Override
    public String toString() {
        return "Libro{" +
                "title:" + title +
                ", number of Page: " + numberOfPage +
                ", author: " + author  +
                ", publisher: " + publisher +
                '}';
    }
}
