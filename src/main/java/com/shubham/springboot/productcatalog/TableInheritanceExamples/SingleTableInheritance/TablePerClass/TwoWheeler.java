package com.shubham.springboot.productcatalog.TableInheritanceExamples.SingleTableInheritance.TablePerClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_two_wheeler")
public class TwoWheeler extends Vehicle {
    private String steeringHandle;
    private String bikeName;


}
