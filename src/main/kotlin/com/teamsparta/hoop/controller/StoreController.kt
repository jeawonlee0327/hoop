package com.teamsparta.hoop.controller

import com.teamsparta.hoop.dto.StoreDto
import com.teamsparta.hoop.service.StoreService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedReader
import java.io.InputStreamReader


@RestController
@RequestMapping("/api/stores")
class StoreController(
    private val storeService: StoreService,
) {
    @GetMapping("/rating")
    @Operation(summary = "전체 점수 조회", description = "0~3 까지의 숫자를 입력하세요.")
    fun getStoresByTotalEvaluation(
        @RequestParam rating: Int //이게 있어야 스웨거에서 숫자입력
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.getStoresByTotalEvaluation(rating)
        return ResponseEntity.ok(stores)
    }

    @GetMapping("/status")
    @Operation(summary = "가게 상태 조회", description = "사이트운영중단, 휴업중, 광고용(홍보용), 등록정보불일치, 사이트폐쇄, 영업중, 확인안됨 상태 중 1개를 선택하세요.")
    fun getStoresBySituation(
        @RequestParam status: String
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.getStoresBySituation(status)//"storeService"의 "getStoresBySituation" 메서드를 호출하여 결과를 "stores" 변수에 저장하는 부분
        return ResponseEntity.ok(stores)
    }

    @GetMapping("/rating-status")
    @Operation(summary = "전체평가, 가게 상태 조회", description = "0~3 까지의 숫자와 사이트운영중단, 휴업중, 광고용(홍보용), 등록정보불일치, 사이트폐쇄, 영업중, 확인안됨 상태 중 1개를 선택하세요.")
    fun getStoresByTotalEvaluationAndSituation(
        @RequestParam rating: Int,
        @RequestParam status: String
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.getStoresByTotalEvaluationAndSituation(rating, status)
        return ResponseEntity.ok(stores)
    }

    @GetMapping("/search")
    @Operation(summary = "가게 이름 검색", description = "이름, 사이트 주소, 이메일 중 하나만 입력해도 됩니다.")
    fun searchStores(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) domain: String?,
        @RequestParam(required = false) email: String?
    ): ResponseEntity<List<StoreDto>> {
        val stores = storeService.searchStores(name, domain, email)
        return ResponseEntity.ok(stores)
    }

    @DeleteMapping("/delete")
    @Operation(summary = "가게 삭제", description = "입력한 이름과 같은 가게를 삭제합니다.")
    fun deleteStore(
        @RequestParam shopName: String
    ): ResponseEntity<Unit> {
        storeService.deleteStore(shopName)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/upload", consumes = ["multipart/form-data"])
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






//    @PostMapping("/upload", consumes = ["multipart/form-data"])
//    fun uploadFile(@RequestParam("file") file: MultipartFile) {
//        if (file.isEmpty) {
//            // 파일이 비어있는지 확인
//            println("File is empty")
//            return
//        }
//
//        // MultipartFile을 BufferedReader로 변환
//        val reader = BufferedReader(InputStreamReader(file.inputStream))
//
//
//        // CSV 파일의 각 라인을 읽어 처리
//        var line: String? = reader.readLine()
//        while (line != null && reader.readLine().also { line = it } != null) {
//            val data = line!!.split(",")
//            println("Data[8]: ${data[8]}")
//            println("Data[31]: ${data[31]}")
//            println(line)
//
//            val store = Store(
//                shopName = data[0],
//                mallName = data[1],
//                domain = data[2],
//                phoneNumber = data[3],
//                email = data[4],
//                businessType = data[5],
//                address = data[6],
//                saleNumber = data[7],
//                firstReportDate = LocalDate.parse(data[8], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
//                totalEvaluation = data[10].toIntOrNull() ?: 0,
//                businessInformationEvaluation = data[11].toIntOrNull() ?: 0,
//                withdrawalEvaluation = data[12].toIntOrNull() ?: 0,
//                approvalEvaluation = data[13].toIntOrNull() ?: 0,
//                termsEvaluation = data[14].toIntOrNull() ?: 0,
//                privacyEvaluation = data[15].toIntOrNull() ?: 0,
//                mainItem = data[16],
//                withdrawPossible = data[17],
//                initialScreen = data[18],
//                payment = data[19],
//                termCompliance = data[20],
//                privacyStatement = data[21],
//                requestTermOver = data[22],
//                safetyService = data[23],
//                securityServer = data[24],
//                certificationMark = data[25],
//                deliveryDate = data[26],
//                refundDeliveryFee = data[27],
//                customerComplaintBoard = data[28],
//                cancelMembership = data[29],
//                siteOpening = data[30],
//                monitoringDate = LocalDate.parse(data[31], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
//            )
//            storeRepository.save(store)
//        }
//        reader.close()
//
//    }

}





