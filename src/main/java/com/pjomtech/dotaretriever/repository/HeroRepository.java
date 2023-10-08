package com.pjomtech.dotaretriever.repository;

import com.pjomtech.dotaretriever.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
}
