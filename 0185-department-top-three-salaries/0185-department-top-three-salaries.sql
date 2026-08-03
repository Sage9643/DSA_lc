# Write your MySQL query statement below
select t.Department as Department,t.Employee as Employee, t.Salary as Salary from     
    (select d.name as Department, e.name as Employee, e.salary as Salary,
    dense_rank() over(
        partition by e.departmentId
        order by salary desc
    ) as rnk
    from employee as e
    join department as d
    on e.departmentId=d.id
    )t

where rnk<=3;
