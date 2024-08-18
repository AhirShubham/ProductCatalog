package com.shubham.springboot.productcatalog.TableInheritanceExamples.SingleTableInheritance.Joined;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jc_two_wheeler")
@PrimaryKeyJoinColumn(name = "Id")
public class TwoWheeler extends Vehicle {
    private String steeringHandle;
    private String bikeName;


}
