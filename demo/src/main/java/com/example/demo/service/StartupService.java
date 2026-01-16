package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Address;
import com.example.demo.entity.Book;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Order;
import com.example.demo.entity.PhysicalBook;

@Service
@Transactional(rollbackFor = Exception.class)
public class StartupService {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private BookService bookService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private PhysicalBookService physicalBookService;

	@Autowired
	private EmployeeService employeeService;

	public void createExampleData() {
		// Address
		Address address1 = createAddress(new Address("Polska", "Warszawa", "Warszawska", "12", "37-095"));
		Address address2 = createAddress(new Address("Polska", "Wrocław", "Wrocławska", "28", "36-480"));
		Address address3 = createAddress(new Address("Polska", "Kraków", "Krakowska", "18", "35-390"));

		// Employee

		Employee employee1 = createEmployee(new Employee("Jan", "Kowalski"));
		Employee employee2 = createEmployee(new Employee("Maria", "Malinowska"));
		Employee employee3 = createEmployee(new Employee("Michał", "Kwiatkowski"));

		// Customer

		Customer customer1 = createCustomer(new Customer("Anna", "Malinowska", "980523xxxxx"));
		customer1.setAddress(address1);
		Customer customer2 = createCustomer(new Customer("Jan", "Kowalski", "800712xxxxx"));
		customer2.setAddress(address2);
		Customer customer3 = createCustomer(new Customer("Katarzyna", "Zalewska", "900205xxxxx"));
		customer3.setAddress(address2);
		Customer customer4 = createCustomer(new Customer("Michał", "Zakrzyński", "941119xxxxx"));
		customer4.setAddress(address2);

		System.out.println(customer1);
		System.out.println(customer2);
		System.out.println(customer3);

		// Book

		Book book1 = createBook(new Book("Krew i popiół", "Jennifer L. Armentrout", 2021, "123948hB9"));
		Book book2 = createBook(new Book("Królestwo ciała i ognia", "Jennifer L. Armentrout", 2022, "84784jH45"));
		Book book3 = createBook(new Book("Księga upadłych aniołów", "Emilia J.Lee", 2024, "947362K06"));
		Book book4 = createBook(new Book("Obca", "Diana Gabaldon", 1991, "763489W76"));

		PhysicalBook physicalBook1 = createPhysicalBook(new PhysicalBook(book1, "PB/13"));
		createPhysicalBook(new PhysicalBook(book1, "PB/57", "zniszczona okładka"));
		createPhysicalBook(new PhysicalBook(book1, "PB/134", "brak strony 282"));
		createPhysicalBook(new PhysicalBook(book1, "PB/79", "plama na stronie 101"));
		PhysicalBook physicalBook2 = createPhysicalBook(new PhysicalBook(book2, "PB/29"));
		createPhysicalBook(new PhysicalBook(book2, "PB/15", "plama na stronie 12"));
		PhysicalBook physicalBook3 = createPhysicalBook(new PhysicalBook(book3, "PB/53"));
		createPhysicalBook(new PhysicalBook(book3, "PB/87", "wyrwana strona 237"));
		PhysicalBook physicalBook4 = createPhysicalBook(new PhysicalBook(book4, "PB/157"));
		createPhysicalBook(new PhysicalBook(book4, "PB/41"));
		createPhysicalBook(new PhysicalBook(book4, "PB/88", "zniszczona okładka"));
		// Orders

		// Order1
		Order order1 = new Order();
		order1.setCustomer(customer1);
		order1.setEmployee(employee1);

		List<PhysicalBook> order1Book = new ArrayList<>();
		order1Book.add(physicalBook1);
		order1Book.add(physicalBook2);
		order1.setPhysicalBooks(order1Book);
		createOrder(order1);

		// Order2
		Order order2 = new Order();
		order2.setCustomer(customer2);
		order2.setEmployee(employee3);

		List<PhysicalBook> order2Book = new ArrayList<>();
		order2Book.add(physicalBook2);
		order2.setPhysicalBooks(order2Book);
		createOrder(order2);

//					Order3
		Order order3 = new Order();
		order3.setCustomer(customer4);
		order3.setEmployee(employee2);

		List<PhysicalBook> order3Book = new ArrayList<>();
		order3Book.add(physicalBook4);
		order3.setPhysicalBooks(order3Book);
		createOrder(order3);

//					Order4
		Order order4 = new Order();
		order4.setCustomer(customer3);
		order3.setEmployee(employee1);

		List<PhysicalBook> order4Book = new ArrayList<>();
		order4Book.add(physicalBook1);
		order4Book.add(physicalBook2);
		order4Book.add(physicalBook3);
		order4Book.add(physicalBook4);
		order4.setPhysicalBooks(order4Book);
		createOrder(order4);

		System.out.println("Utworzono zamówienia: ");
		System.out.println(order1);
		System.out.println(order2);

	}

	private PhysicalBook createPhysicalBook(PhysicalBook pb) {
		return physicalBookService.save(pb);

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

	public Employee createEmployee(Employee employee) {
		return employeeService.save(employee);
	}

}
