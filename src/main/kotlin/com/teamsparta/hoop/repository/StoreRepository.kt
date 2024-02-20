package com.teamsparta.hoop.repository

import com.teamsparta.hoop.model.Store
import org.springframework.data.jpa.repository.JpaRepository

public interface StoreRepository:JpaRepository<Store, Long> {
    Page<Stores> findAll(Pageable pageable);
}