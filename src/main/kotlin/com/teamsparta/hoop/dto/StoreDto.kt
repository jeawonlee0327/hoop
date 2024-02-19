package com.teamsparta.hoop.dto

import com.teamsparta.hoop.model.Store

data class StoreDto(
    val id: Int,
    val shopName: String,
    val mallName: String,
    val domain: String,
    val email: String,
    val phoneNumber: String,
    val businessType: String?,
    val address: String,
    val totalEvaluation: Int?, // 타입을 Int?로 변경
    val situation: String,
    val monitoringDate: String
) {
    constructor(store: Store) : this(
        id = store.id,
        shopName = store.shopName,
        mallName = store.mallName,
        domain = store.domain,
        email = store.email,
        phoneNumber = store.phoneNumber,
        businessType = store.businessType,
        address = store.address,
        totalEvaluation = store.totalEvaluation,
        situation = store.situation,
        monitoringDate = store.monitoringDate
    )
}// constructor를 넣은 이유는 안그러면 controller에서 설명이 길어짐