package com.example.oopDepositTask.repo;

import com.example.oopDepositTask.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepo extends JpaRepository<Img, Long> {
}
