package com.teamsparta.hoop.model

import jakarta.persistence.*

@Entity
@Table(name = "store")
data class Store(

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,


    @Column(name = "shop_name")
    val shopName: String? = null,

    @Column(name = "mall_name")
    val mallName: String? = null,

    @Column(name = "domain")
    val domain: String? = null,

    @Column(name = "email")
    val email: String? = null,

    @Column(name = "phone_number")
    val phoneNumber: String? = null,

    @Column(name = "business_type")
    val businessType: String? = null,

    @Column(name = "address")
    val address: String? = null,

    @Column(name = "sale_number")
    val saleNumber: String? = null,

    @Column(name = "first_report_date")
    val firstReportDate: String? = null,

    @Column(name = "situation")
    val situation: String? = null,

    @Column(name = "total_evaluation")
    val totalEvaluation: Int? = null,

    @Column(name = "withdrawal_evaluation")
    val withdrawalEvaluation: Int? = null,

    @Column(name = "business_information_evaluation")
    val businessInformationEvaluation: Int? = null,

    @Column(name = "approval_evaluation")
    val approvalEvaluation: Int? = null,

    @Column(name = "terms_evaluation")
    val termsEvaluation: Int? = null,

    @Column(name = "privacy_evaluation")
    val privacyEvaluation: Int? = null,

    @Column(name = "main_item")
    val mainItem: String? = null,

    @Column(name = "withdraw_possible")
    val withdrawPossible: String? = null,

    @Column(name = "initial_screen")
    val initialScreen: String? = null,

    @Column(name = "payment")
    val payment: String? = null,

    @Column(name = "term_compliance")
    val termCompliance: String? = null,

    @Column(name = "privacy_statement")
    val privacyStatement: String? = null,

    @Column(name = "request_term_over")
    val requestTermOver: String? = null,

    @Column(name = "safety_service")
    val safetyService: String? = null,

    @Column(name = "security_server")
    val securityServer: String? = null,

    @Column(name = "certification_mark")
    val certificationMark: String? = null,

    @Column(name = "delivery_date")
    val deliveryDate: String? = null,

    @Column(name = "refund_delivery_fee")
    val refundDeliveryFee: String? = null,

    @Column(name = "customer_complaint_board")
    val customerComplaintBoard: String? = null,

    @Column(name = "cancel_membership")
    val cancelMembership: String? = null,

    @Column(name = "site_opening")
    val siteOpening: String? = null,

    @Column(name = "monitoring_date")
    val monitoringDate: String? = null,
)

