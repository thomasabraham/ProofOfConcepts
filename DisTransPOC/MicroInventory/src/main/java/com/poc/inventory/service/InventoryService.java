package com.poc.inventory.service;

import com.poc.inventory.entity.ProductInventory;
import java.util.List;

/**
 * InvertoryService interface
 */
public interface InventoryService {

	/**
	 * Get all the products in the inventory
	 *
	 * @return all the products in the inventory
	 */
	List<ProductInventory> getAllProducts();

	/**
	 * Get a specific inventory from the inventory list
	 *
	 * @param inventoryId id of the inventory.
	 * @return the specified ProductInventory
	 */
	ProductInventory getProduct(Long inventoryId);

	/**
	 * Create a new inventory in the inventory list
	 *
	 * @param productInventory the inventory to be created
	 * @return the created inventory item
	 */
	ProductInventory createProduct(ProductInventory productInventory);

	/**
	 * Update an inventory in the inventory list
	 *
	 * @param productInventory the inventory to be updated
	 * @return the updated inventory item
	 */
	ProductInventory updateProduct(ProductInventory productInventory);
}
