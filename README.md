# Java DSA Practice

A collection of Java practice examples for data structures and algorithms, with a few concurrency exercises. This is a learning repository; examples are intended for exploration and improvement.

## Topics

- Arrays and hash tables
- Linked lists and an LRU cache
- Stacks and heaps
- Trees and graphs
- Binary search and sliding windows
- Recursion and dynamic programming
- Matrices and concurrency basics

## Requirements

- JDK 26 (the version used to verify compilation)
- No external dependencies or build tool required

## Compile and run

From the project root, run these commands in a macOS or Linux terminal:

```sh
mkdir -p out
find src -name '*.java' > out/sources.txt
javac -d out @out/sources.txt
java -cp out search.BinarySearch
```

To run another example, replace `search.BinarySearch` with the package and class name of a class containing a `main` method, such as `linkedlist.LRUCache`.

You can also open the project in IntelliJ IDEA, select JDK 26, and run individual examples from the editor.

## Project layout

- `src/`: Java examples grouped by topic, plus a few standalone exercises.
- `out/`: generated class files, excluded from Git.

## Notes

Many examples include sample inputs in their `main` methods. There is no automated test suite yet, and compiling successfully does not verify every algorithm or edge case. Some examples include time and space complexity notes.
