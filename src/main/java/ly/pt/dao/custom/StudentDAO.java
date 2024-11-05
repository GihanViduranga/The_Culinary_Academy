package ly.pt.dao.custom;

import ly.pt.entity.Student;

public interface StudentDAO {
    boolean saveStudent(Student student);
    boolean updateStudent(Student student);
}
