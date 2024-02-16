package com.teamsparta.hoop.controller

import com.teamsparta.hoop.dto.StoreDto
import com.teamsparta.hoop.service.StoreService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
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
    @Operation(summary = "전체 점수 조회", description = "0~3 까지의 숫자를 입력하세요.")
    fun getStoresByTotalEvaluation(
        @RequestParam rating: Int
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.getStoresByTotalEvaluation(rating)
        return ResponseEntity.ok(stores)
    }

    @GetMapping("/status")
    @Operation(summary = "점포 상태 조회", description = "사이트운영중단, 휴업중, 광고용(홍보용), 등록정보불일치, 사이트폐쇄, 영업중, 확인안됨 상태 중 1개를 선택하세요.")
    fun getStoresBySituation(
        @RequestParam status: String
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.getStoresBySituation(status)
        return ResponseEntity.ok(stores)
    }

    @GetMapping("/rating-status")
    @Operation(summary = "전체평가, 점포 상태 조회", description = "0~3 까지의 숫자와 사이트운영중단, 휴업중, 광고용(홍보용), 등록정보불일치, 사이트폐쇄, 영업중, 확인안됨 상태 중 1개를 선택하세요.")
    fun getStoresByTotalEvaluationAndSituation(
        @RequestParam rating: Int,
        @RequestParam status: String
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.getStoresByTotalEvaluationAndSituation(rating, status)
        return ResponseEntity.ok(stores)
    }
}