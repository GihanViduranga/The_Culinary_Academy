package ly.pt.bo.custom;


import ly.pt.bo.SuperBO;
import ly.pt.entity.Course;
import ly.pt.entity.Registration;
import ly.pt.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RegistrationBO extends SuperBO {

    boolean saveCourse(Course entity) throws IOException;

    boolean updateCourse(Course entity) throws IOException;

    boolean deleteCourse(String id) throws IOException;

    List<Course> getAllCourse() throws IOException;

    List<Course> SearchCID(String cid) throws IOException;


    boolean saveStudent(Student entity) throws IOException;

    boolean updateStudent(Student entity) throws IOException;

    boolean deleteStudent(int id) throws IOException;

    List<Student> getAllStudent() throws IOException;

    List<Student> SearchSID(int sid) throws IOException;

    Student serachbyIDS(int cid) throws SQLException, ClassNotFoundException;


    Course serachbyCIDs(String cid) throws SQLException, ClassNotFoundException;

    boolean saveRegistration(Registration entity) throws IOException;

    List<Registration> getAllRegistrationDetails() throws IOException;

    boolean deleteRegistration(Long id) throws IOException;

    Registration serachbyRID(Long rid) throws SQLException, ClassNotFoundException;

    boolean updateRegistration(Registration registration) throws IOException;
}
