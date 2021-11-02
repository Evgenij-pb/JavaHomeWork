package com.pb.frolov.hw5;

public class Library {
    public static void main(String[] args) {

        Book[] books = new Book[4];
        Reader [] readers = new Reader[4];

        books[0]= new Book("История Украины", "Лебедева Ю.Г", 2011);
        books[1]= new Book("Украинский язык", "Сичова В.Т.", 2012);
        books[2]= new Book("Экономика", "Радионова И.Ф.", 2010);
        books[3]= new Book("Английский язык", "Калинина Л.В", 2014);

        readers[0]=new Reader("Иванов Д. В.",12345,"Экономический факультет","25.03.2001","0997889951");
        readers[1]=new Reader("Мальцева А. М.",12346,"Факультет информационных технологий","13.06.2001","0676332512");
        readers[2]=new Reader("Климов С. Т.",12349,"Химический факультет","27.08.2002","0985423388");
        readers[3]=new Reader("Уткин К. А.",12355,"Факультет психологии","8.12.2000","0995621478");

        System.out.println("Список книг:");
        for (int i=0; i<books.length; i++){
            System.out.println(i+1+": "+books[i].getBookInfo());
        }

        System.out.println("\nСписок читателей:");
        for (int i=0; i<books.length; i++){
            System.out.println(i+1+": "+readers[i].getFullName());
        }

        System.out.println("\nполная информация о пользователе "+readers[2].getFullName());
        System.out.println(readers[2].getReaderInfo());

        System.out.println("\n");
        readers[1].takeBook(2);
        readers[3].returnBook(3);

        System.out.println("\n");
        readers[0].takeBook("Словарь","Мастер и Маргарита","Химия");
        readers[3].returnBook("Война и мир","Java для начинающих","Экономика");

        System.out.println("\n");
        readers[2].takeBook(books[0],books[3]);
        System.out.println("\n");
        readers[1].returnBook(books[1],books[2]);
    }
}
