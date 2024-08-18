package com.shubham.springboot.productcatalog.TableInheritanceExamples.SingleTableInheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_two_wheeler")
@DiscriminatorValue(value="2")
public class TwoWheeler extends Vehicle {
    private String steeringHandle;
    private String bikeName;


}
