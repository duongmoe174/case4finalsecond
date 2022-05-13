package com.duong.mycase41.repository;

import com.duong.mycase41.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByName(String name);
}
