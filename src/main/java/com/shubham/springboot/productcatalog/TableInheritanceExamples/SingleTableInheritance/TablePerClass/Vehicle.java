package com.shubham.springboot.productcatalog.TableInheritanceExamples.SingleTableInheritance.TablePerClass;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name="tpc_vehicle")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
    @Id
    private int vehicleId;
    private String vehicleName;
    private String vehicleType;

}
