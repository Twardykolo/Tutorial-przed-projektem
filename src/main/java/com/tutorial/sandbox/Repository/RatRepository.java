package com.tutorial.sandbox.Repository;

import com.tutorial.sandbox.Entity.Rat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatRepository extends JpaRepository<Rat,Long> {

    List<Rat> findAll();

    Optional<Rat> findById(Long id);

    Rat findByName(String name);

    List<Rat> findAllByAge(Integer age);

    List<Rat> findAllByName(String name);
}
