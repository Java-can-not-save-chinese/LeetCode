# SwapSalary.cpp
# Author: hyan23
# 2020.06.07
# https://leetcode.com/problems/swap-salary/

# Runtime: 450 ms, faster than 27.21% of MySQL online submissions for Swap Salary.
# Memory Usage: 0B, less than 100.00% of MySQL online submissions for Swap Salary.

# Write your MySQL query statement below

update salary set sex=(case when sex='m' then 'f' else 'm' end)