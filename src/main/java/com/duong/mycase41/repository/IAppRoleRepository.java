package com.duong.mycase41.repository;


import com.duong.mycase41.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByName (String name);
}
