# Player Ranking System — Binary Search Tree (BST)

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)

This project consists of a gaming ranking management system developed in Java. The system dynamically stores and sorts player data using a Binary Search Tree (BST). Despite having a simple terminal interface, the project's architecture was designed with a focus on applying fundamental concepts of algorithms and software engineering.

## Skills Developed and Applied

* **Pointer and Reference Manipulation:** Control and restructuring of pointers in memory (`left` and `right`) within the tree nodes, ensuring data integrity after deletions and updates.
* **Advanced Recursive Algorithms:** Implementation of recursion for node insertion, search, and removal operations — highlighting the handling of node removal with two children by finding the in-order successor.
* **Object Instance Management:** Organization of data flow to prevent tree structure corruption when modifying an object's sorting key (score), controlling the lifecycle and cloning of references.
* **Tree Traversals:** Practical mastery in traversing branched structures, applying In-Order (ascending order), Pre-Order, and Post-Order scans.
* **Teamwork and Version Control:** Collaborative development via GitHub, utilizing Git versioning, task division, conflict resolution, and a structured commit history.

## Project Features

The system features an interactive console menu that allows you to:
* **Register Player:** Dynamic insertion into the tree, validating against duplicate scores.
* **Search by Score:** Instant location of player data.
* **Update Data:** Allows changing the name, level, or score (with automatic node reallocation within the tree if the score changes).
* **Remove Player:** Classic removal algorithm with pointer restructuring.
* **Tree Metrics:** Display of the total number of players and real-time calculation of the tree height.
* **Automatic Test Data Generation:** Automatic initialization of 9 players with random data and unique scores as soon as the system runs, ideal for immediate practical testing.

## How to Run

Make sure you have the Java JDK installed on your machine.

1. Clone the repository:
```bash
git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
cd your-repository-name
