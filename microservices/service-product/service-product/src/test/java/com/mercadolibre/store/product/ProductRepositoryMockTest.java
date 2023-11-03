package com.mercadolibre.store.product;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mercadolibre.store.product.entity.Category;
import com.mercadolibre.store.product.entity.Product;
import com.mercadolibre.store.product.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryMockTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void whenFindByCategory_thenReturnListProduct() {
		Product product01 = Product.builder()
				.name("computer")
				.category(Category.builder().id(1l).build())
				.description("")
				.stock(Double.parseDouble("10"))
				.price(Double.parseDouble("1240.99"))
				.status("Created")
				.createAt(new Date())
				.build();
		productRepository.save(product01);
		
		List<Product> founds = productRepository.findByCategory(product01.getCategory());
		
		Assertions.assertThat(founds.size()).isEqualTo(3);
	}

}
