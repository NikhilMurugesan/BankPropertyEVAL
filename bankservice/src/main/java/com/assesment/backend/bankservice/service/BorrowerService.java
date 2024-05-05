package com.assesment.backend.bankservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assesment.backend.bankservice.model.JointBorrower;
import com.assesment.backend.bankservice.model.MainBorrower;
import com.assesment.backend.bankservice.repository.JointBorrowerRepository;
import com.assesment.backend.bankservice.repository.MainBorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class BorrowerService {

    @Autowired
    private MainBorrowerRepository mainBorrowerRepository;

    @Autowired
    private JointBorrowerRepository jointBorrowerRepository;

    public MainBorrower saveMainBorrower(MainBorrower mainBorrower) {
        return mainBorrowerRepository.save(mainBorrower);
    }

    public void deleteMainBorrower(Long mainBorrowerId) {
        mainBorrowerRepository.deleteById(mainBorrowerId);
    }

    public JointBorrower saveJointBorrower(JointBorrower jointBorrower) {
        return jointBorrowerRepository.save(jointBorrower);
    }

    public void deleteJointBorrower(Long jointBorrowerId) {
        jointBorrowerRepository.deleteById(jointBorrowerId);
    }

    public Optional<MainBorrower> findMainBorrowerById(Long mainBorrowerId) {
        return mainBorrowerRepository.findById(mainBorrowerId);
    }

    public Optional<JointBorrower> findJointBorrowerById(Long jointBorrowerId) {
        return jointBorrowerRepository.findById(jointBorrowerId);
    }

    public List<MainBorrower> findAllMainBorrowers() {
        return mainBorrowerRepository.findAll();
    }

    public List<JointBorrower> findAllJointBorrowers() {
        return jointBorrowerRepository.findAll();
    }
}