package com.example.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.library.service.LibraryService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        com.example.library.config.AppConfig.class);

        LibraryService service = context.getBean(LibraryService.class);
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n1. Add Book");
                System.out.println("2. Issue Book");
                System.out.println("3. Return Book");
                System.out.println("4. View Books");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        service.addBook(id, name);
                        break;

                    case 2:
                        System.out.print("Enter Book ID: ");
                        service.issueBook(sc.nextInt());
                        break;

                    case 3:
                        System.out.print("Enter Book ID: ");
                        service.returnBook(sc.nextInt());
                        break;

                    case 4:
                        service.showBooks();
                        break;

                    case 5:
                        System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}