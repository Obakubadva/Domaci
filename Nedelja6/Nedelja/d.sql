SELECT dependents.first_name, dependents.last_name FROM dependents
INNER JOIN employees ON employees.employee_id = dependents.employee_id
WHERE  salary  IN (SELECT MAX (salary) FROM employees)

SELECT country_name FROM countries 
INNER JOIN locations ON countries.country_id = locations.country_id
INNER JOIN departments ON locations.location_id= departments.location_id
INNER JOIN employees ON departments.department_id = employees.department_id
GROUP BY country_name ORDER BY SUM (salary) DESC

SELECT email, phone_number FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
INNER JOIN locations ON departments.location_id = locations.location_id
INNER JOIN countries ON locations.country_id = countries.country_id
INNER JOIN regions ON countries.region_id = regions.region_id
WHERE phone_number IS NOT NULL AND region_name = 'Europe'

SELECT email, phone_number  FROM employees 
WHERE department_id IN ( SELECT department_id FROM departments 
WHERE location_id IN (SELECT location_id FROM locations
WHERE country_id IN ( SELECT country_id FROM countries
WHERE region_id IN (SELECT region_id FROM regions WHERE region_name = 'Europe'))))
GROUP BY phone_number, email
HAVING phone_number IS NOT NULL
