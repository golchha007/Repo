package com.sap.repo.controller;

import com.sap.repo.models.ErrorDetails;
import com.sap.repo.services.RepoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/errors/")
public class RepoController {

    private final RepoService repoService;

    RepoController(RepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping("/error")
    public ResponseEntity<List<ErrorDetails>> getErrors() {

        List<ErrorDetails> errors = this.repoService.getErrors();
        if(errors==null)
            return ResponseEntity.noContent().build();

        else
            return ResponseEntity.ok(errors);

    }

    @PostMapping("/error")
    public ResponseEntity<ErrorDetails> createError(@RequestBody ErrorDetails errorDetails) {

        String guid = UUID.randomUUID().toString().replace("-", "");
        errorDetails.setId(guid);

        ErrorDetails error = this.repoService.createError(errorDetails);

        if(error==null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(error);

    }

    @DeleteMapping("/error/{id}")
    public ResponseEntity deleteError(@PathVariable("id") String id) {

        Boolean value = this.repoService.deleteError(id);

        if(value)
            return  ResponseEntity.ok().build();
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/error/{authorId}")
    public ResponseEntity<List<ErrorDetails>> getAllAuthorErrors(@PathVariable("authorId") String authorId) {

        List<ErrorDetails> errors = this.repoService.getAllAuthorErrors(authorId);
        if(errors==null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(errors);
    }

}
