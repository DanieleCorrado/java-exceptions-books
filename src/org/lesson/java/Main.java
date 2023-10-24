package org.lesson.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many books do you want to add? ");
        int booksNumber = Integer.parseInt(scanner.nextLine());
        Libro[] books = new Libro[booksNumber];

        for (int i = 0; i < booksNumber; i++) {

            System.out.print("Enter the title of the book: ");
            String name = scanner.nextLine();

            // controllo se il valore inserito è un intero

            int bookPages = 0;

            try {
                System.out.print("Enter the number of pages: ");
                bookPages = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid number!");
            }

            System.out.print("Enter the author's name: ");
            String author = scanner.nextLine();

            System.out.print("Enter the publisher's name: ");
            String publisher = scanner.nextLine();

            books[i] = new Libro(name, bookPages,author,publisher);
        }

        for (int i = 0; i < booksNumber; i++) {
            System.out.println(books[i]);
        }

        scanner.close();
    }
}
