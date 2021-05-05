package com.sap.scholar.services;

import com.sap.scholar.models.Scholar;
import com.sap.scholar.repository.ScholarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScholarService {

    ScholarRepository scholarRepository;

    ScholarService(ScholarRepository scholarRepository){
        this.scholarRepository = scholarRepository;
    }


    public List<Scholar> getScholars(){
        return this.scholarRepository.findAll();
    }

//    public Scholar getScholar(String keyword){
//        return this.scholarRepository.findBySolution(keyword).orElse(null);
//    }

    public Scholar createScholar(Scholar scholar){
        return this.scholarRepository.save(scholar);
    }

    public void deleteScholar(String id){
        this.scholarRepository.deleteById(id);
    }
}
