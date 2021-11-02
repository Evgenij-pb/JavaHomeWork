package com.pb.frolov.hw5;

public class Reader {
    private String fullName;
    private int ticketID;
    private String faculty;
    private String dateOfBirth;
    private String phoneNumber;

    public Reader(String fullName, int ticketID, String faculty, String dateOfBirth, String phoneNumber){
        this.fullName=fullName;
        this.ticketID=ticketID;
        this.faculty=faculty;
        this.dateOfBirth=dateOfBirth;
        this.phoneNumber=phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

/*------------------------------------------------------------------
takeBook, принимает количество взятых книг.
Выводит на консоль сообщение
"Петров В. В. взял 3 книги".
*/
    public void takeBook(int booksCount){
        System.out.println(fullName+" взял "+booksCount+ " книг(и)");
    }

/*-------------------------------------------------------------------
takeBook принимает переменное количество названий книг.
Выводит на консоль сообщение
"Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
*/

    public void takeBook (String... booksNames){
    System.out.print(fullName+" взял книгу(и): ");
    for (String bookName: booksNames){
        System.out.print(bookName+", ");
        }
    System.out.println();
    }

/*-----------------------------------------------------------------------------
takeBook, который будет принимать переменное количество объектов класса Book.
Выводит на консоль сообщение
"Петров В. В. взял книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
*/

    public void takeBook (Book... books){
        System.out.println(fullName+" взял книгу(и): ");
        int i=1;
        for(Book book: books ){
            System.out.println((i++)+": "+book.getBookName()+", "+book.getAutor()+", "+book.getYear()+"г.");
        }
    }

/*
Аналогичным образом создаем метод returnBook().
*/
    public void returnBook (int booksCount){
        System.out.println(fullName+" вернул "+booksCount+ " книг(и)");
    }

    public void returnBook (String... booksNames){
        System.out.print(fullName+" вернул книгу(и): ");
        for (String bookName: booksNames){
            System.out.print(bookName+", ");
        }
        System.out.println();
    }

    public void returnBook (Book... books){
        System.out.println(fullName+" вернул книгу(и): ");
        int i=1;
        for(Book book: books ){
            System.out.println((i++)+": "+book.getBookName()+", "+book.getAutor()+", "+book.getYear()+"г.");
        }
    }

// метод getReaderInfo возвращает подробную информацию о читателе
    public String getReaderInfo(){
        return "ФИО: "+fullName+
                "\nномер читательского билета: "+ticketID+
                "\nфакультет: "+faculty+
                "\nдата рождения: "+dateOfBirth+
                "\nномер телефона: "+phoneNumber;
    }


}