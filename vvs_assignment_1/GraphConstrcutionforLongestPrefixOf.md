# LongestPrefixOf - Graph Construction

## Edges
0 1
0 2
2 3
2 4
4 5
5 6
5 7
7 8 
7 9
8 5
9 10
9 11
10 5
11 12
11 13
12 13
13 5

## Initial nodes
0

## Final nodes
1 3 6

## defs
query 0
length 4 12
c 7
x 4 8 13
i 4 11
root 0

## uses
query 0,1 0,2 2,3 2,4 5,6 5,7 6 7 
length 6
c 7,8 7,9 9,10 9,11
x 5,6 5,7 7,8 7,9 8 9,10 9,11 10 11,12 11,13 13
i 5,6 5,7 7 11 12
root 4  

## Edge-Pairs
1. [0,1]
2. [0,2,3]
3. [0,2,4]
4. [2,4,5]
5. [4,5,6]
6. [4,5,7]
7. [5,7,8]
8. [5,7,9]
9. [7,8,5]
10. [7,9,10]
11. [7,9,11]
12. [8,5,6]
13. [8,5,7]
14. [9,10,5]
15. [9,11,12]
16. [9,11,13]
17. [10,5,6]
18. [10,5,7]
19. [11,12,13]
20. [11,13,5]
21. [12,13,5]
22. [13,5,6]
23. [13,5,7]

## Prime Paths
1. [0,2,4,5,7,9,11,12,13]
2. [0,2,4,5,7,9,11,13]
3. [5,7,9,11,12,13,5]
4. [7,9,11,12,13,5,6]
5. [7,9,11,12,13,5,7]
6. [0,2,4,5,7,9,10]
7. [8,5,7,9,11,12,13]
8. [11,12,13,5,7,9,11]
9. [12,13,5,7,9,11,12]
10. [13,5,7,9,11,12,13]
11. [11,12,13,5,7,9,10]
12. [9,11,12,13,5,7,8]
13. [9,11,12,13,5,7,9]
14. [10,5,7,9,11,12,13]
15. [7,9,11,13,5,6]
16. [5,7,9,11,13,5]
17. [7,9,11,13,5,7]
18. [8,5,7,9,11,13]
19. [0,2,4,5,7,8]
20. [11,13,5,7,9,11]
21. [11,13,5,7,9,10]
22. [13,5,7,9,11,13]
23. [9,11,13,5,7,9]
24. [9,11,13,5,7,8]
25. [10,5,7,9,11,13]
26. [7,9,10,5,7]
27. [7,9,10,5,6]
28. [8,5,7,9,10]
29. [0,2,4,5,6]
30. [5,7,9,10,5]
31. [9,10,5,7,8]
32. [9,10,5,7,9]
33. [10,5,7,9,10]
34. [7,8,5,7]
35. [7,8,5,6]
36. [8,5,7,8]
37. [5,7,8,5]
38. [0,2,3]
39. [0,1]

## Du Paths
1. Query[0,2,3]
2. Query[0,1]
3. Query[0,2,4,5,6]
4. Query[0,2,4,5,7,8,5,6]
5. Length[0,2,4,5,6]
6. Length[0,2,4,5,7,9,11,12,13,5,6]
7. C[0,2,4,5,7,9,10,5,6]
8. C[0,2,4,5,7,8,5,6]
9. C[0,2,4,5,7,9,11,13,5,6]
10. X[0,2,4,5,7,8,5,6]
11. X[0,2,4,5,6]
12. X[0,2,4,5,7,9,10,5,6]
13. X[0,2,4,5,7,9,11,13,5,6]
14. X[0,2,4,5,7,9,11,12,13,5,6]
15. X[0,2,4,5,7,8,5,7,8,5,6]
16. X[0,2,4,5,7,8,5,6]
17. X[0,2,4,5,7,8,5,7,9,10,5,6]
18. X[0,2,4,5,7,8,5,7,9,11,13,5,6]
19. X[0,2,4,5,7,8,5,7,9,11,12,13,5,6]
20. X[0,2,4,5,7,9,11,13,5,7,8,5,6]
21. X[0,2,4,5,7,9,11,13,5,6]
22. X[0,2,4,5,7,9,11,13,5,7,9,10,5,6]
23. X[0,2,4,5,7,9,11,13,5,7,9,11,13,5,6]
24. X[0,2,4,5,7,9,11,13,5,7,9,11,12,13,5,6]
25. I[0,2,4,5,7,8,5,6]
26. I[0,2,4,5,6]
27. I[0,2,4,5,7,9,11,13,5,6]
28. I[0,2,4,5,7,9,11,12,13,5,6]
29. I[0,2,4,5,7,9,11,13,5,7,8,5,6]
30. I[0,2,4,5,7,9,11,13,5,7,9,11,13,5,6]
31. Root[0,2,4,5,6]
