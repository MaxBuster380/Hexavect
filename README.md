# Hexavect

- I - Introduction
- II - Tutorial
- III - About

### I - Introduction

This project aims to help manage a hexagonal plane, with keeping track of coordinates and applying operations on them. 

### II - Tutorial

In this library, you'll find a single class : **HexagonVector**, which can both represent position and movement on the plane.
HexagonVector acts like a **value** rather than an object, meaning an instance never changes.
Note that a hexagon is **not subdividable**, like a square or triangle could, so all operations are done with integers.

It provides 7 class constants to do operations with :
 - **ORIGIN**, center of the plane.
 - **HOR_RIGHT**, unit vector for moving one tile to the right.
 - **HOR_LEFT**, unit vector for moving one tile to the left.
 - **ASC_RIGHT**, unit vector for moving one tile to the top-right.
 - **ASC_LEFT**, unit vector for moving one tile to the top-left.
 - **DESC_RIGHT**, unit vector for moving one tile to the bottom-right.
 - **DESC_LEFT**, unit vector for moving one tile to the bottom-left.

Instanciating a HexagonVector is the same as getting ORIGIN.
```Kotlin
val a = HexagonVector()

println(a == ORIGIN) // true
```

Operations are done through the standard operators (+-*/).

```Kotlin
val diagonalTopRight = HOR_RIGHT + ASC_RIGHT

val diagonalTopRight3Away = diagonalTopRight * 3
```

There is also a `distance` method for measuring the distance between two coordinates.
```Kotlin
val a = HOR_LEFT * 4
val b = HOR_RIGHT * 5

println(a.distance(b)) // 9
```

### III - About

By MaxBuster380

[Github Repository](https://github.com/MaxBuster380/Hexavect)