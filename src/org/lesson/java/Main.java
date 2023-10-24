package org.lesson.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

            System.out.println("----------------");

            books[i] = new Libro(name, bookPages,author,publisher);

        }

        scanner.close();

        // Scrivo i dati dei libri in un file

        FileWriter writer = null;

        try {
            writer = new FileWriter("./resources/booksList.txt");
            for (int i = 0; i < books.length; i++) {
                writer.write(books[i].getTitle() + ";" + books[i].getNumberOfPage() + ";" + books[i].getAuthor() + ";"
                        + books[i].getPublisher());
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Unable to open file!");
        } finally {
            try {
                if (writer != null) {
                    System.out.println("File closed!");
                    System.out.println("----------------");
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Leggo il file booksList

        File booksList = new File("./resources/booksList.txt");

        Scanner fileReader = null;

        try {
            fileReader = new Scanner(booksList);

            while (fileReader.hasNextLine()) {
                String book = fileReader.nextLine();
                System.out.println(book);
            }
            System.out.println("----------------");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } finally {
            try {
                if (writer != null) {
                    System.out.println("File closed!");
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
