package ly.pt.bo.custom;

import ly.pt.bo.SuperBO;
import ly.pt.entity.Student;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface StudentBo extends SuperBO {

    boolean saveStudent(Student entity) throws IOException;

    boolean updateStudent(Student entity) throws IOException;

    boolean deleteStudent(int id) throws IOException;

    List<Student> getAllStudent() throws IOException;

    List<Student> SearchSID(int sid) throws IOException;

    Student serachbyIDS(int cid) throws SQLException, ClassNotFoundException;
}
