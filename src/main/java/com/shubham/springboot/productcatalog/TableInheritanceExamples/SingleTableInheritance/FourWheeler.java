package com.shubham.springboot.productcatalog.TableInheritanceExamples.SingleTableInheritance;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name="st_four_wheeler")
@DiscriminatorValue(value="1")
public class FourWheeler extends Vehicle {
    private String steeringWheel;
    private String carName;

}
