package com.teamsparta.hoop.repository

import com.teamsparta.hoop.model.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository:JpaRepository<Store, Long> {
    Page<Store> (Pageable pageable)
}