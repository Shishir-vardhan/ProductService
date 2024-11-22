package com.productservice.productservice.inheritencerelations.mappedsuperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ms_mentorrepository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Override
    Mentor save(Mentor mentor);

    /*
    Difference b/w (Mentor mentor) object we are passing and Mentor(ie.Mentor save()) object we are getting?
    mentor we are passing have all attribute except id to db.
    Mentor we are getting have all attributes along with id from db.
     */
}
