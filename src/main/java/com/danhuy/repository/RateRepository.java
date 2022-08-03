package com.danhuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danhuy.entity.RateEntity;

public interface RateRepository extends JpaRepository<RateEntity, Long> {

	RateEntity findByStarNum(String starNum);
}
