package com.teamsparta.hoop.service

import com.teamsparta.hoop.repository.StoreRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class StoreService(
    storeRepository: StoreRepository
) {
@Transactional(readOnly = true)
public ResponseDto<List<StoreResponseDto>> getStores(int rating, String criteria)

    Pageable pageable = PageRequest.of()

    }

}




