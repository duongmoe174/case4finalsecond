package com.duong.mycase41.service.classes;

import com.duong.mycase41.model.Classes;
import com.duong.mycase41.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassesService implements IClassesService{
    @Autowired
    private IClassesRepository classesRepository;
    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classesRepository.findById(id);
    }

    @Override
    public Classes save(Classes classes) {
        return classesRepository.save(classes);
    }

    @Override
    public void remove(Long id) {
        classesRepository.deleteById(id);
    }
    @Override
    public Page<Classes> findAll(Pageable pageable) {
        return classesRepository.findAll(pageable);
    }

    @Override
    public Page<Classes> findAllByNameContaining(String fullName, Pageable pageable) {
        return classesRepository.findAllByNameContaining(fullName, pageable);
    }
}
