# Write your MySQL query statement below
select d.name as Department,e.name as Employee ,e.salary as Salary
from employee as e
join department as d
on e.departmentId=d.id
join
    (select departmentId, max(salary) as salary
    from employee
    group by departmentId) k
on e.departmentId=k.departmentId
where k.salary=e.salary;