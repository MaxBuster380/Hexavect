# Hexavect

- I - Introduction
- II - Download
- III - Tutorial
- IV - About

### I - Introduction

This project aims to help manage a hexagonal plane, with keeping track of coordinates and applying operations on them. 

### II - Download

__Gradle__

In `build.gradle` :

```gradle
allprojects {
	repositories {
		/*...*/
		maven { url 'https://jitpack.io' }
	}
}
```

```gradle
dependencies {
    implementation 'com.github.MaxBuster380:Hexavect:release-1.2.0'
}
```

__Maven__

In `pom.xml` :
```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```

```xml
<dependency>
    <groupId>com.github.MaxBuster380</groupId>
    <artifactId>Hexavect</artifactId>
    <version>release-1.2.0</version>
</dependency>
```

### III - Tutorial

In this library, you'll find a single class : **HexagonVector**, 
a data class which can both represent position and movement on the plane.
HexagonVector acts like a **value** rather than an object, 
meaning an instance never changes.
Note that a hexagon is **not subdividable**, 
unlike a square or triangle, so all operations are done with integers.

It provides 7 class constants to do operations with :
 - **ORIGIN**, center of the plane.
 - **HOR_RIGHT**, unit vector for moving one tile to the right.
 - **HOR_LEFT**, unit vector for moving one tile to the left.
 - **TOP_RIGHT**, unit vector for moving one tile to the top-right.
 - **TOP_LEFT**, unit vector for moving one tile to the top-left.
 - **BOT_RIGHT**, unit vector for moving one tile to the bottom-right.
 - **BOT_LEFT**, unit vector for moving one tile to the bottom-left.

![Image didn't load (click to see)](https://raw.githubusercontent.com/MaxBuster380/Hexavect/main/README_images/unitVectors.svg)

A HexagonVector is made up of two components (a, b).
```Kotlin
val myHexagon = HexagonVector(10, 8)

println(myHexagon.a) // 10
println(myHexagon.b) // 8
```

The empty constructor creates ORIGIN.
```Kotlin
val a = HexagonVector()

println(a == ORIGIN) // true
```

You can also create an instance through operations, which are done through the standard operators (+ - * /).

```Kotlin
val diagonalTopRight : HexagonVector = HexagonVector.HOR_RIGHT + HexagonVector.TOP_RIGHT

val diagonalTopRight3Away : HexagonVector = diagonalTopRight * 3
```

Use the `distance` method to measure the distance between two hexagons.
```Kotlin
val a : HexagonVector = HexagonVector.HOR_LEFT * 4
val b : HexagonVector = HexagonVector.HOR_RIGHT * 5

val distance : Long = a.distance(b)

println(distance) // 9
```

You can translate standard (x, y) coordinates to and from the hexagonal plane. 
```Kotlin
val HEXAGON_RADIUS = 64.0
val mouseX : Int
val mouseY : Int

val selectedTile : HexagonVector = HexagonVector.fromCartesian(mouseX, mouseY, HEXAGON_RADIUS)
val centerSelectedTile : Pair<Double, Double> = selectedTile.toCartesian(HEXAGON_RADIUS)
```

### IV - About

By MaxBuster380

[GitHub Repository](https://github.com/MaxBuster380/Hexavect)