package com.teamsparta.hoop.service

import com.teamsparta.hoop.exception.BusinessException
import com.teamsparta.hoop.dto.StoreDto
import com.teamsparta.hoop.repository.StoreRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StoreServiceImpl(
    private val storeRepository: StoreRepository
) : StoreService {

    override fun getStoresByTotalEvaluation(rating: Int): List<StoreDto> {
        if (rating < 0 || rating > 3) {
            throw BusinessException("잘못된 숫자입니다. 숫자는 0 이상 3 이하의 값이어야 합니다.")
        }
        return storeRepository.findAll()
            .filter { it.totalEvaluation == rating }//가져온 상점 정보 중에서 "totalEvaluation"이 입력받은 "rating"과 같은 상점만 필터링
            .sortedByDescending { it.monitoringDate }//필터링된 상점들을 "monitoringDate"를 기준으로 내림차순
            .map { StoreDto(it) }// 정렬된 상점 정보를 StoreDto 객체로 변환하여 리스트로
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
            throw BusinessException("잘못된 숫자입니다. 숫자는 0 이상 3 이하의 값이어야 합니다.")}
        return storeRepository.findAll()
            .filter { it.totalEvaluation == rating && it.situation == status }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }
    override fun searchStores(
        name: String?,
        domain: String?,
        email: String?
    ): List<StoreDto> {
        return storeRepository.findAll()
            .filter { store ->
                (name == null || store.shopName.contains(name))
                        &&(domain == null || store.domain.contains(domain))
                        &&(email == null || store.email.contains(email))
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

}