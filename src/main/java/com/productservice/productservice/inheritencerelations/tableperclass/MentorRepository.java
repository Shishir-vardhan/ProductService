package com.productservice.productservice.inheritencerelations.tableperclass;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_mentorrepository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Override
    Mentor save(Mentor mentor);


    /*
    Difference b/w (Mentor mentor) object we are passing and Mentor(ie.Mentor save()) object we are getting?
    mentor we are passing have all attribute except id to db.
    Mentor we are getting have all attributes along with id from db.
     */
}
