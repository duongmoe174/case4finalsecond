package com.duong.mycase41.service.subject;

import com.duong.mycase41.model.AppSubject;
import com.duong.mycase41.repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private ISubjectRepository subjectRepository;
    @Override
    public Iterable<AppSubject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<AppSubject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public AppSubject save(AppSubject appSubject) {
        return subjectRepository.save(appSubject);
    }

    @Override
    public void remove(Long id) {
        subjectRepository.deleteById(id);
    }
}
