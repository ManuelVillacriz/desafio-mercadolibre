package com.mercadolibre.store.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.store.shopping.entity.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long>{

}
