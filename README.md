* 1
```
given 3H | 4D
when compare two pokers
than output negative number
```

* 2

```
given 2H 3D KD 9C 4H
when call findMaxPoker
then output max poker KD
```

* 3

```
given 2H 3D 5S 9C KD  | 2c 3H 4S 8C AH
when call compareMaxPoker
then output 2
```

* 4

```
given 2H 3D 5S JC KD | 2c 3H 4S JH KH
when call compareMaxPoker
then output 1
```

* 5

```
given 2H 3D 5S JC KD | 2c 3H 4S JH KH
when call play
then output 1
```


* 6

```
given 2H 2D 5S 9C KD | 2c 3H 4S 8C AH
when call play
then output 1
```

* 7

```
given 2H 2D 5S 9C KD | 3c 3H 4S 8C AH
when call compareBothHasPair
then output 2
```

* 8

```
given 2H 2D 5S 9C KD | 3c 3H 4S 8C AH
when call play
then output 2
```





