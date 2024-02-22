package com.example.newteampj.domain.controller

import com.example.newteampj.domain.dto.StoreResponse
import com.example.newteampj.domain.service.StoreService
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedReader
import java.io.InputStreamReader

class controller {

//    @GetMapping
//    fun getStoresByPageable(pageable: Pageable): ResponseEntity<List<StoreResponse>> {
//
//        return StoreService.getStoreList()
//            .let {
//                ResponseEntity
//                    .status(HttpStatus.OK)
//                    //이 코드를 작동시켜보고 싶어서 다른 파일들을 중구난방으로 만들어버렸습니다 ㅠㅠ
//            }
//    }

    @PostMapping("/upload")
    fun uploadFile(@RequestParam("file") file: MultipartFile) {
        if (file.isEmpty) {
            // 파일이 비어있는지 확인
            println("File is empty")
            return
        }

        // MultipartFile을 BufferedReader로 변환
        val reader = BufferedReader(InputStreamReader(file.inputStream))

        // CSV 파일의 각 라인을 읽어 처리
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            // 각 라인에 대한 처리 수행
            println(line)
        }

        // 작업이 끝나면 리더를 닫습니다.
        reader.close()
    }





}