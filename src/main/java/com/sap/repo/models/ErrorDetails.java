package com.sap.repo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Setter
@Getter
public class ErrorDetails {
    @Id
    @Column
    private String id;

    @Column
    public String solution;

    @Column
    private String keyword;

}