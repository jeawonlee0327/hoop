package com.teamsparta.hoop.repository

import com.teamsparta.hoop.model.Store
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : JpaRepository<Store, Long> {
    fun findBySituation(situation: String, pageable: Pageable): Page<Store>
    fun findByTotalEvaluation(totalEvaluation: String, pageable: Pageable): Page<Store>
}