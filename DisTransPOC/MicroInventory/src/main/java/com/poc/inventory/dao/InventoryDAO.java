package com.poc.inventory.dao;

import com.poc.inventory.entity.ProductInventory;
import java.util.List;

/**
 * InventoryDAO interface
 */
public interface InventoryDAO {

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
	 * @param productInventory the inventory to be update
	 * @return the updated inventory item
	 */
	ProductInventory updateProduct(ProductInventory productInventory);
}
