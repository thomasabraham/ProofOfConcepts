package com.poc.inventory.rest;

import com.poc.inventory.entity.ProductInventory;
import com.poc.inventory.service.InventoryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * REST controller for Inventory service
 */
@Controller
@RequestMapping("/api/inventory")
public class InventoryController {

	private static final Logger LOG = LoggerFactory.getLogger(InventoryController.class);
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "/v1", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductInventory> getAllProducts() {
		LOG.info("-> getAllProducts");
		List<ProductInventory> products = inventoryService.getAllProducts();
		LOG.info("<- getAllProducts retruning {} products", products.size());
		return products;
	}

	@RequestMapping(value = "/v1/{inventoryId}", method = RequestMethod.GET)
	@ResponseBody
	public ProductInventory getProduct(@PathVariable Long inventoryId) {
		LOG.info("-> getProduct inventoryId={}", inventoryId);
		ProductInventory product = inventoryService.getProduct(inventoryId);
		LOG.info("<- getProduct retruning  product {}", product);
		return product;
	}

	@RequestMapping(value = "/v1", method = RequestMethod.POST)
	@ResponseBody
	public ProductInventory createProduct(@RequestBody ProductInventory productInventory) {
		LOG.info("-> createProduct productInventory={}", productInventory);
		productInventory = inventoryService.createProduct(productInventory);
		LOG.info("<- createProduct returning product {}", productInventory);
		return productInventory;
	}

	@RequestMapping(value = "/v1", method = RequestMethod.PUT)
	@ResponseBody
	public ProductInventory updateProduct(@RequestBody ProductInventory productInventory) {
		LOG.info("-> updateProduct productInventory={}", productInventory);
		productInventory = inventoryService.updateProduct(productInventory);
		LOG.info("<- updateProduct returning product {}", productInventory);
		return productInventory;
	}
}
