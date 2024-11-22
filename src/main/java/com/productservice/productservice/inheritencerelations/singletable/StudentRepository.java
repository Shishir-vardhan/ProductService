package com.productservice.productservice.inheritencerelations.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("s_studentrepository")
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    <S extends Student> S save(S entity);
}
