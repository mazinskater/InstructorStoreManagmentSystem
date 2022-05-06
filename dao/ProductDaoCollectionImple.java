package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.EmptyStoreException;
import model.ProductPojo;

public class ProductDaoCollectionImple implements ProductDAO {
	
	//this is the data store
	List<ProductPojo> allProducts = new ArrayList<ProductPojo>();
	
	public ProductDaoCollectionImple() {
		ProductPojo product1 = new ProductPojo(101, "Apples", "Tasty Juicy Apples!", 10, "");
		ProductPojo product2 = new ProductPojo(102, "Bananas", "Delicious Bananas!", 8, "");
		ProductPojo product3 = new ProductPojo(103, "Oranges", "Tart Juicy Oranges!", 5, "");
		allProducts.add(product1);
		allProducts.add(product2);
		allProducts.add(product3);
	}

	@Override
	public ProductPojo addProduct(ProductPojo productPojo) {
		//generate the new product id
		int newProductId = allProducts.get(allProducts.size() - 1).getProductId() + 1;
		//set it in the product pojo
		productPojo.setProductId(newProductId);
		//add the product to the data store
		allProducts.add(productPojo);
		return productPojo;
	}

	@Override
	public ProductPojo updateProduct(ProductPojo productPojo) {
		for(int i=0; i<allProducts.size(); i++) {
			if(allProducts.get(i).getProductId() == productPojo.getProductId()) {
				allProducts.set(i, productPojo); //when match found, assign the found reference variable to foundProduct
				break;
			}
		}
		return productPojo;
	}
	

	@Override
	public void deleteProduct(int productId) {
		// iterator
		Iterator<ProductPojo> allProductsItr = allProducts.iterator();
		while(allProductsItr.hasNext()) {
			ProductPojo getProduct = allProductsItr.next();
			if(getProduct.getProductId() == productId) {
				allProducts.remove(getProduct);
				break;
			}
		}
	}

	@Override
	public List<ProductPojo> getAllProducts()throws EmptyStoreException {
		if(allProducts.isEmpty()) {
			EmptyStoreException ese = new EmptyStoreException();
			throw ese;
		}
		return allProducts;
	}

	@Override
	public ProductPojo getAProduct(int productId) {
		ProductPojo foundProduct = null;
		for(int i=0; i<allProducts.size(); i++) {
			if(allProducts.get(i).getProductId() == productId) {
				foundProduct = allProducts.get(i); //when match found, assign the found reference variable to foundProduct
				break;
			}
		}
		return foundProduct;
	}

}
