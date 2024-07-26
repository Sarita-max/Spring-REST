package com.example.register_login_demo.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.register_login_demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
