package StudentManagment.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface  studentrepository extends JpaRepository<Studentjpa, Integer>{

}
