package com.example.newteampj.domain.repository

import org.apache.catalina.Store

interface storeRepository : JpaRepository<Store, Long> {

    fun findAllByDeletedDateTimeIsNull(): List<Store>

    fun findByIdAndDeletedDateTimeIsNull(id: Long): Store
}
}