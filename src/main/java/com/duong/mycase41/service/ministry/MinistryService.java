package com.duong.mycase41.service.ministry;

import com.duong.mycase41.model.Ministry;
import com.duong.mycase41.repository.IMinistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MinistryService implements IMinistryService{
    @Autowired
    private IMinistryRepository ministryRepository;

    @Override
    public Iterable<Ministry> findAll() {
        return ministryRepository.findAll();
    }

    @Override
    public Optional<Ministry> findById(Long id) {
        return ministryRepository.findById(id);
    }

    @Override
    public Ministry save(Ministry ministry) {
        return ministryRepository.save(ministry);
    }

    @Override
    public void remove(Long id) {
        ministryRepository.deleteById(id);
    }
}
