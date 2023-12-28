package model.dao;

import model.entities.Product;

public interface ProductDao {

	Product findByProduct (Long codProduct);
	
}
