package com.sap.repo.controller;

import com.sap.repo.models.ErrorDetails;
import com.sap.repo.services.RepoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class RepoController {
    private RepoService repoService;

    RepoController(RepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping("/error")
    public List<ErrorDetails> getErrors() {
        return this.repoService.getErrors();
    }

//    @GetMapping("/scholar/{id}")
//    public Scholar getScholar(@PathVariable("id") String id){
//        return this.scholarService.getScholar(id);
//    }

    @PostMapping("/error")
    public ErrorDetails createError(@RequestBody ErrorDetails errorDetails) {
        String guid = UUID.randomUUID().toString().replace("-", "");
        errorDetails.setId(guid);
        return this.repoService.createError(errorDetails);
    }

    @DeleteMapping("/error/{id}")
    public void deleteError(@PathVariable("id") String id) {
        this.repoService.deleteError(id);
        System.out.println("deleted");
    }

}
