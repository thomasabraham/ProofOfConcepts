package com.poc.inventory.service;

import com.poc.inventory.dao.InventoryDAO;
import com.poc.inventory.entity.ProductInventory;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * InventoryService implementation
 */
@Component
@Transactional
public class InventoryServiceImpl implements InventoryService {

	private static final Logger LOG = LoggerFactory.getLogger(InventoryServiceImpl.class);
	@Autowired
	private InventoryDAO inventoryDAO;

	@Override
	public List<ProductInventory> getAllProducts() {
		LOG.debug("-> getAllProducts");
		List<ProductInventory> products = inventoryDAO.getAllProducts();
		LOG.debug("<- getAllProducts returning {} products", products.size());
		return products;
	}

	@Override
	public ProductInventory getProduct(Long inventoryId) {
		LOG.debug("-> getProduct inventoryId={}", inventoryId);
		ProductInventory product = inventoryDAO.getProduct(inventoryId);
		LOG.debug("<- getProduct returning product {}", product);
		return product;
	}

	@Override
	public ProductInventory createProduct(ProductInventory productInventory) {
		LOG.debug("-> createProduct productInventory={}", productInventory);
		ProductInventory product = inventoryDAO.createProduct(productInventory);
		LOG.debug("<- createProduct returning product {}", productInventory);
		return product;
	}

	@Override
	public ProductInventory updateProduct(ProductInventory productInventory) {
		LOG.debug("-> updateProduct productInventory={}", productInventory);
		ProductInventory product = inventoryDAO.updateProduct(productInventory);
		LOG.debug("<- updateProduct returning product {}", productInventory);
		return product;
	}

}
