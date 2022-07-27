package com.danhuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danhuy.entity.EpisodeEntity;

public interface EpisodeRepository extends JpaRepository<EpisodeEntity, Long> {

}
