package com.example.LibraryMgmnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryMgmnt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
