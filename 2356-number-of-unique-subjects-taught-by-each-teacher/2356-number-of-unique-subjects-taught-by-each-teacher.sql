# Write your MySQL query statement below
select teacher_id,
       COUNT(DISTINCT subject_id) AS cnt
from teacher
group by teacher_id