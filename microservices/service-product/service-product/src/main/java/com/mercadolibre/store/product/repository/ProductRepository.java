package com.mercadolibre.store.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.store.product.entity.Category;
import com.mercadolibre.store.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByCategory(Category category);

}
