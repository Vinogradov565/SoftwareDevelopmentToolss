package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Выберите действие: ");
            System.out.println("1 - Войти");
            System.out.println("2 - Зарегистрироваться");
            System.out.println("3 - Выход");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.println("Введите логин:");
        String login = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        String storedPassword = users.get(login);
        if (storedPassword == null || !storedPassword.equals(password)) {
            System.out.println("Неверный логин или пароль.");
        } else {
            System.out.println("Успешная авторизация!");
            logout(scanner);
        }
    }

    private static void register(Scanner scanner) {
        System.out.println("Введите логин:");
        String login = scanner.nextLine();
        String storedPassword = users.get(login);
        if (storedPassword != null) {
            System.out.println("Пользователь с таким логином уже зарегистрирован.");
        } else {
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();
            users.put(login, password);
            System.out.println("Регистрация прошла успешно!");
            logout(scanner);
        }
    }

    private static void logout(Scanner scanner) {
        System.out.println("Вы вошли в систему. Что вы хотите сделать?");
        System.out.println("1 - Выйти");
        System.out.println("2 - Зарегистрироваться под другим именем");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                break;
            case 2:
                register(scanner);
                break;
            default:
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
        }
    }
}
