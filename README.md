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

* 9
```
given 2H 2D 2S 9C KD
when call isHasThreeSamePoker
then output true
```

* 10
```
given 2H 2D 2S 2C KD
when call isHasFourSamePoker
then output true
```
* 11
```
given 2H 4D 3S 5C 6D
when call isSequence
then output true
```

* 12
```
given 2H 7H 3H 5H 6H
when call isSequence
then output true
```


