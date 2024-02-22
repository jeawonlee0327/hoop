package com.example.newteampj.domain.controller

import com.example.newteampj.domain.dto.StoreResponse
import com.example.newteampj.domain.service.StoreService
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

class controller {

    @GetMapping
    fun getStoresByPageable(pageable: Pageable): ResponseEntity<List<StoreResponse>> {

        return StoreService.getStoreList()
            .let {
                ResponseEntity
                    .status(HttpStatus.OK)
                    //이 코드를 작동시켜보고 싶어서 다른 파일들을 중구난방으로 만들어버렸습니다 ㅠㅠ
            }
    }







}