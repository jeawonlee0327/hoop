package com.teamsparta.hoop.dto

data class StoreResponse(
    val id: Int,
    val shopName: String?,
    val mallName: String?,
    val domain: String?,
    val email: String?,
    val phoneNumber : String?,
    val businessType: String?,
    val address: String?,
    val firstReportDate: String?
)