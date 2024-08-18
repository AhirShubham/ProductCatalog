package com.shubham.springboot.productcatalog.TableInheritanceExamples.SingleTableInheritance.Joined;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;


@Getter
@Setter
@Entity(name="jc_four_wheeler")
@PrimaryKeyJoinColumn(name = "Id")
public class FourWheeler extends Vehicle {
    private String steeringWheel;
    private String carName;

}
