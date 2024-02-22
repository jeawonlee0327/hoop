package com.example.newteampj.domain.service

import org.springframework.web.multipart.MultipartFile
import java.nio.file.Paths

class StoreServiceImpl {
    override fun save(file: MultipartFile) {
        val path = Paths.get("/path/to/save/" + file.originalFilename)
        file.transferTo(path)
    }
}