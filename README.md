[![Build Status](https://travis-ci.org/mpaauw/data-structures-java.svg?branch=master)](https://travis-ci.org/mpaauw/data-structures-java)

# data-structures-java
A collection of common data structures and algorithms written in Java.

## Synopsis
This repository includes common data structures written in Java. Current build is embedded within a Maven project in order to accommodate automated build delivery via CI every time a commit is pushed to the master branch.

---

## Implementations

### List
Several list-based implementations have been included in this project, outlined below.

> #### Singly-Linked List
>> A simple linked-list-based structure that includes a list of nodes with only one-dimensional links.

> #### Doubly-Linked List
>> Iterating on the singly-linked list implementation, this structure includes a list of bidirectionally-linked nodes in order to improve operational efficiencies at certain locations within the list.

> #### Queue
>> Basic FIFO structure built upon the Doubly-Linked List mechanism described above.

> #### Stack
>> A LIFO data structure that also utilizes the project's Doubly-Linked List logic.

### Tree
A few tree-based, node-focused structures have been added to the project, notably supporting well-known search and traversal algorithms within their implementations.

> #### Binary Search Tree
>> Probably the most popular tree-based implementation, this container includes common implementations for many algorithms, including ordered traversals, depth-first search, and breadth-first search.

> #### Graph
>> This rudimentary tree-based implementation includes a basic, directed graph structure utilizing an adjacency-list-inspired 'Adjacency Map' implementation built upon an internal HashMap mechanism to track routes between nodes.

> #### Heap
>> Min / Max Heap fixed-size, array-based implementations have been built utilizing a common underlying abstract Heap class, which contains many methods and properties common to both types of heaps.

### Hash Table
Though there are many methods to implementing the specifics of a hash map, table, set, etc...I have chosen to build my structure with support for generic key-value entries, separate-chaining hash collision avoidance, and prime number dynamic resizing mechanisms.

## Testing
I tried to reach as much coverage as possible, and no commit should be pushed to master when tests are failing. I have also built an extensible TestAssetEngine, which allows for the quick creation of randomly-generated, accurate, scalable data that can be used to test any module within the project.

