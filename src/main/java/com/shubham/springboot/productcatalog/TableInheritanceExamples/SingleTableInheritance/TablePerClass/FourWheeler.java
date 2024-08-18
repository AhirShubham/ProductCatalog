package com.shubham.springboot.productcatalog.TableInheritanceExamples.SingleTableInheritance.TablePerClass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name="tpc_four_wheeler")
public class FourWheeler extends Vehicle {
    private String steeringWheel;
    private String carName;

}
