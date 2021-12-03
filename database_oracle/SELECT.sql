--처리순서 
-- FROM -> WHERE -> GROUP BY - HAVING - SELECT - ORDER BY

SELECT * FROM employees;

SELECT employee_id, first_name, salary, hire_date
FROM employees;

--주석은 하이픈 두개~

--컬럼 별칭주기 : heading에 별칭값이 나타남
--큰 따옴표는 띄어쓴 별칭 줄 때만 사용됨
SELECT employee_id 사번, first_name "사원 이름", salary, hire_date "hiredate"
FROM employees;

--문자열기호 ''
--문자열결합연산자 ||
SELECT employee_id, first_name, last_name, first_name || last_name, first_name || ' ' || last_name "사원 성명"
FROM employees;

-------------------------------------------------------------------
--자료형 
--문자형 CHAR, VARCHAR2 (VARCHAR2 는 가변길이문자열이라 길이가 짧으면 적은바이트로 저장 가능하지만 CHAR은 고정길이라 모두 같은 바이트크기로 저장한다)
--숫자형 NUMBER
--날짜형 DATE, TIMESTAMP


--연산자
--산술연산자 : +, - *, /
--비교연산자 : >, <, >= , <=, =, <>(같지 않다), !=(윈도우와 리눅스에서는 사용 가능하나 맥에서는 사용이 안되어서 꺽쇠가 같지 않다의 표준이다)
--대입연산자 : 없음
--논리연산자 : AND, OR, NOT
--증감연산자, 삼항연산자 없음
--괄호연산자 : () 우선순위를 높여줌
--BETWEEN연산자 : <= AND >= 와 같은 표현
--IN연산자 : 

--------------------------------------------------------------------
--특정 행 추출 : WHERE
--급여가 5000이상인 사원들의 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary >= 5000;

--급여를 12달 곱한 값이 100000이상인 사원들의 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, last_name, salary, salary*12
FROm employees
WHERE salary * 12 >= 100000;


--급여가 5000이상 10000이하인 사원들의 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary >= 5000 AND salary <= 10000;

SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary BETWEEN 5000 AND 10000;

--사원들의 사번, 부서번호를 출력하시오
SELECT employee_id, department_id
FROM employees;

--부서번호가 90이거나, 30이거나, 20인 사원들의 사번, 부서번호
SELECT employee_id, department_id
FROM employees
WHERE department_id = 90 or department_id = 30 or department_id = 20;

SELECT employee_id, department_id
FROM employees
WHERE department_id IN (20, 30, 90);


--부서번호가 90이거나, 30이거나, 20이고
--급여가 5000이상 10000이하인 사원들의 사번, 이름, 급여를 출력하시오
--AND연산이 먼저 수행된다
SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE (department_id = 90 OR department_id = 30 OR department_id = 20) 
    AND (salary >= 5000 AND salary <= 10000);

SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE department_id IN (20, 30, 90) AND salary BETWEEN 5000 AND 10000;

--부서번호가 90이 아니고 30이 아니고 20이 아닌 부서의 사번, 이름, 부서번호를 출력하시오
SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE department_id <> 90 AND department_id <> 30 AND department_id <> 20;

SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE department_id NOT IN (90, 30, 20);

--지무테이블
SELECT * FROM jobs;

--Manager로 끝나는 직무명을 출력하시오
SELECT job_title
FROM jobs
WHERE job_title LIKE '%Manager';

--사원의 이름에 'e'가 들어간 사원
SELECT employee_id, first_name
FROM employees
WHERE first_name LIKE '%e%';

--사원의 입사일자를 출력하시오
SELECT hire_date FROM employees;

--입사년도가 07년도인 사원의 사번, 입사일자를 출력하시오
--자료가 많거나 컬럼값이 길경우에는 LIKE연산자는 권장되지 않는다
SELECT employee_id, hire_date
FROM employees
WHERE hire_date LIKE '07%'
ORDER BY hire_date asc;

SELECT employee_id, hire_date
FROM employees
WHERE hire_date BETWEEN '07/01/01' AND '07/12/31';


--입사월이 11월인 사원의 사번, 입사일자를 출력하시오
SELECT employee_id, hire_date
FROM employees
WHERE hire_date LIKE '__/11/__';
-------------------------------------------
-- ORDER BY : 정렬, 오름차순 내림차순


--적은 급여를 받는 사원부터 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary;

--많은 급여를 받는 사원부터 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary desc;

--많은 급여를 받는 사원부터 사번, 이름, 급여를 출력하시오 급여가 같을 경우 이름을 사전순으로 출력하시오
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC , first_name ASC;

SELECT employee_id 사번, first_name 이름, salary 급여
FROM employees
ORDER BY 급여 DESC , 이름 ASC;--별칭사용 가능

SELECT employee_id, first_name, salary
FROM employees
ORDER BY 3 DESC , 2 ASC;

--많은 급여를 받는 사원부터 사번, 이름을 출력하시오
SELECT employee_id, first_name
FROM employees
ORDER BY salary DESC;

--DISTINCT : 중복제거
--사원의 부서번호를 출력하시오
SELECT department_id
FROM employees;

--사원이 속한 부서번호를 중복없이 출력
SELECT DISTINCT department_id
FROM employees;

--사원이 속한 부서번호, 직무번호
SELECT department_id, job_id
FROM employees
ORDER BY department_id, job_id;

--사원이 속한 부서번호, 직무번호를 중복 없이 출력
SELECT DISTINCT department_id, job_id
FROM employees
ORDER BY department_id, job_id;

SELECT DISTINCT job_id, department_id
FROM employees
ORDER BY job_id, department_id;
---------------------------
--SELECT
--FROM
--WHERE
--GROUP BY
--HAVING
--ORDER BY

--NULL : 아무값도 아니다
SELECT employee_id, first_name, last_name, department_id, salary, commission_pct
FROM employees;

--부서배치 받지 않는 사원의 사번, 이름, 부서번호를 출력하시오
--null값은 비교 연산자로 비교 불가 값이 아니기 때문에
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id = null;--null비교 하면 안됌

--is null을 이용해서 null값인지 판단 할 수 있다.
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id IS NULL;

--부서배치를 받은 사원의 사번, 이름, 부서번호를 출력하시오
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id IS NOT NULL;

--모든 사원의 사번, 이름, 급여, 수당률, 급여 * 수당률 + 급여 을 출력하시오
--산술연산에 null이 참여하면 결과는 무조건 null
SELECT employee_id, first_name, salary, commission_pct, (salary * commission_pct) + salary 실급여
FROM employees;

--NULL관련 함수 : NVL(표현식, 반환값) 표현식이 NULL이면 반환값을 반환하고, 표현식이 null이 아니면 표현식값을 반환한다.
SELECT employee_id, first_name, salary, commission_pct, (salary * NVL(commission_pct, 0)) + salary 실급여
FROM employees;

--작은 부서번호를 갖는 사원부터 출력하시오
--오라클은 오름차순에서 null값이 맨뒤에 있고 my-sql에선 앞에 나온다.
SELECT employee_id, department_id
FROM employees
ORDER BY department_id; --오름차순하면 null이 가장 마지막에 출력됨, DBMS마다 다름

--------------------------------------------------------
--ROWNUM : 행번호값을 갖는 의사컬럼
SELECT rownum, employee_id FROM employees;
--실행순서 : FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY
SELECT rownum, employee_id, salary FROM employees ORDER BY salary DESC;

--급여를 많이 받는 사원순으로 5명만 출력하시오
SELECT rownum, employee_id, salary
FROM employees
WHERE rownum <= 5
ORDER BY SALARY DESC;

SELECT rownum, employee_id, salary
FROM employees
WHERE rownum <= 10
ORDER BY SALARY DESC;
--상위 몇명을 뽑기위해선 서브쿼리를 사용해야한다.

