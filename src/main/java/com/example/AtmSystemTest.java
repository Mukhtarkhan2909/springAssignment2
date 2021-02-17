package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.*;
import java.util.Scanner;

public class AtmSystemTest {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "bean.xml");
        DatabaseConnection connection = context.getBean("databaseConnection", DatabaseConnection.class);
        Scanner s = new Scanner(System.in);
        String userName = null;
        int userCardNumber = 0;
        int userPinCode = 0;
        int userBalance = 0;
        loop:
        while (true) {
            ResultSet resultSet = connection.getResultSet();
            System.out.println("Enter your username");
            String name = s.next();
            while (resultSet.next()) {
                if (resultSet.getString("user_name").equalsIgnoreCase(name)) {
                    userName = resultSet.getString("user_name");
                    userCardNumber = resultSet.getInt("user_card_number");
                    userPinCode = resultSet.getInt("user_pin_code");
                    userBalance = resultSet.getInt("user_balance");
                    break;
                }
            }
            if (userName != null) {
                System.out.println("Enter the card number");
                int cardNumber = s.nextInt();
                System.out.println("Enter the pin code");
                int pinCode = s.nextInt();
                if (userCardNumber == cardNumber && userPinCode == pinCode) {
                    System.out.println("Choose operation");
                    System.out.println("1. Check balance" +
                            "\n2. Withdraw" +
                            "\n3. Top up" +
                            "\n4. Exit");
                    int ch = s.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.println("Your balance is: " + userBalance);
                            break;
                        case 2:
                            System.out.println("Enter withdraw amount");
                            int withdraw = s.nextInt();
                            if (withdraw <= userBalance) {
                                connection.updateBalance(userBalance - withdraw, userName);
                            } else {
                                System.out.println("Your balance is less than " + withdraw);
                            }
                            System.out.println("Now your balance is: " + userBalance);
                            break;
                        case 3:
                            System.out.println("Enter top up amount");
                            int topUp = s.nextInt();
                            connection.updateBalance(userBalance + topUp, userName);
                            System.out.println("Now your balance is: " + userBalance);
                            break;
                        case 4:
                            break loop;
                    }
                } else {
                    System.out.println("Pin code or password is incorrect");
                }
            } else {
                System.out.println("Account not found");
            }
        }
        context.close();
    }
}
