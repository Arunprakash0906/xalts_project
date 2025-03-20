package com.example.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Approval;

public interface ApprovalRepository extends JpaRepository<Approval, Long>  {

}
