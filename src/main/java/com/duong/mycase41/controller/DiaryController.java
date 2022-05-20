package com.duong.mycase41.controller;

import com.duong.mycase41.model.Diary;
import com.duong.mycase41.service.diary.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary")
@CrossOrigin("*")
public class DiaryController {
    @Autowired
    private IDiaryService diaryService;

    @GetMapping("/{id}")
    public ResponseEntity<Diary> findById(@PathVariable Long id){
        Diary diary = diaryService.findById(id).get();
        return new ResponseEntity<>(diary, HttpStatus.OK);
    }
}
