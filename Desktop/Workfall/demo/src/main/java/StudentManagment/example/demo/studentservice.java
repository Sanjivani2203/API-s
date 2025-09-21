package StudentManagment.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class studentservice {

	    @Autowired
	    private studentrepository studentRepository;

	    // Get all students
	    public List<Studentjpa> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    // Get student by ID
	    public Studentjpa getStudentById(int id) {
	        return studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
	    }

	    // Add new student
	    public Studentjpa addStudent(Studentjpa student) {
	        return studentRepository.save(student);
	    }

	    // Update student
	    public Studentjpa updateStudent(int id, Studentjpa studentDetails) {
	        Studentjpa student = studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

	        // update details
	        student.setName(studentDetails.getName());
	        student.setEmail(studentDetails.getEmail());
	        student.setCourse(studentDetails.getCourse());
	        student.setAge(studentDetails.getAge());

	        return studentRepository.save(student);
	    }

	    // Delete student
	    public void deleteStudent(int id) {
	        Studentjpa student = studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

	        studentRepository.delete(student);
	    }
	}

