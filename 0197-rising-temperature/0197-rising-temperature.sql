# Write your MySQL query statement below
Select t.id as Id from 
Weather as t
join Weather as t1
ON DATEDIFF(t.recordDate, t1.recordDate) = 1
WHERE t.temperature > t1.temperature;