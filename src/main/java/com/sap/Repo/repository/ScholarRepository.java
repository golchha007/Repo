package com.sap.scholar.repository;

import com.sap.scholar.models.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScholarRepository extends JpaRepository<Scholar, String> {
}
