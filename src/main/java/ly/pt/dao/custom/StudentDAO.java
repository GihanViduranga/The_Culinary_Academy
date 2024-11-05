package ly.pt.dao.custom;

import ly.pt.entity.Student;

import java.util.ArrayList;

public interface StudentDAO {
    boolean save(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(String id,Student student);
    Student search(String id);
    ArrayList<Student> getAll();
}
