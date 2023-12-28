package model.entities;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long codProduct;
	private String descProduct;
	private String descManufacturer;
	
	public Product() {
	}

	public Product(Long codProduct, String descProduct, String descManufacturer) {
		this.codProduct = codProduct;
		this.descProduct = descProduct;
		this.descManufacturer = descManufacturer;
	}

	public Long getCodProduct() {
		return codProduct;
	}

	public void setCodProduct(Long codProduct) {
		this.codProduct = codProduct;
	}

	public String getDescProduct() {
		return descProduct;
	}

	public void setDescProduct(String descProduct) {
		this.descProduct = descProduct;
	}

	public String getDescManufacturer() {
		return descManufacturer;
	}

	public void setDescManufacturer(String descManufacturer) {
		this.descManufacturer = descManufacturer;
	}

	@Override
	public String toString() {
		return "Product [descProduct=" + descProduct + ", descManufacturer=" + descManufacturer + "]";
	}
}
