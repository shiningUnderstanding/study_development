--그룹함수 : SUM(), COUNT(), AVG(), MAX(), MIN() ...
SELECT SUM(salary)  급여총합
, COUNT(*) 수
, COUNT(department_id) "부서를 갖는 사원수"
, COUNT(commission_pct) "수당을 받는 사원수"
, AVG(salary) "평균급여"
, MAX(salary) "최대급여"
, MIN(salary) "최소급여"
FROM employees;

--A테이블
--a1
--100
--200
--null
--400
CREATE TABLE a(a1 number);
INSERT INTO a VALUES(100);
INSERT INTO a VALUES(200);
INSERT INTO a VALUES(null);
INSERT INTO a VALUES(400);
SELECT * FROM a;

--avg()함수는 null을 제외한 행수로 총합을 나눈것이다.
SELECT SUM(a1), COUNT(a1), AVG(a1)
FROM a;

DROP table a;
-------------------------------------------------

--부서별 사원수를 출력하시오
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id
ORDER BY COUNT(*) DESC;
--ORDER BY 2 DESC

--group by절에서 사용한 컬럼만 select절에서 사용 가능
SELECT employee_id, department_id, COUNT(*)
FROM employees
GROUP BY department_id, employee_id;

--2007년에 입사한 사원수와 평균급여를 출력하시오
SELECT COUNT(*) "2007년 입사자수", AVG(salary) "2007년 사원 평균급여"
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') = '2007' ;

--년도별 입사한 사원수와 평균 급여를 출력하시오. 단 최근연도부터 출력하시오
SELECT TO_CHAR(hire_date, 'YYYY'), COUNT(*), AVG(salary)
FROM employees
GROUP BY TO_CHAR(hire_date, 'YYYY')
ORDER BY 1 DESC;

--월별 입사한 사원수와 평균 급여를 출력하시오. 단 1월부터 출력하시오
SELECT TO_NUMBER(TO_CHAR(hire_date, 'MM')), COUNT(*), AVG(salary)
FROM employees
GROUP BY TO_CHAR(hire_date, 'MM')
ORDER BY 1 ASC;

SELECT TO_NUMBER(TO_CHAR(hire_date, 'FMMM')), COUNT(*), AVG(salary)
FROM employees
GROUP BY TO_CHAR(hire_date, 'FMMM')
ORDER BY 1 ASC;

--지역
SELECT location_id, city
FROM locations;

--부서
SELECT department_id, location_id
FROM departments;

--지역별 지역번호, 부서수를 출력하시오
SELECT location_id, COUNT(*)
FROM departments
GROUP BY location_id;

SELECT COUNT(*)
FROM departments;

--지역별 지역번호, 도시명, 부서수를 출력하시오 --> 아직 안됌, 해결하려면 subquery나 join을 활용해야함
SELECT location_id, city, COUNT(*)
FROM departments
GROUP BY location_id;

--하반기(7~12월) 월별 입사자수를 출력하시오
SELECT TO_NUMBER(TO_CHAR(hire_date, 'FMMM')), COUNT(*)
FROM employees
WHERE TO_NUMBER(TO_CHAR(hire_date, 'MM')) >= '07'
GROUP BY TO_CHAR(hire_date, 'FMMM')
ORDER BY 1 ASC;

--하반기(7~12월) 월별 입사자수를 출력하시오. 단, 입사자수가 7명 이상인 월만 출력하시오
SELECT TO_NUMBER(TO_CHAR(hire_date, 'FMMM')), COUNT(*)
FROM employees
WHERE TO_CHAR(hire_date, 'MM') BETWEEN '07' AND '12'--WHERE절에서는 그룹함수 사용 불가
GROUP BY TO_CHAR(hire_date, 'FMMM')
HAVING count(*) >= 7
ORDER BY 1 ASC;

--급여가 5000이상인 사원들의 부서별 평균급여를 출려하시오
SELECT department_id, avg(salary)
FROM employees
WHERE salary >= 5000
GROUP BY department_id
ORDER BY 1;

--급여가 10000이상인 사원들의 부서별 평균급여를 출려하시오
SELECT department_id, avg(salary)
FROM employees
WHERE salary >= 5000
GROUP BY department_id
HAVING avg(salary) >= 10000
ORDER BY 1;

-----------------------------------------
--부서별 사원수를 출력하시오.
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id;

--부서별 사원수를 출력하시오. 총사원수도 출력하시오
SELECT department_id, COUNT(*)
FROM employees
GROUP BY ROLLUP(department_id);

--부서별, 직무별 사원수를 출력하시오
SELECT department_id, job_id, COUNT(*)
FROM employees
GROUP BY department_id, job_id
ORDER BY department_id, job_id;

--부서별, 직무별 사원수를 출력하시오
SELECT NVL(TO_CHAR(department_id), '총사원수'),
       NVL(job_id, '부서별 사원수'), 
       COUNT(*)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY ROLLUP(department_id, job_id)
ORDER BY department_id, job_id;

SELECT department_id,
       job_id, 
       COUNT(*)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY CUBE(department_id, job_id)
ORDER BY department_id, job_id;
