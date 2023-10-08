package com.pjomtech.dotaretriever.repository;


import com.pjomtech.dotaretriever.model.PublicMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicMatchRepository extends JpaRepository<PublicMatch, Long> {
    Optional<PublicMatch> findFirstByChecked(Boolean checked);
}
