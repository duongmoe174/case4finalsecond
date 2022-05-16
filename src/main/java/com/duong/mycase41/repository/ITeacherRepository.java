package com.duong.mycase41.repository;

import com.duong.mycase41.model.DTO.formTeacher.IStudentOfTeacher;
import com.duong.mycase41.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
    @Query(nativeQuery = true, value = "select s.id, s.full_name as name, g.name as gender, s.email, s.date_of_birth as date, s.phone_number as phone, s.avatar, ss.name as status\n" +
            "from student s\n" +
            "join teachers_classes tc on s.classes_id = tc.classes_id\n" +
            "join gender g on s.gender_id = g.id\n" +
            "join status_student ss on ss.id = s.status_student_id\n" +
            "where teacher_id = ?1\n" +
            "order by s.id ASC")
    Iterable<IStudentOfTeacher> getListStudentByTeacherId(Long id);

    @Query(nativeQuery = true, value = "select s.id, s.full_name as name, g.name as gender, s.email, s.date_of_birth as date, s.phone_number as phone, s.avatar, ss.name as status\n" +
            "from student s\n" +
            "join teachers_classes tc on s.classes_id = tc.classes_id\n" +
            "join gender g on s.gender_id = g.id\n" +
            "join status_student ss on ss.id = s.status_student_id")
    Iterable<IStudentOfTeacher> showAllStudent();


}