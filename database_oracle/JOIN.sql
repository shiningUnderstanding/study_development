--사원의 사번, 이름, 부서번호, 부서명을 출력하시오
SELECT employee_id, first_name, e.department_id, department_name
FROM employees e JOIN departments d ON (e.department_id = d.department_id);

SELECT *
FROM employees, departments;

--오라클 전용 JOIN 표기법
SELECT *
FROM employees, departments
WHERE employee_id.department_id = Departments.department_id;

--ANSI JOIN
SELECT employee_id, first_name, e.department_id, department_name
FROM employees e JOIN departments d ON (e.department_id = d.department_id);

--NATURAL JOIN
--사원의 사번, 이름, 직무번호, 직무명을 출력하시오
SELECT employee_id, first_name, employees.job_id, job_title
FROM employees JOIN jobs ON(employees.job_id = jobs.job_id);

SELECT employee_id, first_name, job_id, job_title
FROM employees NATURAL JOIN jobs;

--사원의 사번, 이름, 직무번호, 직무명을 출력하시오
--NUTURAL JOIN은 컬럼명이 여러개가 같으면 같은 컬럼 모두를 대상으로 조인 실행됨
SELECT employee_id, first_name, e.department_id, department_name
FROM employees e JOIN departments d ON (e.department_id = d.department_id); --OK

SELECT employee_id, first_name, department_id, department_name
FROM employees NATURAL JOIN departments; --(X)

--USING
SELECT employee_id, first_name, department_id, department_name
FROM employees JOIN departments USING(department_id); --OK

--------------------------------------------------------------------
--OUTER JOIN
--사원의 사번, 이름, 부서번호, 부서명을 출력하시오
SELECT employee_id, first_name, department_id, department_name
FROM employees JOIN departments USING(department_id);

--사원의 사번, 이름, 부서번호, 부서명을 출력하시오
--부서없는 사원도 모두 출력한다.
SELECT employee_id, first_name, department_id, department_name
FROM employees LEFT JOIN departments USING(department_id);

SELECT employee_id, first_name, department_id, department_name
FROM employees RIGHT JOIN departments USING(department_id);

SELECT employee_id, first_name, department_id, department_name
FROM employees FULL JOIN departments USING(department_id);
--여기까지는 ANSI JOIN

--LEFT OUTER JOIN
SELECT employee_id, first_name, d.department_id, department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);--오른쪽에 +하면 레프트 아우터 조인

--RIGHT OUTER JOIN
SELECT employee_id, first_name, d.department_id, department_name
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;--왼쪽에 +하면 라이트 아우터 조인

--FULL OUTER JOIN은 오라클 표준이 없다. ANSI 표준으로만 작성가능

--SELF JOIN
--사원의 사번, 이름, 관리자 번호, 관리자이름을 출력하시오
SELECT e.employee_id 사번, e.first_name 사원명, e.manager_id 관리자번호, m.first_name 관리자명
FROM employees e
JOIN employees m ON (e.manager_id = m.employee_id);

--사원의 사번, 이름, 부서번호, 관리자 번호, 관리자이름, 관리자소속부서를 출력하시오
SELECT e.employee_id 사번, e.first_name 사원명, e.department_id "사원 소속부서", 
       e.manager_id 관리자번호, m.first_name 관리자명, m.department_id "관리자 소속부서"
FROM employees e
JOIN employees m ON (e.manager_id = m.employee_id);

--사원의 사번, 이름, 부서번호, 관리자 번호, 관리자이름, 관리자소속부서를 출력하시오
--사원부서와 관리자부서가 다른 사원들만 출력하시오
SELECT e.employee_id 사번, e.first_name 사원명, e.department_id "사원 소속부서", 
       e.manager_id 관리자번호, m.first_name 관리자명, m.department_id "관리자 소속부서"
FROM employees e
JOIN employees m ON (e.manager_id = m.employee_id)
WHERE e.department_id <> m.department_id;

--사원의 사번, 이름, 급여, 부서번호, 관리자 번호, 관리자이름, 관리자급여, 관리자소속부서를 출력하시오
--사원급여가 관리자급여보다 많은 사원들만 출력하시오
SELECT e.employee_id 사번, e.first_name 사원명, e.salary 급여, e.department_id "사원 소속부서", 
       e.manager_id 관리자번호, m.first_name 관리자명, m.salary 관리자급여, m.department_id "관리자 소속부서"
FROM employees e
JOIN employees m ON (e.manager_id = m.employee_id)
WHERE e.salary > m.salary;