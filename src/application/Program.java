package application;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY):");
		LocalDate birthDate = LocalDate.parse(sc.nextLine(), fmt);
		Client client = new Client(clientName, clientEmail, birthDate);
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		Date moment = new Date();
		Order order = new Order(moment, status);

		System.out.print("How many items to this order?");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			sc.nextLine();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice);
			orderItem.setProduct(product);
			order.addItem(orderItem);
		}

		System.out.println("");
		IO.println("ORDER SUMMARY: ");
		IO.println("Order moment: " + sdf.format(moment));
		IO.println("Order status: " + status);

		IO.println(client);
		IO.println("Order items:");

		
		for (OrderItem x : order.getItems()) {
			System.out.println(x);
		}
		
		
		IO.println("Total price: " + String.format("$%.2f", order.total()))	;

		sc.close();
	}

}
