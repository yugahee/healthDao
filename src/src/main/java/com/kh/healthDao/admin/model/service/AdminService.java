package com.kh.healthDao.admin.model.service;

import java.util.List;
import java.util.Map;

import com.kh.healthDao.admin.model.vo.Product;

public interface AdminService {
		
	// 상품 등록
	 public int registProduct(Product product);
	 
	// 재고내역
	Map<String, Object> inventoryPaging(int page);

	public Product pLPopupSu(Product product);

	public int stockPlus(Product product);


	public int registCategory(Product product);

	public int registOption(Product product);

	// List<Product> listProduct(Product product);

	public int insertproductStock(Product product);

	// public List<Product> listProductInventory(Map<String, Object> pageRow);


	
	

}