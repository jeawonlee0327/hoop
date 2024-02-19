package com.teamsparta.hoop.controller

import com.teamsparta.hoop.dto.StoreDto
import com.teamsparta.hoop.service.StoreService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/stores")
class StoreController(
    private val storeService: StoreService
) {
    @GetMapping("/rating")
    fun getStoresByTotalEvaluation(
        @RequestParam rating: Int
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.getStoresByTotalEvaluation(rating)
        return ResponseEntity.ok(stores)
    }

    @GetMapping("/status")
    fun getStoresBySituation(
        @RequestParam status: String
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.getStoresBySituation(status)
        return ResponseEntity.ok(stores)
    }

    @GetMapping("/rating-status")
    fun getStoresByTotalEvaluationAndSituation(
        @RequestParam rating: Int,
        @RequestParam status: String
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.getStoresByTotalEvaluationAndSituation(rating, status)
        return ResponseEntity.ok(stores)
    }
<<<<<<<<< Temporary merge branch 1
=========

    @GetMapping("/search")
    fun searchStores(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) domain: String?,
        @RequestParam(required = false) email: String?
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.searchStores(name, domain, email)
        return ResponseEntity.ok(stores)
    }

    @DeleteMapping("/delete")
    fun deleteStore(
        @RequestParam shopName: String
    ): ResponseEntity<Unit> {
        storeService.deleteStore(shopName)
        return ResponseEntity.noContent().build()
    }

}