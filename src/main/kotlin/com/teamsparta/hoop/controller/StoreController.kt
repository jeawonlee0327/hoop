package com.teamsparta.hoop.controller

import com.teamsparta.hoop.dto.StoreResponse
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

class StoreController (
    private val
 {
    @GetMapping(
        "/stores",
        produces =[MediaType.APPLICATION_JSON_VALUE]
    )
    fun getStores(): ResponseEntity<List<StoreResponse>> {
        @RequestParam(required = false, defaultValue = "0", value = "list")
    }
}

    @GetMapping
    fun getStoresByPageable(pageable: Pageable): ResponseEntity<List<StoreResponse>> {}