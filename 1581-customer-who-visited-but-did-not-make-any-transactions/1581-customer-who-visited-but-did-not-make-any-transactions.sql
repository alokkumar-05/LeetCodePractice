# Write your MySQL query statement below
Select v.customer_id  , count(v.customer_id) as count_no_trans 
from Visits as v
left Join Transactions as t
on v.visit_id = t.visit_id
where t.visit_id is null
group by v.customer_id;