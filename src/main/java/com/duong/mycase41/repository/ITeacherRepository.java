package com.duong.mycase41.repository;

import com.duong.mycase41.model.DTO.formTeacher.IClassOfTeacher;
import com.duong.mycase41.model.DTO.formTeacher.IStudentOfTeacher;
import com.duong.mycase41.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends PagingAndSortingRepository<Teacher, Long> {
    String GETLISTSTUDENTBYTEACHERID = "select s.id, s.full_name as name, g.name as gender, s.email, s.date_of_birth as date, s.phone_number as phone, s.avatar, ss.name as status\n" +
            "from student s\n" +
            "join teachers_classes tc on s.classes_id = tc.classes_id\n" +
            "join gender g on s.gender_id = g.id\n" +
            "join status_student ss on ss.id = s.status_student_id\n" +
            "where teacher_id = ?1\n" +
            "order by s.id ASC";
    String GETLISTSTUDENT = "select s.id, s.full_name as name, g.name as gender, s.email, s.date_of_birth as date, s.phone_number as phone, s.avatar, ss.name as status\n" +
            "from student s\n" +
            "join teachers_classes tc on s.classes_id = tc.classes_id\n" +
            "join gender g on s.gender_id = g.id\n" +
            "join status_student ss on ss.id = s.status_student_id";
    String GETLISTCLASSBYTEACHERID = "select c.id , t.full_name as nameTeacher, c.name as nameClass\n" +
            "from classes c\n" +
            "join teachers_classes tc on c.id = tc.classes_id\n" +
            "join teacher t on t.id = tc.teacher_id\n" +
            "where teacher_id = ?1";
    String GETLISTCLASS = "select c.id , t.full_name as nameTeacher, c.name as nameClass\n" +
            "from classes c\n" +
            "join teachers_classes tc on c.id = tc.classes_id\n" +
            "join teacher t on t.id = tc.teacher_id";

    Page<Teacher> findAll(Pageable pageable);

    Page<Teacher> findAllByFullNameContaining (String fullName, Pageable pageable);

    @Query(nativeQuery = true, value = GETLISTSTUDENTBYTEACHERID)
    Iterable<IStudentOfTeacher> getListStudentByTeacherId(Long id);

    @Query(nativeQuery = true, value = GETLISTSTUDENT)
    Iterable<IStudentOfTeacher> showAllStudent();

    @Query(nativeQuery = true, value = GETLISTCLASSBYTEACHERID)
    Iterable<IClassOfTeacher> getListClassByTeacherId(Long id);

    @Query(nativeQuery = true, value = GETLISTCLASS)
    Iterable<IClassOfTeacher> showAllClass();

}
