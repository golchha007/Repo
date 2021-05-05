package com.sap.scholar.controller;

import com.sap.scholar.models.Scholar;
import com.sap.scholar.services.ScholarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ScholarController {
    private ScholarService scholarService;

    ScholarController(ScholarService scholarService){
        this.scholarService = scholarService;
    }

    @GetMapping("/scholar")
    public List<Scholar> getScholars(){
        return this.scholarService.getScholars();
    }

//    @GetMapping("/scholar/{id}")
//    public Scholar getScholar(@PathVariable("id") String id){
//        return this.scholarService.getScholar(id);
//    }

    @PostMapping("/scholar")
    public Scholar createScholar(@RequestBody Scholar scholar){
        String guid = UUID.randomUUID().toString().replace("-", "");
        scholar.setId(guid);
        return this.scholarService.createScholar(scholar);
    }

    @DeleteMapping("/scholar/{id}")
    public void deleteScholar(@PathVariable("id") String id){
        this.scholarService.deleteScholar(id);
        System.out.println("deleted");
    }
}
