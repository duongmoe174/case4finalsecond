package com.duong.mycase41.repository;

import com.duong.mycase41.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaryRepository extends JpaRepository<Diary, Long> {
}
