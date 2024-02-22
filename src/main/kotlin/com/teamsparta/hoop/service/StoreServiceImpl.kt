package com.teamsparta.hoop.service

import com.teamsparta.hoop.exception.BusinessException
import com.teamsparta.hoop.dto.StoreDto
import com.teamsparta.hoop.model.Store
import com.teamsparta.hoop.repository.StoreRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Paths

@Service
class StoreServiceImpl(
    private val storeRepository: StoreRepository
) : StoreService {

    override fun getStoresByTotalEvaluation(rating: Int): List<StoreDto> {
        if (rating < 0 || rating > 3) {
            throw BusinessException("잘못된 숫자입니다. 숫자는 0 이상 3 이하의 값이어야 합니다.")
        }
        return storeRepository.findAll()
            .filter { it.totalEvaluation == rating }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }

    override fun getStoresBySituation(status: String): List<StoreDto> {
        val allowedStatuses = listOf("사이트운영중단", "휴업중", "광고용(홍보용)", "등록정보불일치", "사이트폐쇄", "영업중", "확인안됨")
        if (status !in allowedStatuses) {
            throw BusinessException("잘못 입력하셨습니다.")
        }
        return storeRepository.findAll()
            .filter { it.situation == status }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }


    override fun getStoresByTotalEvaluationAndSituation(rating: Int, status: String): List<StoreDto> {
        if (rating < 0 || rating > 3) {
            throw BusinessException("잘못된 숫자입니다. 숫자는 0 이상 3 이하의 값이어야 합니다.")
        }
        val allowedStatuses = listOf("사이트운영중단", "휴업중", "광고용(홍보용)", "등록정보불일치", "사이트폐쇄", "영업중", "확인안됨")

        if (status !in allowedStatuses) {
            throw BusinessException("잘못 입력하셨습니다.")
        }
        return storeRepository.findAll()
            .filter { it.totalEvaluation == rating && it.situation == status }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }
    override fun searchStores(name: String?, domain: String?, email: String?): List<StoreDto> {
        return storeRepository.findAll()
            .filter { store ->
                (name == null || store.shopName?.contains(name) ?: false)
                        && (domain == null || store.domain?.contains(domain) ?: false)
                        && (email == null || store.email?.contains(email) ?: false)
            }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }

    @Transactional
    override fun deleteStore(shopName: String) {
        try {
            val store = storeRepository.findByShopName(shopName)
            if (store != null) {
                storeRepository.delete(store)
            }
        } catch (e: NoSuchElementException) {
            throw BusinessException("업체를 찾을 수 없습니다. shopName: $shopName")
        }
    }

    override fun save(file: MultipartFile) {
        val path = Paths.get("/path/to/save/" + file.originalFilename)
        file.transferTo(path)
    }





    override fun createStore(
        shopName: String,
        mallName: String,
        domain: String,
        email: String,
        phoneNumber: String,
        businessType: String,
        address: String,
        totalEvaluation: Int,
        situation: String,
        monitoringDate: String
    ): StoreDto {
        val store = storeRepository.save(
            Store(
                shopName = shopName,
                mallName = mallName,
                domain = domain,
                email = email,
                phoneNumber = phoneNumber,
                businessType = businessType,
                address = address,
                totalEvaluation = totalEvaluation,
                situation = situation,
                monitoringDate = monitoringDate
            )
        )
        return StoreDto(store)
    }

    override fun updateStore(
        id: Int,
        shopName: String,
        mallName: String,
        domain: String,
        email: String,
        phoneNumber: String,
        businessType: String,
        address: String,
        totalEvaluation: Int,
        situation: String,
        monitoringDate: String
    ): StoreDto {
        val store = storeRepository.save(
            Store(
                id = id,
                shopName = shopName,
                mallName = mallName,
                domain = domain,
                email = email,
                phoneNumber = phoneNumber,
                businessType = businessType,
                address = address,
                totalEvaluation = totalEvaluation,
                situation = situation,
                monitoringDate = monitoringDate
            )
        )
        return StoreDto(store)
    }
}