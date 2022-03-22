package com.tutorial.sandbox.Repository.Rats;

import com.tutorial.sandbox.Entity.Rats.Trap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrapRepository extends JpaRepository<Trap,Long> {
    Trap getById(Long id);

    List<Trap> findAll();

    Optional<Trap> findById(Long id);
}
