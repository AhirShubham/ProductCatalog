package com.shubham.springboot.productcatalog.TableInheritanceExamples.SingleTableInheritance.Joined;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;


@Getter
@Setter
@Entity(name="jc_vehicle")
@Inheritance(strategy = InheritanceType.JOINED)

public class Vehicle {
    @Id
    private int vehicleId;
    private String vehicleName;
    private String vehicleType;

}
