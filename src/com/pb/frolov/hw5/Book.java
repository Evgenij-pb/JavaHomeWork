package com.pb.frolov.hw5;

public class Book {
    private String bookName;
    private String autor;
    private int year;

    public Book(String bookName, String autor, int year){
        this.bookName = bookName;
        this.autor=autor;
        this.year=year;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBookInfo(){
        return bookName+", "+autor+", "+year+"г.";
    }
}
