package com.sap.repo.services;

import com.sap.repo.models.ErrorDetails;
import com.sap.repo.repository.RepoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepoService {

    RepoRepository repoRepository;

    RepoService(RepoRepository repoRepository){
        this.repoRepository = repoRepository;
    }


    public List<ErrorDetails> getErrors(){
        return this.repoRepository.findAll();
    }

//    public Scholar getScholar(String keyword){
//        return this.scholarRepository.findBySolution(keyword).orElse(null);
//    }

    public ErrorDetails createError(ErrorDetails errorDetails){
        return this.repoRepository.save(errorDetails);
    }

    public void deleteError(String id){
        this.repoRepository.deleteById(id);
    }
}
