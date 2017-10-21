# Coursera algorithms part 1

## Excercises while doing the course
* https://www.coursera.org/learn/algorithms-part1
* https://algs4.cs.princeton.edu
* https://algs4.cs.princeton.edu/code

## Run in command line
```shell
java -cp ./algs4.jar:./bin UnionFindQuick < input.txt
```
## Example output with my own style of logging
```
               initializing id, N operaton
                0 1 2 3 4 5 6 7 8 9
               > 1 2
               union, lookup N times
connect 1 2
                0 2 2 3 4 5 6 7 8 9
               > 3 4
               union, lookup N times
connect 3 4
                0 2 2 4 4 5 6 7 8 9
               > 5 6
               union, lookup N times
connect 5 6
                0 2 2 4 4 6 6 7 8 9
               > 7 8
               union, lookup N times
connect 7 8
                0 2 2 4 4 6 6 8 8 9
               > 7 9
               union, lookup N times
connect 7 9
                0 2 2 4 4 6 6 9 9 9
               > 2 8
               union, lookup N times
connect 2 8
                0 9 9 4 4 6 6 9 9 9
               > 0 5
               union, lookup N times
connect 0 5
                6 9 9 4 4 6 6 9 9 9
               > 1 9
               1 9 are already connected
                6 9 9 4 4 6 6 9 9 9
```
