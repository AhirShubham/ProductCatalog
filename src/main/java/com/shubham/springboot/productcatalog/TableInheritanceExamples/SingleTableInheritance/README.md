
We have used @MappedSuperClass wherein:
No table is created for the parent class and only the child class tables are created with inherited fields from parent.

We have used @Inheritance(strategy = InheritanceType.SINGLE_TABLE) wherein:
All the fields of parent and child classes are stored in a single table. This is the default behavior of Hibernate if we don't specify
any inheritance strategy.

Advantages:
1. Simplest and easiest to implement.
2. No joins are required to fetch the data.
3. No duplicate columns are created in the child tables.

Disadvantages:  
1. Null values are allowed in the columns which are not applicable to the child class.
2. Not normalized.
3. Sparse data in the table.