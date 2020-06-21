# NotBoringMovies.cpp
# Author: hyan23
# 2020.06.07
# https://leetcode.com/problems/not-boring-movies/

# Runtime: 258 ms, faster than 56.61% of MySQL online submissions for Not Boring Movies.
# Memory Usage: 0B, less than 100.00% of MySQL online submissions for Not Boring Movies.

# Write your MySQL query statement below

select * from cinema where id % 2 = 1 and description != 'boring' order by rating desc
