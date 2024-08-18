This is same as @MappedSuperclass but here we have separate table for each class including the parent table.

Disadvantages:
1. It creates separate table for each class which is not good for performance.
2. The columns are duplicated (present in both parent and child tables).

Advantages:
 1. no sparse tables.