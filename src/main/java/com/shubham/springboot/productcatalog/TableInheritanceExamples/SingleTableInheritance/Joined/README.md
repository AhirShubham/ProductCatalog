
To remove the issue in TablePerClass, we can keep the values of parent class columns 
in parent table and only the child columns will be present in child tables.

We can then refer the parent table using the primary key of the parent table in the child tables.
Parent table has primary_key and it is inserted as foreign key in child classes to join for queries.

Vehicle:
      id(PK) vehicle_type    vehicle_type
        1        Car          Four Wheeler

Car:
        vehicle_name  steering_wheel id(FK)
            BMW             right      1



Used when there are lot of columns in parent table and we want to avoid duplicate columns in child tables.

When you create a new child entry, you need to insert the parent entry first and then the child entry.


Advantages:
1. No duplicate columns.
2. No sparse data in the table.
3. Normalized.

Disadvantages:  
1. Join is required to get the data from parent table.