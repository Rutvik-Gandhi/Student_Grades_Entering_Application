# Student Grades Management System

This Android application is designed to manage student grades and improvements. It provides functionalities to enter student grades, track improvements, search for student grades, and view a list of all students' grades.

## Description

The application consists of several fragments that handle different aspects of student grade management:
- **GradeEnter**: Allows users to enter student grades, including the student's name, program, and marks for four courses.
- **ImprovementEnter**: Enables users to record improvements for students by entering the course and marks obtained for improvement.
- **Gradesearch**: Allows users to search for student grades by entering the student's ID.
- **AllStudents**: Displays a list of all students along with their grades.

The main activity (`MainActivity`) controls the navigation between these fragments using a navigation drawer.

## Features

- **Grade Entry**: Users can enter grades for students, including marks for four courses.
- **Improvement Tracking**: Users can track improvements for students by entering additional marks for specific courses.
- **Search Functionality**: Users can search for student grades by entering the student's ID.
- **List View**: Users can view a list of all students along with their grades.
- 
### `AllStudents.java`

- Fragment responsible for displaying a list of all students and their grades.
- Uses a RecyclerView to display the list with a custom adapter (`ListAdapter`).
- Retrieves student data from the database and populates the RecyclerView.

### `GradeEnter.java`

- Fragment for entering student grades.
- Allows users to input the student's name, program, and marks for four courses.
- Validates input fields and saves data to the database using `DbHelperClass`.

### `ImprovementEnter.java`

- Fragment for recording improvements for students.
- Enables users to enter the course and marks obtained for improvement.
- Validates input fields and saves improvement data to the database using `DbHelperClass`.

### `Gradesearch.java`

- Fragment for searching for student grades by entering the student's ID.
- Retrieves student data from the database based on the entered ID and displays it to the user.

### `DbHelperClass.java`

- SQLite database helper class responsible for managing the database operations.
- Defines methods for creating, updating, and querying the database tables (`Grades` and `Improvement`).

### `MainActivity.java`

- Main activity class controlling the navigation between different fragments using a navigation drawer.
- Handles the selection of menu items in the navigation drawer and replaces fragments accordingly.

## Contributions

Contributions to this project are welcome. If you find any bugs or have suggestions for improvements, please feel free to submit an issue or create a pull request.

