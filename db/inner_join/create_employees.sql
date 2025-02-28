CREATE TABLE Employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    position VARCHAR(100),
    department_id int references Departments(id)
);