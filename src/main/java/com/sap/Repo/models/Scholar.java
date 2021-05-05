package com.sap.scholar.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@Setter
@Getter
public class Scholar {
    @Id
    @Column
    private String id;

    @Column
    public String solution;

    @Column
    private String keyword;

}