package com.duong.mycase41.repository;

import com.duong.mycase41.model.AppSubject;
import com.duong.mycase41.model.DTO.IRoleMinistry;
import com.duong.mycase41.model.DTO.SearchTranscript;
import com.duong.mycase41.model.Transcript;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITranscriptRepository extends PagingAndSortingRepository<Transcript, Long> {
     Page<Transcript> findAllByStudentFullName(String fullName, Pageable pageable);

     @Query(nativeQuery = true, value = "SELECT full_name as 'nameStudent',point1 as 'pointone',point2 as 'pointtwo',asbj.name as 'nameSubject' FROM transcript t join student s  on s.id = t.student_id join appsubject asbj on t.app_subject_id = asbj.id where t.id like ?1")
     Page<Transcript> findByFullname(String fullName, Pageable pageable);

     @Query(nativeQuery = true, value = "select point1 , point2, full_name as 'name', asbj.name as 'nameSub' from transcript t join student s on s.id = t.student_id join appsubject asbj on t.app_subject_id = asbj.id  where t.id like ?1")
     IRoleMinistry getRoleMinistry(Long id);
}
