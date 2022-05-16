package com.duong.mycase41.service.classes;

import com.duong.mycase41.model.Classes;
import com.duong.mycase41.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClassesService extends IGeneralService<Classes> {
    Page<Classes> findAll(Pageable pageable);
    Page<Classes> findAllByNameContaining(String fullName, Pageable pageable);
}
