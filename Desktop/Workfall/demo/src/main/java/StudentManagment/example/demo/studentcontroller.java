package StudentManagment.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class studentcontroller
{
	 @Autowired
	    private studentservice studentService;
	 
   @GetMapping
   public List<Studentjpa> getAllStudents()
   {
	   return studentService.getAllStudents();
   }
   @GetMapping("/{id}")
   public Studentjpa getStudentById(@PathVariable int id)
   {
	   return studentService.getStudentById(id);
   }
   @PostMapping
   public Studentjpa addStudent(@Valid @RequestBody Studentjpa student) 
   {
       return studentService.addStudent(student);
   }

   @PutMapping("/{id}")
   public Studentjpa updateStudent(@PathVariable int  id, @Valid @RequestBody Studentjpa student)
   {
       return studentService.updateStudent(id, student);
   }

   @DeleteMapping("/{id}")
   public String deleteStudent(@PathVariable int  id) 
   {
       studentService.deleteStudent(id);
       return "Student with ID " + id + " deleted successfully!";
   }
}
