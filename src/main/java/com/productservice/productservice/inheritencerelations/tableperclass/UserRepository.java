package com.productservice.productservice.inheritencerelations.tableperclass;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_userrepository")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    User save(User user);
}
