package presentation;

import java.util.List;
import java.util.Scanner;

import exception.EmptyStoreException;
import model.ProductPojo;
import service.ProductService;
import service.ProductServiceImple;

public class ProductManagmentSystem {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ProductService productService = new ProductServiceImple();
		
		char proceed = 'y';
		
		while(proceed == 'y') {
			System.out.println("****************************");
			System.out.println("PRODUCT MANAGEMENT SYSTEM");
			System.out.println("****************************");
			System.out.println("1. List all Products");
			System.out.println("2. Add a new product");
			System.out.println("3. Delete a Product");
			System.out.println("4. Update a Product");
			System.out.println("5. Exit");
			System.out.println("****************************");
			System.out.println("Please enter an option:");
			
			int option = scan.nextInt();
			
			System.out.println("****************************");
			
			switch(option) {
				case 1:
				List<ProductPojo> everyProduct;
				try {
					everyProduct = productService.getAllProducts();
				} catch (EmptyStoreException e) {
					System.out.println(e.getMessage());
					break;
				}
					System.out.println("***********************");
					System.out.println("ID\tNAME\tDESCRIPTION\tCOST");
					everyProduct.forEach((item)-> System.out.println(item.getProductId() + "\t" + item.getProductName() + "\t" + item.getProductDescription()));
					System.out.println("***********************");
					System.out.println("Do you want to continue?(y/n)");
					proceed = scan.next().charAt(0);
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					System.out.println("***********************");
					System.out.println("Thank you for using Product Management System");
					System.out.println("***********************");
					System.exit(0);
				default:
			}
		}
		System.out.println("***********************");
		System.out.println("Thank you for using Product Management System");
		System.out.println("***********************");
		System.exit(0);
	}

}
