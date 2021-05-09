package com.sap.repo.repository;

import com.sap.repo.models.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetails,String> {
    
}
