package com.danhuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danhuy.entity.AdvertiseEntity;

public interface AdvertiseRepository extends JpaRepository<AdvertiseEntity, Long> {

	List<AdvertiseEntity> findAllByOrderByIdAsc();
}
