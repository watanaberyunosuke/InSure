package com.harrybwatson.insure.phr.repository;

import com.harrybwatson.insure.phr.model.PHR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhrRepository extends JpaRepository<PHR, Long> {

    // Left blank intentionally
}
