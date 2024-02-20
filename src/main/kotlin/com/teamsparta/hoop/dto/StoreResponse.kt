package com.teamsparta.hoop.dto

data class StoreResponse(
    val id: String,
    val createdAt: String,
    val shopName: String,
    val mallName: String,
    val domain: String,
    val businessType: String,
    val address: String,
    val saleNumber: String,
    val firstReportDate: String,
    val situation: String,
    val totalEvaluation: Int,
    val withdrawalEvaluation: Int,
    val businessInformationEvaluation: Int,
    val approvalEvaluation: Int,
    val termsEvaluation: Int,
    val privacyEvaluation: Int,
    val mainItem: String
)
