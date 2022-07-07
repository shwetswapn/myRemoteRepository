package com.example.LibraryMgmnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryMgmnt.model.BookDetails;

public interface BookRepository extends JpaRepository<BookDetails, Long> {

}
