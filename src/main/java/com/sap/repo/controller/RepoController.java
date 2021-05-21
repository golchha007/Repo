package com.sap.repo.controller;

import com.sap.repo.models.ErrorDetails;
import com.sap.repo.services.RepoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RepoController {

    private final RepoService repoService;

    RepoController(RepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping("/error")
    @ApiOperation(value = "Gets all the errors", notes = "No need to pass any payload or path variable")
    public ResponseEntity<List<ErrorDetails>> getErrors() {

        List<ErrorDetails> errors = this.repoService.getErrors();
        if (errors == null)
            return ResponseEntity.noContent().build();

        else
            return ResponseEntity.ok(errors);

    }

    @PostMapping("/error")
    @ApiOperation(value = "Post the error", notes = "Pass the ErrorDetails as payload")
    public ResponseEntity<ErrorDetails> createError(@RequestBody ErrorDetails errorDetails) {

        String guid = UUID.randomUUID().toString().replace("-", "");
        errorDetails.setId(guid);

        ErrorDetails error = this.repoService.createError(errorDetails);

        if (error == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.status(HttpStatus.CREATED).body(error);

    }

    @DeleteMapping("/error/{id}")
    @ApiOperation(value = "Deletes the error on the basis of id passed", notes = "Provide a proper ErrorDetails Id to be deleted as path variable")
    public ResponseEntity deleteError(@ApiParam(value = "Id value of the ErrorDetails you need to delete", required = true)
            @PathVariable("id") String id) {

        Boolean value = this.repoService.deleteError(id);

        if (value)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/error/{authorId}")
    @ApiOperation(value = "Gets all the errors for an authorId", notes = "Do pass authorId as path variable")
    public ResponseEntity<List<ErrorDetails>> getAllAuthorErrors(@PathVariable("authorId") String authorId) {

        List<ErrorDetails> errors = this.repoService.getAllAuthorErrors(authorId);
        if (errors == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(errors);
    }

    @PutMapping("/error/update")
    @ApiOperation(value = "Updates the existing ErrorDetail", notes = "Do pass the updated ErrorDetails as paylaod")
    public ResponseEntity<ErrorDetails> updateErrorDetails(@RequestBody ErrorDetails errorDetails) {
        ErrorDetails errorDetails1 = this.repoService.updateErrorDetails(errorDetails);
        return ResponseEntity.ok(errorDetails1);
    }

    @PostMapping("/error/data")
    @ApiOperation(value = "Just to put initial data for ErrorDetails")
    public ResponseEntity<List<ErrorDetails>> initialData(@RequestBody List<ErrorDetails> errorDetails)
    {

        for(int i=0;i<errorDetails.size();i++)
        {
            String guid = UUID.randomUUID().toString().replace("-", "");
            errorDetails.get(i).setId(guid);
        }


        List<ErrorDetails> errorDetailsList = this.repoService.createInitialErrors(errorDetails);

        if (errorDetailsList == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.status(HttpStatus.CREATED).body(errorDetailsList);
    }



}
