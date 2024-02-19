package com.teamsparta.hoop.dto

import com.fasterxml.jackson.annotation.JsonGetter

@JsonGetter
class StoreRequest(
    val id: Int,
    val createdAt: String,
    val shopName: String,
    val mallName: String,
    val domain: String,



)
