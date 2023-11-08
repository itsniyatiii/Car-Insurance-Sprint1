package com.springboot.carinsurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.carinsurance.entity.Payment;

@Repository
//creating PaymentRepository interface which extends JpaRepository
public interface PaymentRepository extends JpaRepository<Payment, Integer>
{

	Payment findBypaymentId(int id);
}
