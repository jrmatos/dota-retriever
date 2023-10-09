package com.pjomtech.dotaretriever.repository;


import com.pjomtech.dotaretriever.model.Rampage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RampageRepository extends JpaRepository<Rampage, UUID> {
}
