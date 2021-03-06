package com.sap.repo.models;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the LoginDetails")
public class UserDetails {

    @Id
    @Column
    private String username;

    @Column
    private String passcode;

    @Column
    private String fullname;

    @Column
    private Integer count;

}
