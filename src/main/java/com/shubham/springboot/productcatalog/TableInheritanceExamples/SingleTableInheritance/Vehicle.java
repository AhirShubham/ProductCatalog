package com.shubham.springboot.productcatalog.TableInheritanceExamples.SingleTableInheritance;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name="st_vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", discriminatorType = DiscriminatorType.INTEGER)
public class Vehicle {
    @Id
    private int vehicleId;
    private String vehicleName;


}
