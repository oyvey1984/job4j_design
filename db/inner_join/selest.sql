SELECT e.name AS employee_name, e.position, d.name AS department_name
FROM Employees e
INNER JOIN Departments d ON e.department_id = d.id;

SELECT d.name AS department_name, e.name AS manager_name
FROM Departments d
INNER JOIN Employees e ON e.department_id = d.id;

SELECT e.name AS manager_name, e.position AS position, d.name AS department_name
FROM Employees e
INNER JOIN Departments d ON e.department_id = d.id;