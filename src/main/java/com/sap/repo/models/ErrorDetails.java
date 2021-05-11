package com.sap.repo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    @Id
    @Column
    private String id;

    @Column
    public String solution;

    @ElementCollection
    private List<String> keywords;

    @Column
    private String authorId;

    @Column
    private String Description;

}