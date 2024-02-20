package com.teamsparta.hoop.controller

import com.teamsparta.hoop.dto.StoreResponse
import com.teamsparta.hoop.service.StoreService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

class StoreController
{
    @GetMapping(
        "/stores",
        produces =[MediaType.APPLICATION_JSON_VALUE]

    fun getStores(): ResponseEntity<List<StoreResponse>> (
        @RequestParam rating: Int
     {
        var stores: List<StoreResponse> = mutableListOf()

        return ResponseEntity().ok()
    }
    )
}


    @GetMapping
    fun getStoresByPageable(pageable: Pageable): ResponseEntity<List<StoreResponse>> {}