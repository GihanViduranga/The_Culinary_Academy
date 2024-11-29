package ly.pt.bo.custom.impl;


import ly.pt.bo.custom.RegistrationBO;
import ly.pt.dao.DAOFactory;
import ly.pt.dao.custom.CourseDao;
import ly.pt.dao.custom.RegistrationDao;
import ly.pt.dao.custom.StudentDao;
import ly.pt.entity.Course;
import ly.pt.entity.Registration;
import ly.pt.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
    CourseDao courseDao = (CourseDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.COURSE);
    StudentDao studentDao = (StudentDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.STUDENT);
    RegistrationDao registrationDao = (RegistrationDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOType.REGISTRATION);


    @Override
    public boolean saveCourse(Course entity) throws IOException {
        return courseDao.save(new Course(entity.getId(),entity.getProgramId(),entity.getProgramName(),entity.getDuration(),entity.getFee(),entity.getRegistrations()));
    }

    @Override
    public boolean updateCourse(Course entity) throws IOException {
        return courseDao.update(new Course(entity.getId(),entity.getProgramId(),entity.getProgramName(),entity.getDuration(),entity.getFee(),entity.getRegistrations()));
    }

    @Override
    public boolean deleteCourse(String id) throws IOException {
        return courseDao.delete(id);
    }

    @Override
    public List<Course> getAllCourse() throws IOException {

        List<Course> allCourse = courseDao.getaAll();
        return allCourse;

    }

    @Override
    public List<Course> SearchCID(String cid) throws IOException {
        return courseDao.SearchCID(cid);

    }


    @Override
    public boolean saveStudent(Student entity) throws IOException {
        return studentDao.save(new Student(entity.getId(),entity.getFirstName(),entity.getLastName(),entity.getAddress(),entity.getEmail(),entity.getPhoneNumber(),entity.getEnrollmentDate(),entity.getRegistrations(),entity.getRole()));
    }


    @Override
    public boolean updateStudent(Student entity) throws IOException {
        return studentDao.update(new Student(entity.getId(),entity.getFirstName(),entity.getLastName(),entity.getAddress(),entity.getEmail(),entity.getPhoneNumber(),entity.getEnrollmentDate(),entity.getRegistrations(),entity.getRole()));
    }

    @Override
    public boolean deleteStudent(int id) throws IOException {
        return studentDao.delete(id);
    }

    @Override
    public List<Student> getAllStudent() throws IOException {

        List<Student> allStudent = studentDao.getaAll();
        return allStudent;

    }

    @Override
    public List<Student> SearchSID(int sid) throws IOException {

        return studentDao.SearchSID(sid);

    }

    @Override
    public Student serachbyIDS(int cid) throws SQLException, ClassNotFoundException {
        return studentDao.searchById(cid);
    }


    @Override
    public Course serachbyCIDs(String cid) throws SQLException, ClassNotFoundException {
        return courseDao.searchByCId(cid);
    }

    @Override
    public boolean saveRegistration(Registration entity) throws IOException {
        return registrationDao.save(new Registration(entity.getId(),entity.getDuration(),entity.getRegistrationDate(),entity.getPaymentDate(),entity.getPayment(),entity.getDueAmount(),entity.getStudentName(),entity.getProgramName(),entity.getStatus(),entity.getStudent(),entity.getCourse()));
    }

    @Override
    public List<Registration> getAllRegistrationDetails() throws IOException {
        List<Registration> alldetails = registrationDao.getaAll();
        return alldetails;
    }

    @Override
    public boolean deleteRegistration(Long id) throws IOException {
        return registrationDao.delete(id);
    }

    @Override
    public Registration serachbyRID(Long rid) throws SQLException, ClassNotFoundException {
        return registrationDao.searchByRID(rid);
    }

    @Override
    public boolean updateRegistration(Registration registration) throws IOException {
        return registrationDao.update(registration);
    }


}
