package com.productservice.productservice.inheritencerelations.joindedclass;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_userrepository")
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    User save(User user);
}
