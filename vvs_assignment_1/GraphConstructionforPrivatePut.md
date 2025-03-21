# Private Put - Graph Construction

## Edges
0 1
1 2
1 3
2 3
3 4
3 5
5 6
4 7
4 8
7 6
8 9
8 10
9 6
10 6

## Initial nodes
0

## Final nodes
6

## defs
x 0 3
key 0
val 0
d 0
c 1
xc 2
xl 5
xr 7
xm 9
xv 10

## uses
x 1,2 1,3 6
key 1 5 7 8,9 8,10 9
val 5 7 9 10
d 1 8,9 8,10 9
c 2 3,4 3,5 4,7 4,8
xc 3,4 3,5 4,7 4,8
xl 5
xr 7
xm 9

