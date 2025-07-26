---

### 1. What is Normalization?

```
Normalization is the process of organizing data in a database to avoid redundancy and improve data integrity.

- 1NF: Atomic values
- 2NF: No partial dependency
- 3NF: No transitive dependency
- BCNF: Every determinant is a candidate key
```

---

### 2. Difference Between WHERE and HAVING

```sql
-- WHERE filters rows before GROUP BY
-- HAVING filters groups after aggregation

SELECT department, COUNT(*) 
FROM employees 
WHERE salary > 30000 
GROUP BY department 
HAVING COUNT(*) > 5;
```

---

### 3. Primary Key vs Foreign Key

```sql
-- Primary Key uniquely identifies rows in a table
-- Foreign Key links two tables together

CREATE TABLE Departments (
    dept_id INT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE Employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(100),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);
```

---

### 4. What is ACID Property?

```
ACID stands for:

- Atomicity: All or none operations
- Consistency: Maintains DB integrity
- Isolation: Transactions occur independently
- Durability: Changes persist after commit
```

---

### 5. DELETE vs TRUNCATE vs DROP

```
DELETE: Removes rows based on condition, can be rolled back
TRUNCATE: Removes all rows, faster, cannot be rolled back
DROP: Deletes entire table structure, cannot be recovered
```

---

### 6. What is Indexing?

```sql
-- Indexes improve query performance on columns

CREATE INDEX idx_name ON Employees(name);
```

---

### 7. What is a View?

```sql
-- A virtual table based on a SELECT query

CREATE VIEW HighEarners AS
SELECT name, salary 
FROM Employees 
WHERE salary > 100000;
```

---

### 8. Transaction States

```
Transaction lifecycle:
1. Active
2. Partially Committed
3. Committed
4. Failed
5. Aborted
```

---

### 9. What is Deadlock?

```
Deadlock is a situation where two or more transactions wait indefinitely for each other’s resources, causing a halt in execution.
```

---

### 10. Types of JOINs

```sql
-- INNER JOIN: Only matching rows
-- LEFT JOIN: All rows from left + matches from right
-- RIGHT JOIN: All rows from right + matches from left
-- FULL JOIN: All rows from both tables

SELECT e.name, d.name
FROM Employees e
INNER JOIN Departments d
ON e.dept_id = d.dept_id;
```

---
