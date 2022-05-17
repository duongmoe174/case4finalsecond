package com.duong.mycase41.controller;

import com.duong.mycase41.model.AppSubject;
import com.duong.mycase41.model.DTO.IRoleMinistry;
import com.duong.mycase41.model.DTO.SearchTranscript;
import com.duong.mycase41.model.Student;
import com.duong.mycase41.model.Transcript;
import com.duong.mycase41.repository.ITranscriptRepository;
import com.duong.mycase41.service.ministry.IMinistryService;
import com.duong.mycase41.service.student.IStudentService;
import com.duong.mycase41.service.subject.ISubjectService;
import com.duong.mycase41.service.transcript.ITranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transcripts")
@CrossOrigin("*")
public class TranscriptController {
    @Autowired
    IMinistryService ministryService;

    @Autowired
    ISubjectService subjectService;

    @Autowired
    ITranscriptService transcriptService;

    @Autowired
    IStudentService studentService;

    @ModelAttribute("student")
    public Iterable<Student> listAllStudent() {
        return studentService.findAll();
    }

    @ModelAttribute("subject")
    public Iterable<AppSubject> listAllAppSubject() {
        return subjectService.findAll();
    }

//    @GetMapping
//    public ResponseEntity<Iterable<Transcript>> listTranscript() {
////        List<Transcript> bookList = (List<Transcript>) transcriptService.findAll();
//        return new ResponseEntity<>(transcriptService.findAll(), HttpStatus.OK);
//    }
@GetMapping
public ResponseEntity<Page<Transcript>> showAllTranscript(@RequestParam(name = "q")Optional<String> q, @PageableDefault(value = 3) Pageable pageable){
    Page<Transcript> transcripts;
    if (q.isEmpty()){
        transcripts = transcriptService.findAll(pageable);
    } else {
        transcripts = transcriptService.findAllByFullNameContaining(q.get(), pageable);
    }
    return new ResponseEntity<>(transcripts, HttpStatus.OK);
}





//    @GetMapping("")
//    public ResponseEntity<Iterable<Transcript>> findAllBlog(){
//        List<Transcript> transcripts = (List<Transcript>) transcriptService.findAll();
//        if (transcripts.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(transcripts,HttpStatus.OK);
//    }

    @GetMapping("/subjects")
    public ResponseEntity<Iterable<AppSubject>> showSubject() {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<Iterable<Student>> showStudent() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Transcript> findTranscriptById(@PathVariable Long id){
//        Optional<Transcript> transcriptOptional = transcriptService.findById(id);
//        if (!transcriptOptional.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(transcriptOptional.get(),HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Transcript> saveTranscript(@RequestBody Transcript transcript){

        transcriptService.save(transcript);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Transcript> updateTranscript(@PathVariable Long id, @RequestBody Transcript transcript) {
        Optional<Transcript> transcriptOptional = transcriptService.findById(id);
        if (!transcriptOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        transcript.setId(transcriptOptional.get().getId());
        transcriptService.save(transcript);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Transcript> deleteTranscript(@PathVariable Long id) {
        Optional<Transcript> transcriptOptional = transcriptService.findById(id);
        if (!transcriptOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        transcriptService.remove(id);
        return new ResponseEntity<>(transcriptOptional.get(), HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Transcript> findOne(@PathVariable Long id) {
        Transcript transcript = transcriptService.findById(id).get();
        return new ResponseEntity<>(transcript, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<Iterable<SearchTranscript>> showTranscript(){
//        Iterable<SearchTranscript> searchTranscripts = transcriptService.getNameStudentAllBy();
//        return new ResponseEntity<>(searchTranscripts,HttpStatus.OK);
//    }

    @GetMapping("/ministry/{id}")
    private ResponseEntity<IRoleMinistry> getroleMinistry(@PathVariable Long id){
        IRoleMinistry iRoleMinistry = transcriptService.getRoleMinistry(id);
        return new ResponseEntity<>(iRoleMinistry,HttpStatus.OK);
    }

}