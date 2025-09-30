package com.devsuperior;

import com.devsuperior.entities.Client;
import com.devsuperior.entities.Order;
import com.devsuperior.entities.OrderItem;
import com.devsuperior.entities.Product;
import com.devsuperior.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();

        Client client = new Client(name, email, sdf.parse(birthDate));

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.next();
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        for (int i=0; i < n; i++){
            System.out.println("Enter #" + (i+1) + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();
            System.out.print("Quantity: ");
            int qntProduct = sc.nextInt();
            OrderItem orderItem = new OrderItem(qntProduct, priceProduct,
                    new Product(nameProduct, priceProduct));
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.print(order);


        sc.close();
    }
}