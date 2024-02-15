package com.teamsparta.hoop.controller

import com.teamsparta.hoop.dto.StoreDto
import com.teamsparta.hoop.service.StoreService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PutMapping("/rating-status")
    fun createStore(
        @RequestParam shopName: String,
        @RequestParam mallName: String,
        @RequestParam domain: String,
        @RequestParam email: String,
        @RequestParam phoneNumber: String,
        @RequestParam businessType: String,
        @RequestParam address: String,
        @RequestParam totalEvaluation: Int,
        @RequestParam situation: String,
        @RequestParam monitoringDate: String
    ): ResponseEntity<StoreDto> {
        val store = storeService.createStore(
            shopName,
            mallName,
            domain,
            email,
            phoneNumber,
            businessType,
            address,
            totalEvaluation,
            situation,
            monitoringDate
        )
        return ResponseEntity.ok(store)
    }

    @PostMapping("/rating-status")
    fun updateStore(
        @RequestParam id: Int,
        @RequestParam shopName: String,
        @RequestParam mallName: String,
        @RequestParam domain: String,
        @RequestParam email: String,
        @RequestParam phoneNumber: String,
        @RequestParam businessType: String,
        @RequestParam address: String,
        @RequestParam totalEvaluation: Int,
        @RequestParam situation: String,
        @RequestParam monitoringDate: String
    ): ResponseEntity<StoreDto> {
        val store = storeService.updateStore(
            id,
            shopName,
            mallName,
            domain,
            email,
            phoneNumber,
            businessType,
            address,
            totalEvaluation,
            situation,
            monitoringDate
        )
        return ResponseEntity.ok(store)
    }
}