--문자형함수
--문자열의 길이를 얻어오는 함수 : LENGTH()
SELECT LENGTH('오라클'), LENGTH('오라클')
FROM dual;

SELECT employee_id, first_name, LENGTH(first_name)
FROM employees;
--이름이 8자리 이상인 사원들의 사번, 이름을 출력하시오
SELECT employee_id, first_name
FROM employees
WHERE LENGTH(first_name) >= 8;

--대문자로 변환 : UPPER(), 소문자로 변환 : LOWER(), 첫글자만 대문자로 변환 : INITCAP()
SELECT UPPER('heLLo'), LOWER('heLLo'), INITCAP('heLLo')
FROM dual;

--특정문자의 위치반환 : INSTR()
SELECT INSTR('hellojava', 'a')--7
      ,INSTR('hellojava', 'a', 8)--9 8번부터찾아라
      ,INSTR('hellojava', 'b')--0
      ,INSTR('hellojava', 'a', -1)--9
      ,INSTR('hellojava', 'a', -1, 2)--7
FROM dual;

--부분문자열 반환 : SUBSTR()
SELECT SUBSTR('hellojava', 2, 6)
      ,SUBSTR('hellojava', 2)
      ,SUBSTR('hellojava', -1)
      ,SUBSTR('hellojava', -5, 5)
FROM dual;

--문자열 제거 : TRIM()
SELECT TRIM( LEADING 'a' FROM 'aABCaDEFaHa') --왼쪽 문자 'a' 제거
      ,TRIM( TRAILING 'a' FROM 'aABCaDEFaHa') --오른쪽 문자 'a' 제거
      ,TRIM( BOTH 'a' FROM 'aABCaDEFaHa') --양쪽 문자 'a' 제거
      ,TRIM( BOTH 'a' FROM 'aaaABCaDEFaHaaaa')
      ,TRIM( 'a' FROM 'aaABCaDEFaHaa')
FROM dual;

--문자열 늘리기 : LPAD(), RPAD()
SELECT LPAD('abc', 5, '*')
      ,LPAD('abc', 5)
      ,LPAD('abc', 2, '*')
      ,RPAD('abc', 5, '*')
      ,RPAD('abc', 5)
      ,RPAD('abc', 3, '*')
      ,RPAD(LPAD('abc', 5, '*'), 7, '*')
FROM dual;

--문자열 치환함수 : REPLACE(), TRANSLATE()
SELECT REPLACE('JACK and JUE', 'J', 'BL') --J를 BL로 변환
      ,REPLACE('JACK and JUE', 'J', '') --J를 공백으로 변환
      ,TRANSLATE('JACK and JUE', 'J', 'BL') --J를 B로 변환
      ,REPLACE('BCCARD', 'BC', 'KB')
      ,TRANSLATE('BCCARD', 'BC', 'KB') -- B를 K로 C를 B로
FROM dual;

--숫자형함수
--나머지값 반환 : MOD()
SELECT 3 + 4, 3 - 4, 3 * 4, 3 / 4, MOD(3, 4)
FROM dual;

--반올림 된 값 반환 : ROUND()
--버림된 값 반환 : TRUNC()
SELECT ROUND(45.923) --46
      ,ROUND(45.923, 0) --46 : 일의 자릿수까지 표현
      ,ROUND(45.923, 1) --45.9 : 소수점이하 1자리까지 표현
      ,ROUND(45.923, 2) --45.92 : 소수점이하 2자리까지 표현
      ,ROUND(45.923, 3) --45.923 : 소수점이하 3자리까지 표현
      ,ROUND(45.923, 4) --45.923 : 소수점이하 4자리까지 표현
      ,ROUND(45.923, -1) --50 : 십의 자릿수까지 표현
      ,ROUND(45.923, -2) --0
FROM dual;

SELECT TRUNC(45.923) --45
      ,TRUNC(45.923, 0) --45 : 일의 자릿수까지 표현
      ,TRUNC(45.923, 1) --45.9 : 소수점이하 1자리까지 표현
      ,TRUNC(45.923, 2) --45.92 : 소수점이하 2자리까지 표현
      ,TRUNC(45.923, 3) --45.923 : 소수점이하 3자리까지 표현
      ,TRUNC(45.923, 4) --45.923 : 소수점이하 4자리까지 표현
      ,TRUNC(45.923, -1) --40 : 십의 자릿수까지 표현
      ,TRUNC(45.923, -2) --0
FROM dual;

--이름에 대소문자구분없이 e를 포함한 사원들의 사번, 이름을 출력하시오. (OR 연산자 사용안함)
SELECT employee_id, first_name
FROM employees
WHERE INSTR(LOWER(first_name), 'e') <> 0;

SELECT employee_id, first_name
FROM employees
WHERE LOWER(first_name) LIKE '%e%';

--실급여(급여+(급여*수당률))가 10000보다 많은 실급여를 받는 사원들의 사번, 급여, 수당률, 실급여를 출력하시오
--단 실급여는 일의자리에서 반올림하고 실급여를 많이 받는 사람들부터 출력한다.
SELECT employee_id, salary,commission_pct, ROUND(salary + NVL(commission_pct, 0) * salary, -1) 실급여
FROM employees
WHERE ROUND(salary + NVL(commission_pct, 0) * salary, -1) > 10000
ORDER BY 실급여 DESC;

----------------------------------------------------
--날짜형함수
--현재시간값 반환 : SYSDATE
SELECT SYSDATE
FROM dual;

--날짜 + 숫자 는 날짜를 반환
--SYSDATE + 1 내일날짜를 반환
--SYSDATE + 2 모래날짜를 반환
SELECT SYSDATE + 1, SYSDATE + 2
FROM dual;

--날짜 - 숫자 는 날짜를 반환
--SYSDATE - 1 어제날짜를 반환
--SYSDATE - 2 그제날짜를 반환
SELECT SYSDATE - 1, SYSDATE - 2
FROM dual;

--날짜 - 날짜 는 일수를 반환
SELECT (SYSDATE + 3) - SYSDATE, SYSDATE - 2
FROM dual;

--개월을 더한다 : ADD MONTHS()
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 5), ADD_MONTHS(SYSDATE, -1)
FROM dual;

--개월수를 반환한다 : MONTHS_BETWEEN
SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE, 5))
      ,MONTHS_BETWEEN('22/03/04', SYSDATE)
      ,MONTHS_BETWEEN('220304', SYSDATE) -- 비권장
FROM dual;

--3. 사원의 근무일수, 근무 개월수, 근무년수를 출력하시오
--근무일수란 현재일자부터 입사일까지의 일수
--근무개월수는 소숫점 이하자리는 버린다
--근무년수는 소숫점이하 2자리에서 반올림한다.
SELECT employee_id, hire_date 
      ,(SYSDATE - hire_date) 근무일수
      ,TRUNC(MONTHS_BETWEEN(SYSDATE,hire_date)) 근무개월수
      ,ROUND((SYSDATE - hire_date) / 365, 1) 근무년수
FROM employees
ORDER BY 근무일수 DESC;

--일자기준으로 다음 요일에 해당 날짜를 반환한다 : NEXT_DAT()
--현재일자기준으로 다음 토요일에 해당하는 날짜를 출력하시오
SELECT SYSDATE, NEXT_DAY(SYSDATE, '토') FROM dual;

--22/01/01기준으로 돌아올 다음 월요일
SELECT NEXT_DAY('22/01/01', '월') FROM dual;


--형변환함수
--문자형 --> 숫자형 : TO_NUMBER()
--문자형 --> 날짜형 : TO_DATE()

--숫자형 --> 문자형 : TO_CHAR()
--날짜형 --> 날짜형 : TO_CHAR()
--숫자와 날짜는 서로 형변환 불가
--숫자 -> 문자 -> 날짜는 가능

--자동형변환
SELECT '1' || 2 FROM dual; -- '12' (문자형) 숫자형 2가 문자형으로 자동형변환됨
SELECT '1' + 2 FROM dual; -- 3 (숫자형) 문자형 '1'이 숫자형으로 자동형변환됨
SELECT '21/12/25', MONTHS_BETWEEN('21/12/25', SYSDATE) FROM dual; --'21/12/25' 문자형이 날짜형으로 자동 형변환
SELECT employee_id, hire_date
FROM employees
WHERE hire_date >= '08/01/01'; --날짜형 >= 문자형 -> 문자형이 날짜형으로 자동형변환됨
SELECT '입사일자 - ' || hire_date FROM employees; --날자형이 문자형으로 자동형변환됨 파이프 기호는 문자형 우선 

--강제형변환
SELECT '1' || TO_CHAR(2) FROM dual; -- '12' (문자형) 숫자형 2가 문자형으로 강제형변환됨
SELECT TO_NUMBER('1') + 2 FROM dual; -- 3 (숫자형) 문자형 '1'이 숫자형으로 강제형변환됨
SELECT '21/12/25', MONTHS_BETWEEN(TO_DATE('21/12/25'), SYSDATE) FROM dual; --'21/12/25' 문자형이 날짜형으로 강제형변환
SELECT employee_id, hire_date
FROM employees
WHERE hire_date >= TO_DATE('08/01/01'); --날짜형 >= 문자형 -> 문자형이 날짜형으로 강제형변환됨
SELECT '입사일자 - ' || TO_CHAR(hire_date) FROM employees; --날자형이 문자형으로 자동형변환됨 파이프 기호는 문자형 우선 

--TO_CHAR() : 숫자 -> 문자 TO_CHAR() 형식 - 9 0 , . L
SELECT 24000, TO_CHAR(24000, '9,999,999'), TO_CHAR(24000, '9,999')
            , TO_CHAR(24000, '0000000.00'), TO_CHAR(24000, 'L9,999,999')
FROM dual;

--사원의 사번, 급여를 출력하시오
SELECT employee_id, TO_CHAR(salary,'9,999,999')
FROM employees;

--날짜 -> 문자 : TO_CHAR() 형식 - Y M D HH MI SS
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYYMMDD HH:MI:SS'), TO_CHAR(SYSDATE, 'YYYYMMDD HH24:MI:SS')
              , TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS DAY')
FROM dual;

--문자 -> 숫자 : TO_NUMBER()
SELECT 12345, '1,234.5', TO_NUMBER('1,234.5', '9,999.0') + 1
FROM dual;

--문자 -> 날짜 : TO_DATE()
--날짜 타입은 그냥 셀렉트를 하면 년월일까지만 보이지만 정보는 시분초를 포함하고 있다.
SELECT TO_DATE('21/02/28') + 1, TO_CHAR(TO_DATE('21/10/06 오전 09:28', 'YY-MM-DD am HH:MI'), 'YY-MM-DD am HH:MI'), SYSDATE - TO_DATE('21/10/06 오전 09:28', 'YY-MM-DD am HH:MI')
FROM dual;

--날짜형 주의점 : 시분초정보 포함
SELECT TO_CHAR(hire_date, 'YY/MM/DD HH24:MI:SS')
FROM employees
WHERE hire_date > '08/07/01'; --2008년 7월 1일 보다 큰 날짜 7월2일부터? (X)
                              --2008년 7월 1일 0시 0분 0초보다 큰 시간 (O)
                            
SELECT TO_CHAR(hire_date, 'YY/MM/DD HH24:MI:SS')
FROM employees
WHERE TO_DATE(hire_date, 'yy/mm/dd') > TO_DATE('08/07/01', 'yy/mm/dd');--2008년 7월 1일 보다 큰 날짜 7월 2일부터(O)



--NULL관련함수
--NVL()
--NVL2( , , ) 첫 번째인자가 NULL이면 두번째인자 두 번째 인자가 NULL이면 세 번째 인자를 취한다. 
--관리자(manager_id)가 없는 사원을 출력하시오
SELECT *
FROM employees
WHERE manager_id IS NULL;

--관리자 없는 사원은 관리자 번호를 0으로 출력하고, 관리자가 있는 사원은 관리자번호를 그대로 출력하시오
SELECT employee_id, first_name, NVL(manager_id, 0)
FROM employees;

--관리자 없는 사원은 '관리자없음'으로 출력하고, 관리자가 있는 사원은 관리자번호를 그대로 출력하시오
--NVL2는 반환 형이 같아야한다. 숫자 숫자 혹은 문자 문자로 일치시켜야 한다.
SELECT employee_id, first_name, NVL(TO_CHAR(manager_id), '관리자없음')
FROM employees;

SELECT employee_id, first_name, NVL2(manager_id, TO_CHAR(manager_id), '관리자없음')
FROM employees;
--관리자 없는 사원은 '관리자없음'으로 출력하고, 관리자가 있는 사원은 '관리자있음'으로 출력하시오
SELECT employee_id, first_name, NVL2(manager_id, '관리자있음', '관리자없음')
FROM employees;

--NULLIF : 인자 1값과 인자2값이 같으면 NULL반환, 다르면 인자1값을 반환
SELECT employee_id, NULLIF(salary, 24000)
FROM employees;
-------------------------------------------------------------------
--SQL은 변수선언, 조건문처리 반복문처리 못함
--조건함수 : DECODE()
--관리자없는 사원은 '관리자없음'으로 출력하고, 관리자 있는 사원은 '관리자있음'으로 출력하시오
--decode 첫번째 인자가 두번째 인자라면 세번째인자를 반환하고 아니면 네번째인자를 반환하라
SELECT employee_id, DECODE(manager_id, null, '관리자없음', '관리자있음')
FROM employees;

--부서번호가 80이면 '영업부', 
SELECT employee_id, DECODE(department_id, 80, '영업부', 60, 'IT부', '그외의 부서')
FROM employees;

--조건절 : CASE
--CASE : WHEN THEN
--       WHEN THEN
--       ELSE
--END
SELECT employee_id, CASE WHEN manager_id IS NULL THEN '관리자없음'
                                         ELSE '관리자있음'
                    END
FROM employees;

SELECT employee_id, CASE department_id WHEN 80 THEN '영업부'
                                       WHEN 60 THEN 'IT부' 
                                       ELSE '그외의 부서'
                    END
FROM employees;

--사원의 사번, 급여, 급여등급을 출력하시오
--등급은 급여가 10000이상인 경우 'A', 5000이상이면 'B', 5000미만이면 'C'등급이다.
SELECT employee_id, salary, CASE WHEN salary >= 10000 THEN 'A'
                                 WHEN salary >= 5000 THEN 'B'
                                 ELSE 'C'
                            END 급여등급
FROM employees;
--decode는 오라클 전용함수이고
--CASE는 표준화된 문법이기 때문에 다른 곳에서도 사용이 가능합니다.