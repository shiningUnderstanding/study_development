--����
--����� ���, ������ȣ�� ����Ͻÿ�
SELECT employee_id, job_id
FROM employees;

--�������(job_history)�� ���, ����������ȣ�� ����Ͻÿ�
SELECT employee_id, job_id, start_date, end_date
FROM job_history;

--101�� ����� ���������� ���������� ��� ����Ͻÿ� --3��
--UNION�� ����� �� SELECT���� �÷��� ������ �� �÷��� �ڷ����� ��ġ�ؾ� �Ѵ�.
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

--176�� ����� ���������� ���������� ��� ����Ͻÿ� --2��
--��, �ߺ������� �����մϴ�.
SELECT employee_id, job_id
FROM job_history
WHERE employee_id = 176
UNION
SELECT employee_id, job_id
FROM employees
WHERE employee_id = 176;

--176�� ����� ���������� ���������� ��� ����Ͻÿ� --3��
--UNION ALL�� �ߺ��� ����մϴ�.
SELECT employee_id, job_id
FROM job_history
WHERE employee_id = 176
UNION ALL
SELECT employee_id, job_id
FROM employees
WHERE employee_id = 176;
---------------------------------------------------
--������
SELECT employee_id, job_id
FROM job_history
INTERSECT
SELECT employee_id, job_id
FROM employees;

--������
SELECT employee_id, job_id
FROM job_history
MINUS
SELECT employee_id, job_id
FROM employees;

--���տ����ڿ��� ORDER BY�� �� �������� ���;� �Ѵ�.
SELECT employee_id, job_id
FROM job_history
UNION
SELECT employee_id, job_id
FROM employees
ORDER BY employee_id DESC;

-----------------------------------------------------
