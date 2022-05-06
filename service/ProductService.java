package service;

import java.util.List;

import exception.EmptyStoreException;
import model.ProductPojo;

public interface ProductService {
	
	ProductPojo addProduct(ProductPojo productPojo); //create
	
	ProductPojo updateProduct(ProductPojo productPojo); //update
	
	void deleteProduct(int productId); //delete
	
	List<ProductPojo> getAllProducts() throws EmptyStoreException; //read all
	
	ProductPojo getAProduct(int productId); //read one
	

}
