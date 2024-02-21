package com.teamsparta.hoop.model

import jakarta.persistence.*

@Entity
@Table(name = "store")
data class Store(

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
val id: Int,

//@Column(name = "created_at")
//val createdAt: String,

@Column(name = "shop_name")
val shopName: String,

@Column(name = "mall_name")
val mallName: String,

@Column(name = "domain")
val domain: String,

@Column(name = "email")
val email: String,

@Column(name = "phone_number")
val phoneNumber: String,

@Column(name = "business_type")
val businessType: String,

@Column(name = "address")
val address: String,

//@Column(name = "sale_number")
//val saleNumber: String,

@Column(name = "first_report_date")
val firstReportDate: String,

//@Column(name = "situation")
//val situation: String,
//
//@Column(name = "total_evaluation")
//val totalEvaluation: Int,

//@Column(name = "withdrawal_evaluation")
//val withdrawalEvaluation: Int,

//@Column(name = "business_information_evaluation")
//val businessInformationEvaluation: Int,

//@Column(name = "approval_evaluation")
//val approvalEvaluation: Int,

//@Column(name = "terms_evaluation")
//val termsEvaluation: Int,
//
//@Column(name = "privacy_evaluation")
//val privacyEvaluation: Int,
//
//@Column(name = "main_item")
//val mainItem: String,
//
//@Column(name = "withdraw_possible")
//val withdrawPossible: String,
//
//@Column(name = "initial_screen")
//val initialScreen: String,
//
//@Column(name = "payment")
//val payment: String,
//
//@Column(name = "term_compliance")
//val termCompliance: String,
//
//@Column(name = "privacy_statement")
//val privacyStatement: String,
//
//@Column(name = "request_term_over")
//val requestTermOver: String,
//
//@Column(name = "safety_service")
//val safetyService: String,
//
//@Column(name = "security_server")
//val securityServer: String,
//
//@Column(name = "certification_mark")
//val certificationMark: String,
//
//@Column(name = "delivery_date")
//val deliveryDate: String,
//
//@Column(name = "refund_delivery_fee")
//val refundDeliveryFee: String,
//
//@Column(name = "customer_complaint_board")
//val customerComplaintBoard: String,
//
//@Column(name = "cancel_membership")
//val cancelMembership: String,
//
//@Column(name = "site_opening")
//val siteOpening: String,
//
//@Column(name = "monitoring_date")
//val monitoringDate: String
)