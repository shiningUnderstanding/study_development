--ó������ 
-- FROM -> WHERE -> GROUP BY - HAVING - SELECT - ORDER BY

SELECT * FROM employees;

SELECT employee_id, first_name, salary, hire_date
FROM employees;

--�ּ��� ������ �ΰ�~

--�÷� ��Ī�ֱ� : heading�� ��Ī���� ��Ÿ��
--ū ����ǥ�� �� ��Ī �� ���� ����
SELECT employee_id ���, first_name "��� �̸�", salary, hire_date "hiredate"
FROM employees;

--���ڿ���ȣ ''
--���ڿ����տ����� ||
SELECT employee_id, first_name, last_name, first_name || last_name, first_name || ' ' || last_name "��� ����"
FROM employees;

-------------------------------------------------------------------
--�ڷ��� 
--������ CHAR, VARCHAR2 (VARCHAR2 �� �������̹��ڿ��̶� ���̰� ª���� ��������Ʈ�� ���� ���������� CHAR�� �������̶� ��� ���� ����Ʈũ��� �����Ѵ�)
--������ NUMBER
--��¥�� DATE, TIMESTAMP


--������
--��������� : +, - *, /
--�񱳿����� : >, <, >= , <=, =, <>(���� �ʴ�), !=(������� ������������ ��� �����ϳ� �ƿ����� ����� �ȵǾ ���谡 ���� �ʴ��� ǥ���̴�)
--���Կ����� : ����
--�������� : AND, OR, NOT
--����������, ���׿����� ����
--��ȣ������ : () �켱������ ������
--BETWEEN������ : <= AND >= �� ���� ǥ��
--IN������ : 

--------------------------------------------------------------------
--Ư�� �� ���� : WHERE
--�޿��� 5000�̻��� ������� ���, �̸�, �޿��� ����Ͻÿ�
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary >= 5000;

--�޿��� 12�� ���� ���� 100000�̻��� ������� ���, �̸�, �޿��� ����Ͻÿ�
SELECT employee_id, first_name, last_name, salary, salary*12
FROm employees
WHERE salary * 12 >= 100000;


--�޿��� 5000�̻� 10000������ ������� ���, �̸�, �޿��� ����Ͻÿ�
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary >= 5000 AND salary <= 10000;

SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary BETWEEN 5000 AND 10000;

--������� ���, �μ���ȣ�� ����Ͻÿ�
SELECT employee_id, department_id
FROM employees;

--�μ���ȣ�� 90�̰ų�, 30�̰ų�, 20�� ������� ���, �μ���ȣ
SELECT employee_id, department_id
FROM employees
WHERE department_id = 90 or department_id = 30 or department_id = 20;

SELECT employee_id, department_id
FROM employees
WHERE department_id IN (20, 30, 90);


--�μ���ȣ�� 90�̰ų�, 30�̰ų�, 20�̰�
--�޿��� 5000�̻� 10000������ ������� ���, �̸�, �޿��� ����Ͻÿ�
--AND������ ���� ����ȴ�
SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE (department_id = 90 OR department_id = 30 OR department_id = 20) 
    AND (salary >= 5000 AND salary <= 10000);

SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE department_id IN (20, 30, 90) AND salary BETWEEN 5000 AND 10000;

--�μ���ȣ�� 90�� �ƴϰ� 30�� �ƴϰ� 20�� �ƴ� �μ��� ���, �̸�, �μ���ȣ�� ����Ͻÿ�
SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE department_id <> 90 AND department_id <> 30 AND department_id <> 20;

SELECT employee_id, first_name, salary, department_id
FROM employees
WHERE department_id NOT IN (90, 30, 20);

--�������̺�
SELECT * FROM jobs;

--Manager�� ������ �������� ����Ͻÿ�
SELECT job_title
FROM jobs
WHERE job_title LIKE '%Manager';

--����� �̸��� 'e'�� �� ���
SELECT employee_id, first_name
FROM employees
WHERE first_name LIKE '%e%';

--����� �Ի����ڸ� ����Ͻÿ�
SELECT hire_date FROM employees;

--�Ի�⵵�� 07�⵵�� ����� ���, �Ի����ڸ� ����Ͻÿ�
--�ڷᰡ ���ų� �÷����� ���쿡�� LIKE�����ڴ� ������� �ʴ´�
SELECT employee_id, hire_date
FROM employees
WHERE hire_date LIKE '07%'
ORDER BY hire_date asc;

SELECT employee_id, hire_date
FROM employees
WHERE hire_date BETWEEN '07/01/01' AND '07/12/31';


--�Ի���� 11���� ����� ���, �Ի����ڸ� ����Ͻÿ�
SELECT employee_id, hire_date
FROM employees
WHERE hire_date LIKE '__/11/__';
-------------------------------------------
-- ORDER BY : ����, �������� ��������


--���� �޿��� �޴� ������� ���, �̸�, �޿��� ����Ͻÿ�
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary;

--���� �޿��� �޴� ������� ���, �̸�, �޿��� ����Ͻÿ�
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary desc;

--���� �޿��� �޴� ������� ���, �̸�, �޿��� ����Ͻÿ� �޿��� ���� ��� �̸��� ���������� ����Ͻÿ�
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC , first_name ASC;

SELECT employee_id ���, first_name �̸�, salary �޿�
FROM employees
ORDER BY �޿� DESC , �̸� ASC;--��Ī��� ����

SELECT employee_id, first_name, salary
FROM employees
ORDER BY 3 DESC , 2 ASC;

--���� �޿��� �޴� ������� ���, �̸��� ����Ͻÿ�
SELECT employee_id, first_name
FROM employees
ORDER BY salary DESC;

--DISTINCT : �ߺ�����
--����� �μ���ȣ�� ����Ͻÿ�
SELECT department_id
FROM employees;

--����� ���� �μ���ȣ�� �ߺ����� ���
SELECT DISTINCT department_id
FROM employees;

--����� ���� �μ���ȣ, ������ȣ
SELECT department_id, job_id
FROM employees
ORDER BY department_id, job_id;

--����� ���� �μ���ȣ, ������ȣ�� �ߺ� ���� ���
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

--NULL : �ƹ����� �ƴϴ�
SELECT employee_id, first_name, last_name, department_id, salary, commission_pct
FROM employees;

--�μ���ġ ���� �ʴ� ����� ���, �̸�, �μ���ȣ�� ����Ͻÿ�
--null���� �� �����ڷ� �� �Ұ� ���� �ƴϱ� ������
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id = null;--null�� �ϸ� �ȉ�

--is null�� �̿��ؼ� null������ �Ǵ� �� �� �ִ�.
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id IS NULL;

--�μ���ġ�� ���� ����� ���, �̸�, �μ���ȣ�� ����Ͻÿ�
SELECT employee_id, first_name, department_id
FROM employees
WHERE department_id IS NOT NULL;

--��� ����� ���, �̸�, �޿�, �����, �޿� * ����� + �޿� �� ����Ͻÿ�
--������꿡 null�� �����ϸ� ����� ������ null
SELECT employee_id, first_name, salary, commission_pct, (salary * commission_pct) + salary �Ǳ޿�
FROM employees;

--NULL���� �Լ� : NVL(ǥ����, ��ȯ��) ǥ������ NULL�̸� ��ȯ���� ��ȯ�ϰ�, ǥ������ null�� �ƴϸ� ǥ���İ��� ��ȯ�Ѵ�.
SELECT employee_id, first_name, salary, commission_pct, (salary * NVL(commission_pct, 0)) + salary �Ǳ޿�
FROM employees;

--���� �μ���ȣ�� ���� ������� ����Ͻÿ�
--����Ŭ�� ������������ null���� �ǵڿ� �ְ� my-sql���� �տ� ���´�.
SELECT employee_id, department_id
FROM employees
ORDER BY department_id; --���������ϸ� null�� ���� �������� ��µ�, DBMS���� �ٸ�

--------------------------------------------------------
--ROWNUM : ���ȣ���� ���� �ǻ��÷�
SELECT rownum, employee_id FROM employees;
--������� : FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY
SELECT rownum, employee_id, salary FROM employees ORDER BY salary DESC;

--�޿��� ���� �޴� ��������� 5�� ����Ͻÿ�
SELECT rownum, employee_id, salary
FROM employees
WHERE rownum <= 5
ORDER BY SALARY DESC;

SELECT rownum, employee_id, salary
FROM employees
WHERE rownum <= 10
ORDER BY SALARY DESC;
--���� ����� �̱����ؼ� ���������� ����ؾ��Ѵ�.

