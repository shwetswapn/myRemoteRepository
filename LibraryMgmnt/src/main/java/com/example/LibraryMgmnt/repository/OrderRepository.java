package com.example.LibraryMgmnt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryMgmnt.model.BookDetails;
import com.example.LibraryMgmnt.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	

}
