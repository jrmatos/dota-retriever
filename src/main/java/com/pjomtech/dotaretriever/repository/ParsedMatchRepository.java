package com.pjomtech.dotaretriever.repository;


import com.pjomtech.dotaretriever.model.ParsedMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParsedMatchRepository extends JpaRepository<ParsedMatch, Long> {
    Optional<ParsedMatch> findFirstByChecked(Boolean checked);
}
