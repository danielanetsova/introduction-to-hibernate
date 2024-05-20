# Name
Introduction To Hibernate

## Description
Each class represent a different task. For all tasks softuni_database is used which is located in resources package.

### Tasks:
- AddingNewAddressUpdatingEmployee class creates a new address with the text "Vitoshka 6" and sets that address to an employee with a last name, given as input.
- AddressesWithEmployeeCount class finds all addresses, ordered by the number of employees who live there (descending). Takes only the first 10 addresses and prints their address text, town name and employee count. 
- ChangeCasing class persists all towns from the database. Detaches those whose name length is more than 5 symbols. Then transforms the names of all attached towns to uppercase and saves them to the database.
- ContainsEmployee class checks if a given employee's name is contained in the database.
- EmployeesFromDepartment class extracts all employees from the Research and Development department. Orders them by salary (in ascending order), then by id (in ascending order). Prints only their first name, last name, department name and salary.
- EmployeesMaxSalaries class finds the max salary for each department. Filters the departments, which max salaries are not in the range between 30000 and 70000.
- EmployeesWithSalaryOver50000 class gets the first name of all employees who have a salary over 50 000.
- FindEmployeesByFirstName class finds all employees, whose first name starts with a pattern given as input from the console. Print their first and last names, their job title and salary.
- FindTheLatestTenProjects class prints the last 10 started projects. Prints their name, description, start and end date and sorts them by name lexicographically.
- GetEmployeesWithProject class gets an employee by his/her id. Prints only his/her first name, last name, job title and projects (only their names). The projects should be ordered by name (ascending).
- IncreaseSalaries class increases the salaries of all employees, who are in the Engineering, Tool Design,Marketing, or Information Services departments by 12%. Then prints the first name, the last name and the salary for the employees, whose salary was increased.
