package com.sap.repo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ErrorDetails {
    @Id
    @Column
    private String id;

    @Column
    public String solution;

    @ElementCollection
    private List<String> keyword;


    public String getId() {
        return id;
    }

    public String getSolution() {
        return solution;
    }

    public List<String> getKeyword() {
        return keyword;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }

    public ErrorDetails() {

    }

    public ErrorDetails(String id, String solution, List<String> keyword) {
        this.id = id;
        this.solution = solution;
        this.keyword = keyword;
    }

    public ErrorDetails(String id) {
        this.id = id;
    }
}