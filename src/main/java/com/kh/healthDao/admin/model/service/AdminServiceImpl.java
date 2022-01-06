package com.kh.healthDao.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.healthDao.admin.model.dao.AdminMapper;
import com.kh.healthDao.admin.model.vo.Product;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	private final AdminMapper adminMapper; 
	
	@Autowired
	public AdminServiceImpl(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}
	
	

	@Override
	public void registNewProduct(Product newProduct) {
		
	}
	

	// 상품 등록
	@Override
	public int RegistProduct(Product product) {
		return adminMapper.RegistProduct(product);
	}

	@Override
	public List<Product> listProductInventory() {
		
		return adminMapper.listProductInventory();
	}


	// 재고 수량 입력
	@Override
	public int insertproductStock(Product product) {
		return adminMapper.insertproductStock(product);
	}

	
	
	
	
	

}
