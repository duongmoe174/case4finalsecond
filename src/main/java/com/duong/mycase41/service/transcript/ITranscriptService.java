package com.duong.mycase41.service.transcript;

import com.duong.mycase41.model.DTO.IRoleMinistry;
import com.duong.mycase41.model.DTO.SearchTranscript;
import com.duong.mycase41.model.Transcript;
import com.duong.mycase41.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITranscriptService extends IGeneralService<Transcript> {
    Page<Transcript> findAll(Pageable pageable);
    Page<Transcript> findAllByFullNameContaining(String fullName, Pageable pageable);

    IRoleMinistry getRoleMinistry(Long id);
}
