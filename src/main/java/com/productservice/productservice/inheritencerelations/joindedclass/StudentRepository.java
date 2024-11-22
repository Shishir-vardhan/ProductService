package com.productservice.productservice.inheritencerelations.joindedclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_studentrepository")
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    Student save(Student student);
}
