package com.sap.repo.services;

import com.sap.repo.models.ErrorDetails;
import com.sap.repo.repository.RepoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepoService {

    private final RepoRepository repoRepository;

    RepoService(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    public List<ErrorDetails> getErrors() {
        try
        {
            return this.repoRepository.findAll();
        }
        catch (Exception e)
        {
            return null;
        }

    }

    public ErrorDetails createError(ErrorDetails errorDetails) {
        try
        {
            this.repoRepository.save(errorDetails);
            return errorDetails;
        }
        catch(Exception e)
        {
            return null;
        }

    }

    public Boolean deleteError(String id) {
        try
        {
            this.repoRepository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<ErrorDetails> getAllAuthorErrors(String authorId) {
        try
        {
            return this.repoRepository.findByAuthorId(authorId);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public ErrorDetails updateErrorDetails(ErrorDetails errorDetails)
    {
        try
        {
            ErrorDetails errorDetails1 = repoRepository.getOne(errorDetails.getId());
            errorDetails1.setSolution(errorDetails.getSolution());
            errorDetails1.setKeywords(errorDetails.getKeywords());
            errorDetails1.setDescription(errorDetails.getDescription());
            errorDetails1.setType(errorDetails.getType());

            this.repoRepository.save(errorDetails);
            return errorDetails;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
