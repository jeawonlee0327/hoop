package com.example.newteampj.domain.service

import com.example.newteampj.domain.dto.StoreResponse
import com.example.newteampj.domain.repository.storeRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
interface StoreService {

    //fun getStoreList(): List<StoreResponse> {}
    fun save(file: MultipartFile)


    }
