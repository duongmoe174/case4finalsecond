package com.duong.mycase41.service.approle;

import com.duong.mycase41.model.AppRole;
import com.duong.mycase41.repository.IAppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AppRoleService implements IAppRoleService{
    @Autowired
    private IAppRoleRepository appRoleRepository;

    @Override
    public Iterable<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return appRoleRepository.findById(id);
    }

    @Override
    public AppRole save(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void remove(Long id) {
        appRoleRepository.deleteById(id);

    }

    @Override
    public AppRole findByName(String name) {
        return appRoleRepository.findByName(name);
    }
}
