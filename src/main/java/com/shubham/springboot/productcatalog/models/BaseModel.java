package com.shubham.springboot.productcatalog.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
//We make it abstract because this will be just be used in inherited classes
public abstract class BaseModel {

    @Id
    private long id;

    private Date createdAt;

    private Date lastUpdatedAt;

    private Status status;
}
