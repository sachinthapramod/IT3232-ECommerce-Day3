# IT3232-ECommerce-Day3
# Student Management System

This is a Spring Boot project that manages student data. The project consists of a `model` package containing a `Student` class and a `controller` package that provides various methods to handle student-related operations.

## Features
- Create sample `Student` objects
- Retrieve a single student
- Retrieve multiple students
- Find a student by registration number
- Find students whose age is between 20 and 23
- Sort students by their GPA
- Implement full CRUD operations for students

## API Endpoints
| Method | Endpoint                  | Description |
|--------|---------------------------|-------------|
| GET    | `/students`                | Get all students |
| GET    | `/students/{id}`            | Get student by ID |
| GET    | `/students/regno/{regno}`   | Find student by registration number |
| GET    | `/students/age-range`       | Find students aged between 20 and 23 |
| GET    | `/students/sorted`          | Get students sorted by GPA |
| POST   | `/students`                 | Add a new student |
| PUT    | `/students/{id}`            | Update an existing student |
| DELETE | `/students/{id}`            | Delete a student |

## Example Output
### 1. Getting all students
```
[
    {
        "id": 1,
        "name": "John Doe",
        "age": 21,
        "regNo": "ST1234",
        "gpa": 3.8
    },
    {
        "id": 2,
        "name": "Jane Smith",
        "age": 22,
        "regNo": "ST5678",
        "gpa": 3.5
    }
]
```

### 2. Finding a student by regNo
```
{
    "id": 1,
    "name": "John Doe",
    "age": 21,
    "regNo": "ST1234",
    "gpa": 3.8
}
```

### 3. Sorting students by GPA
```
[
    {
        "id": 2,
        "name": "Jane Smith",
        "age": 22,
        "regNo": "ST5678",
        "gpa": 3.5
    },
    {
        "id": 1,
        "name": "John Doe",
        "age": 21,
        "regNo": "ST1234",
        "gpa": 3.8
    }
]
```

