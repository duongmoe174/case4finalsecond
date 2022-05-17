package com.duong.mycase41.service.transcript;

import com.duong.mycase41.model.DTO.IRoleMinistry;
import com.duong.mycase41.model.DTO.SearchTranscript;
import com.duong.mycase41.model.Transcript;
import com.duong.mycase41.repository.ITranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TranscriptService implements ITranscriptService {
    @Autowired
    private ITranscriptRepository transcriptRepository;

    @Override
    public Iterable<Transcript> findAll() {
        return transcriptRepository.findAll();
    }

    @Override
    public Optional<Transcript> findById(Long id) {
        return transcriptRepository.findById(id);
    }

    @Override
    public Transcript save(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }

    @Override
    public void remove(Long id) {
        transcriptRepository.deleteById(id);
    }

    @Override
    public Page<Transcript> findAll(Pageable pageable) {
        return transcriptRepository.findAll(pageable);
    }

    @Override
    public Page<Transcript> findAllByFullNameContaining(String fullName, Pageable pageable) {
        return transcriptRepository.findAllByStudentFullName(fullName,pageable);
    }

    @Override
    public IRoleMinistry getRoleMinistry(Long id) {
        return transcriptRepository.getRoleMinistry(id);
    }

//    @Override
//    public Iterable<SearchTranscript> getNameStudentAllBy() {
//        return transcriptRepository.getNameStudentAllBy();
//    }
}
