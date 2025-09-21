package StudentManagment.example.demo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Studentjpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @Email(message ="Email Should Be Valid")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message="Course name should be filled!!")
    private String course;

    @Min(value=1 , message= ("Age Must Be greater than 5"))
    @Max(value=22,message=("Age Should be less than 22"))
    private int age;

    // Default constructor (required by JPA)
    public Studentjpa() {}

    // Constructor
    public Studentjpa (String name, String email, String course, int age)
    {
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
