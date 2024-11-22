package com.productservice.productservice.inheritencerelations.joindedclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_mentorrepository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Override
    <S extends Mentor> S save(S entity);
}
