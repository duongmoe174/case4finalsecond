package com.duong.mycase41.service.ministry;

import com.duong.mycase41.model.Ministry;
import com.duong.mycase41.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMinistryService extends IGeneralService<Ministry> {
    Page<Ministry> findAll (Pageable pageable);
    Page<Ministry> findAllByFullNameContaining(String fullName, Pageable pageable);
}
