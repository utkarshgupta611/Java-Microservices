package com.prvt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prvt.model.MobileEntity;

public interface MobileRepo extends JpaRepository<MobileEntity, Integer> {

	Optional<MobileEntity> findByModelNumber(long modelnumber);

}
