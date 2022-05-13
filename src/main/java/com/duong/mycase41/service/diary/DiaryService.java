package com.duong.mycase41.service.diary;

import com.duong.mycase41.model.Diary;
import com.duong.mycase41.repository.IDiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiaryService implements IDiaryService{
    @Autowired
    private IDiaryRepository diaryRepository;

    @Override
    public Iterable<Diary> findAll() {
        return diaryRepository.findAll();
    }

    @Override
    public Optional<Diary> findById(Long id) {
        return diaryRepository.findById(id);
    }

    @Override
    public Diary save(Diary diary) {
        return diaryRepository.save(diary);
    }

    @Override
    public void remove(Long id) {
        diaryRepository.deleteById(id);
    }
}
