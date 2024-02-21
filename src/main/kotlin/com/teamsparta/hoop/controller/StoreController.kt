package com.teamsparta.hoop.controller

import com.teamsparta.hoop.dto.StoreResponse
import com.teamsparta.hoop.service.StoreService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class StoreController(
     private val storeService: StoreService
) {
    @GetMapping(
        "/stores", produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getStores(): ResponseEntity<List<StoreResponse>> {
        return ResponseEntity.ok(storeService.getStores())
    }

    @GetMapping(
        "/stores2", produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getStores2(): ResponseEntity<List<StoreResponse>> {
        return ResponseEntity.ok(storeService.getStores2())
    }

}