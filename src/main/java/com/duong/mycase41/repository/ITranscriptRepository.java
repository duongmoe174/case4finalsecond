package com.duong.mycase41.repository;

import com.duong.mycase41.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITranscriptRepository extends JpaRepository<Transcript, Long> {
}
