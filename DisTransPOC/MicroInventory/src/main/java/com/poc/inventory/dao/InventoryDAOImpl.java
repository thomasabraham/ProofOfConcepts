package com.poc.inventory.dao;

import com.poc.inventory.entity.ProductInventory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * InventoryDAO implementation
 */
@Component
public class InventoryDAOImpl implements InventoryDAO {

	private static final Logger LOG = LoggerFactory.getLogger(InventoryDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProductInventory> getAllProducts() {
		LOG.debug("-> getAllProducts");
		List<ProductInventory> products = entityManager.createQuery("SELECT t from "
				+ ProductInventory.class.getSimpleName() + " t").getResultList();
		LOG.debug("<- getAllProducts returning {} products", products.size());
		return products;
	}

	@Override
	public ProductInventory getProduct(Long inventoryId) {
		LOG.debug("-> getProduct inventoryId={}", inventoryId);
		ProductInventory product = entityManager.find(ProductInventory.class, inventoryId);
		LOG.debug("<- getProduct returning product {}", product);
		return product;
	}

	@Override
	public ProductInventory createProduct(ProductInventory productInventory) {
		LOG.debug("-> createProduct product={}", productInventory);
		entityManager.persist(productInventory);
		entityManager.flush();
		LOG.debug("<- createProduct returning product {}", productInventory);
		return productInventory;
	}

	@Override
	public ProductInventory updateProduct(ProductInventory productInventory) {
		LOG.debug("-> updateProduct product={}", productInventory);
		entityManager.merge(productInventory);
		entityManager.flush();
		LOG.debug("<- updateProduct returning product {}", productInventory);
		return productInventory;
	}
}
