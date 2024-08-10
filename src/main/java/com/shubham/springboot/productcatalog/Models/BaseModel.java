package com.shubham.springboot.productcatalog.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

//We make it abstract because this will be just be used in inherited classes
public abstract class BaseModel {

    private long id;

    private Date createdAt;

    private Date lastUpdatedAt;

    private Status status;
}
