package com.assesment.backend.bankservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import com.assesment.backend.bankservice.model.Borrower;
import com.assesment.backend.bankservice.repository.BorrowerRepository;

@Service
public class BorrowerService {
 private final BorrowerRepository borrowerRepository;

    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public Borrower createBorrower(Borrower borrower) {
        // You may add additional validation logic here before saving the borrower
        return borrowerRepository.save(borrower);
    }

    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public Borrower getBorrowerById(Long id) {
        return borrowerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Borrower not found with id: " + id));
    }

    public Borrower updateBorrower(Long id, Borrower updatedBorrower) {
        Borrower existingBorrower = getBorrowerById(id);
        // Update the fields of existingBorrower with the fields of updatedBorrower
        // Handle other logic as needed
        return borrowerRepository.save(existingBorrower);
    }

    public void deleteBorrower(Long id) {
        borrowerRepository.deleteById(id);
    }
}