package com.assesment.backend.bankservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.backend.bankservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}