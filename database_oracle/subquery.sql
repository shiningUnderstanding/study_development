--서브쿼리
--스칼라쿼리 : SELECT (SELECT~~~)
--인라인뷰   :FROM (SELECT~~~)
--서브쿼리   :WHERE 컬럼 비교연산 (SELECT~~~)

--최대급여를 받는 사원의 급여를 출력하시오
SELECT MAX(salary)
FROM employees;

--최대급여를 받는 사원의 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, MAX(salary) FROM employees; -- (X)

--최대급여를 받는 사원의 사번, 이름, 급여를 출력하시오
--1)최대급여를 검색한다
--2)1)과 같은 급여를 받는 사원의 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, salary
FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees);

SELECT employee_id, first_name, salary
FROM employees
WHERE salary IN (SELECT MAX(salary)
                 FROM employees);
                 
--평균급여보다 많은 급여를 받는 사원들의 사번 이름 급여를 출력하시오
--1)평균급여를 검색한다
--2) 1)보다 많은 급여를 받는 사우너의 사번, 이름, 급여를 출력
SELECT employee_id, first_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

--최대급여를 받는 사원과 같은 부서에서 근무하는 사원들의 사번, 이름, 급여, 부서번호를 출력하시오
--1)최대급여를 검색한다.
--2) 1)과 급여를 받는 사원의 부서번호를 검색한다 --90
--3) 2)와 같은 부서번호를 갖는 사원의 출력
SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE department_id = (SELECT department_id
                       FROM employees
                       WHERE salary = (SELECT MAX(salary) FROM employees));

------------------------------------------------------
--행 하나만 반환하는 서브쿼리를 단일행 서브쿼리라 한다.
--서브쿼리의 반환행수별 종류
--단일행서브쿼리 : 비교연산자 사용가능 (=, <> , <, <=, >, >=)
--여러행서브쿼리 : IN, ANY, ALL연산자만 가능

--여러행 서브쿼리
--부서별 평균급여를 출력하시오
SELECT department_id, AVG(salary)
FROM employees
GROUP BY department_id;

--부서별 최대급여를 받는 사원의 부서번호, 사번, 이름, 급여를 출력하시오
--1) 부서별 최대급여를 계산
--2) 1)의 행들과 비교
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE salary = (SELECT MAX(salary) 
                FROM employees 
                GROUP BY department_id); --(X)

SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE salary IN (SELECT MAX(salary) 
                 FROM employees 
                 GROUP BY department_id); --(X:결과가 틀림)

--서브쿼리 컬럼 개수를 맞춰주면 계산 가능
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN (SELECT department_id, MAX(salary) 
                                  FROM employees 
                                  GROUP BY department_id);
                                  
--null값까지 포함시키려면 NVL함수 사용
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE (NVL(department_id, 0), salary) IN (SELECT NVL(department_id, 0), MAX(salary) 
                                          FROM employees 
                                          GROUP BY department_id);
                                          
--
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE (NVL(department_id, 0), salary) =ANY (SELECT NVL(department_id, 0), MAX(salary) 
                                            FROM employees 
                                            GROUP BY department_id);
            
-------------------------------------------------------------------
--직무가 IT_PROG인 사원들의 최대급여보다 작은 급여를 받는 사원의 사번, 이름, 급여, 직무를 출력하시오
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE job_id = 'IT_PROG';

SELECT employee_id, first_name, salary, job_id
FROM employees
WHERE salary < (SELECT MAX(salary)
                FROM employees
                WHERE job_id = 'IT_PROG');

SELECT employee_id, first_name, salary, job_id
FROM employees
WHERE salary < ANY (SELECT salary
                    FROM employees
                    WHERE job_id = 'IT_PROG');

--------------------------------------------------------------
--직책(job_title)이 'President'인 사원의 사번, 이름을 출력하시오
SELECT employee_id, first_name
FROM employees NATURAL JOIN jobs
WHERE job_title = 'President';

SELECT employee_id, first_name
FROM employees
WHERE job_id = (SELECT job_id
                   FROM jobs
                   WHERE job_title = 'President');
            
            
--성이 'Davies와'인 사원과 같은 부서에 근무하는 사원들의 사번, 성, 이름을 출력하시오
SELECT employee_id, last_name, first_name, department_id
FROM employees
WHERE department_id = (SELECT department_id
                        FROM employees
                        WHERE last_name = 'Davies')
AND last_name <> 'Davies';
----------------------------------------------------------
--스칼라쿼리
--부서번호, 부서명, 부서별 급여총액을 출력하시오
SELECT department_id, department_name, SUM(salary)
FROM employees e JOIN departments d USING(department_id)
GROUP BY department_id, department_name;

SELECT department_id,
      (SELECT department_name
       FROM departments
       WHERE department_id = employees.department_id) 부서명, 
       SUM(salary) 
FROM employees
GROUP BY department_id;


------------------------------------------------------------------
--'Sales'부서의 평균급여보다 많은 급여를 받는 사원들의 부서번호, 사번, 급여를 출력하시오
SELECT department_id, employee_id, salary
FROM employees
WHERE salary > (SELECT AVG(salary)
                FROM employees JOIN departments USING(department_id)
                WHERE department_name = 'Sales'
                GROUP BY department_id);
                
 
SELECT department_id, employee_id, salary
FROM employees
WHERE salary > (SELECT AVG(salary)
                FROM employees
                WHERE (SELECT department_name
                       FROM departments
                       WHERE department_id = employees.department_id) = 'Sales'
                GROUP BY department_id);
                
                
----------------------------------------------------------------------------
--상호연관서브쿼리로해결
SELECT department_id, employee_id, salary
FROM employees maine
WHERE salary > (SELECT AVG(salary)
                FROM employees
                WHERE department_id = maine.department_id)
AND department_id = (SELECT department_id
                     FROM departments
                     WHERE department_name = 'Sales');
    
---------------------------------------------------------
--상호연관서브쿼리로 해결
SELECT department_id, employee_id, salary
FROM employees maine
WHERE salary >(SELECT AVG(salary) 
               FROM employees
               WHERE department_id = maine.department_id
               )   
AND department_id = (SELECT department_id 
                    FROM departments 
                    WHERE department_name='Sales');
----------------------------------------------------------
--INLINE VIEW
--ROWNUM : 행번호 의사컬럼
SELECT ROWNUM, employee_id, salary
FROM employees;

--적은급여를 받는 사원부터 사번, 급여를 출력하시오
SELECT ROWNUM, employee_id, salary
FROM employees
ORDER BY salary;

--적은급여를 받는 사원의 행번호가 1번부터 시작되도록  출력하시오
SELECT ROWNUM, employee_id, salary
FROM (SELECT employee_id, salary
      FROM employees
      ORDER BY salary);

--적은급여를 받는 사원의 행번호가 1번부터 시작되도록  출력하시오
--행번호가 1~5행만 출력한다
SELECT ROWNUM, employee_id, salary
FROM (SELECT employee_id, salary
      FROM employees
      ORDER BY salary)
WHERE ROWNUM BETWEEN 1 AND 5;
                 
---------------------------
--INLINE VIEW
--ROWNUM : 행번호 의사 컬럼
SELECT ROWNUM, employee_id, salary
FROM employees;

SELECT ROWNUM, employee_id, salary
FROM employees
ORDER BY salary;

SELECT ROWNUM, employee_id, salary
FROM (SELECT employee_id, salary FROM employees ORDER BY salary)
WHERE ROWNUM BETWEEN 1 AND 5;

--적은 급여를 받는 사원의 행번호가 1번부터 시작되도록 출력하시오
--행번호가 6~10행만 출력한다.
--????
--첫번째 rownum 1을 지급하면 between연산자에 의해 다음 rownum을 호출하게 되는데
--역시 1을 지급하기 때문에 끝까지 저장이 안된다.
--즉 where절을 만족한 순서로 1을 부여하는데 만족하는 친구가 생기지 않는다.
SELECT ROWNUM, employee_id, salary
FROM (SELECT employee_id, salary 
      FROM employees 
      ORDER BY salary)
WHERE ROWNUM BETWEEN 6 AND 10;

--그래서 만약 1순위부터 뽑는게 아니면 한 번 더 서브쿼리를 사용해야 한다.
SELECT *
FROM (SELECT ROWNUM r, employee_id, salary
      FROM (SELECT employee_id, salary 
            FROM employees 
            ORDER BY salary)
     )
WHERE r BETWEEN 6 AND 10;
