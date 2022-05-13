package com.duong.mycase41.service.statusstudent;

import com.duong.mycase41.model.StatusStudent;
import com.duong.mycase41.repository.IStatusStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusService implements IStatusService {
    @Autowired
    IStatusStudentRepository statusStudentRepository;
    @Override
    public Iterable<StatusStudent> findAll() {
        return statusStudentRepository.findAll();
    }

    @Override
    public Optional<StatusStudent> findById(Long id) {
        return statusStudentRepository.findById(id);
    }

    @Override
    public StatusStudent save(StatusStudent statusStudent) {
        return statusStudentRepository.save(statusStudent);
    }

    @Override
    public void remove(Long id) {
        statusStudentRepository.deleteById(id);
    }
}
