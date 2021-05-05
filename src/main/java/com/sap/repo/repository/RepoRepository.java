package com.sap.repo.repository;

import com.sap.repo.models.ErrorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRepository extends JpaRepository<ErrorDetails, String> {
}
