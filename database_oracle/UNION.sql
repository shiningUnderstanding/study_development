--집합
--사원의 사번, 직무번호를 출력하시오
SELECT employee_id, job_id
FROM employees;

--직무경력(job_history)의 사번, 이전직무번호를 출력하시오
SELECT employee_id, job_id, start_date, end_date
FROM job_history;

--101번 사원의 이전직무와 현재직무를 모두 출력하시오 --3건
--UNION을 사용할 때 SELECT안의 컬럼의 갯수와 각 컬럼의 자료형도 일치해야 한다.
SELECT employee_id, job_id
FROM job_history
WHERE employee_id = 101
UNION
SELECT employee_id, job_id
FROM employees
WHERE employee_id = 101;

SELECT employee_id, job_id
FROM job_history
UNION
SELECT employee_id, job_id
FROM employees;

--176번 사원의 이전직무와 현재직무를 모두 출력하시오 --2건
--단, 중복직무는 제거합니다.
SELECT employee_id, job_id
FROM job_history
WHERE employee_id = 176
UNION
SELECT employee_id, job_id
FROM employees
WHERE employee_id = 176;

--176번 사원의 이전직무와 현재직무를 모두 출력하시오 --3건
--UNION ALL은 중복을 허용합니다.
SELECT employee_id, job_id
FROM job_history
WHERE employee_id = 176
UNION ALL
SELECT employee_id, job_id
FROM employees
WHERE employee_id = 176;
---------------------------------------------------
--교집합
SELECT employee_id, job_id
FROM job_history
INTERSECT
SELECT employee_id, job_id
FROM employees;

--차집합
SELECT employee_id, job_id
FROM job_history
MINUS
SELECT employee_id, job_id
FROM employees;

--집합연산자에서 ORDER BY는 맨 마지막에 나와야 한다.
SELECT employee_id, job_id
FROM job_history
UNION
SELECT employee_id, job_id
FROM employees
ORDER BY employee_id DESC;

-----------------------------------------------------
