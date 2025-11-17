package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Address;
import com.example.demo.entity.Book;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.service.AddressService;
import com.example.demo.service.BookService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private BookService bookService;

	@Autowired
	private AddressService addressService;

	@Bean
	public CommandLineRunner commandLineRunner() {

		return runner -> {
			createExampleData();
		};
	}

	private void createExampleData() {
		//			Address
					Address address1 = createAddress(new Address("Polska", "Warszawa", "Warszawska", "12", "37-095"));
					Address address2 = createAddress(new Address("Polska", "Wrocław", "Wrocławska", "28", "36-480"));
					Address address3 = createAddress(new Address("Polska", "Kraków", "Krakowska", "18", "35-390"));
					
		//			Customer 
		
					Customer customer1 = createCustomer(new Customer("Anna", "Malinowska", "980523xxxxx"));
					customer1.setAddress(address1);
					Customer customer2 = createCustomer(new Customer("Jan", "Kowalski", "800712xxxxx"));
					customer2.setAddress(address2);
					Customer customer3 = createCustomer(new Customer("Katarzyna", "Zalewska", "900205xxxxx"));
					customer3.setAddress(address2);
					Customer customer4 = createCustomer(new Customer("Michał", "Zakrzyński", "941119xxxxx"));
					customer3.setAddress(address2);
		
		
					System.out.println(customer1);
					System.out.println(customer2);
					System.out.println(customer3);
					
		//			Book 
		
					Book book1 = createBook (new Book("Debil", "Aleksanda Sarna", 2024, "123948hB9"));
					Book book2 = createBook (new Book("Alfons", "Aleksanda Sarna", 2025, "84784jH45"));
					Book book3 = createBook (new Book("Księga upadłych aniołów", "Emilia J.Lee", 2024, "947362K06"));
					
		//			Orders
					
					
		//			Order1 
					Order order1 = new Order();
					order1.setCustomer(customer1);
		
					List<Book> books1 = new ArrayList<>();
					books1.add(book1);
					books1.add(book2);
					order1.setBooks(books1);
					createOrder(order1);
		
		//			Order2
					Order order2 = new Order();
					order2.setCustomer(customer2);
		
					List<Book> books2 = new ArrayList<>();
					books2.add(book2);
					order2.setBooks(books2);
					createOrder(order2);
		
					System.out.println("Utworzono zamówienia: ");
					System.out.println(order1);
					System.out.println(order2);
	}
	
	public Address createAddress(Address address) {
		return addressService.save(address);
	}

	public Customer createCustomer(Customer customer) {
		return customerService.save(customer);
	}

	public Book createBook(Book book) {
		return bookService.save(book);
		
	}

	public Order createOrder(Order order) {
		return orderService.save(order);
	}
}
