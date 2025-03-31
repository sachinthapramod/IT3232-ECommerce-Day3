package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
//import java.util.Comparator;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {
	
// first code we tried in class
		@GetMapping("/age/{ag}")
		public String MyAge (@PathVariable("ag")int age) {
			return "My age is: " +age;
		}
	
	
//create some student objects
	Student Bob = new Student("Bob ",20, "IT",3.7,"2020ICT57");
	Student Sachee = new Student("Sachintha",25, "IT",3.2,"2020ICT67");
	Student Sena = new Student("Sena",20, "IT", 2.8,"2020ICT96");
	List <Student> students= new ArrayList<Student>();
	
//(01)a method to return a student
		@GetMapping("/student")
		public Student getStudent() {
			return Bob;
		}
		

		// Initialize the students list when the app starts
	    @PostConstruct
	    public void init() {
	        students.add(Bob);
	        students.add(Sachee);
	        students.add(Sena);
	    }

//(02)Return multiple students	    
	    /* 
	     @GetMapping("/students")
	public List<Student> setStudents() {
		students.add(Bob);
		students.add(Sachee);
		students.add(Sena);
		return students;
	}
	*/
	     
	    @GetMapping("/students")
	    public List<Student> getStudents() {
	        return students;
	    }


//(03)find a student from the list by regNo
	    @GetMapping("/student/{id}")
	    public Student getStudent(@PathVariable("id") String regNo) {
	        for (Student student : students) {
	            if (student.getRegNo().equals(regNo)) {
	                return student;
	            }
	        }
	        return null;  
	    }
	    
//(04)find the students whose age is between 20 and 24
	    @GetMapping("/students/age-between")
	    public List<Student> getStudentsByAgeRange() {
	        List<Student> result = new ArrayList<>();

          for (Student student : students) {
                if (student.getAge() >= 20 && student.getAge() <= 24) {
	                result.add(student); 
	            }
	        }
	        return result;
	    }
	    
//(05)sort the students by their GPA
	    @GetMapping("/students/sorted-by-gpa")
	    public List<Student> getStudentsSortedByGPA() {


	        int n = students.size();
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (students.get(j).getGpa() > students.get(j + 1).getGpa()) {
                        Student temp = students.get(j);
	                    students.set(j, students.get(j + 1));
	                    students.set(j + 1, temp);
	                }
	            }
	        }
	        return students;
	    }

//(06)create CURD operations for students
	    


	    // CREATE: Add a new student

	    @PostMapping("/student")
	    public Student createStudent(@RequestBody Student student) {
	        students.add(student); 
            return student; 

	    }


      // UPDATE: Update an existing student by regNo
	    @PutMapping("/student/{id}")
	    public Student updateStudent(@PathVariable("id") String regNo, @RequestBody Student updatedStudent) {
	        for (Student student : students) {
	            if (student.getRegNo().equals(regNo)) {
	                // Update the student details
	                student.setName(updatedStudent.getName());
	                student.setAge(updatedStudent.getAge());
	                student.setCourse(updatedStudent.getCourse());
	                student.setGpa(updatedStudent.getGpa());
	                student.setRegNo(updatedStudent.getRegNo());
	                return student; 

	            }
	        }
	        return null; 

	    }

	    // DELETE: Delete a student by regNo
	    @DeleteMapping("/student/{id}")
	    public String deleteStudent(@PathVariable("id") String regNo) {
	        for (Student student : students) {
	            if (student.getRegNo().equals(regNo)) {
	                students.remove(student); 
                    return "Student with regNo " + regNo + " deleted.";  
	            }
	        }
	        return "Student not found.";  
	    }
	}



