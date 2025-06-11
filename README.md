# Daily Coding Practice - Java Environment

This is a simple Java project set up for daily coding practice. It includes a basic input/output program to get you started.

## Prerequisites

- Java Development Kit (JDK) 17 or later
- Maven (for building the project)

## Project Structure

```
.
├── pom.xml                 # Maven project configuration
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── dailydose/
│                   └── Main.java  # Main program file
└── README.md              # This file
```

## How to Run

1. Make sure you have JDK 17 and Maven installed
2. Open a terminal in the project directory
3. Build the project:
   ```
   mvn clean package
   ```
4. Run the program:
   ```
   java -cp target/coding-practice-1.0-SNAPSHOT.jar com.dailydose.Main
   ```

## Adding New Programs

To add new programs:
1. Create new Java files in the `src/main/java/com/dailydose/` directory
2. Make sure to include the package declaration: `package com.dailydose;`
3. Build and run as described above

## IDE Setup

You can open this project in any Java IDE (like IntelliJ IDEA, Eclipse, or VS Code with Java extensions). The IDE should automatically recognize it as a Maven project. 