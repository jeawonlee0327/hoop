package com.teamsparta.hoop.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional(readOnly = true)
@Service
class StoreService {
    private StoreReository StoreRepository;

    public void findAll(Pageable pageable)
    {
        postRepository.findByUserOrderByIdDesc(createUser(), pageable)
            .map(StoreResponseDTO::from);
    }

}




