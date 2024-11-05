package ly.pt.bo.custom.impl;

import ly.pt.bo.custom.StudentBO;
import ly.pt.dao.custom.StudentDAO;
import ly.pt.dao.custom.impl.StudentDAOImpl;
import ly.pt.entity.Student;
import ly.pt.model.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        StudentDAO studentDAO = new StudentDAOImpl();
        return studentDAO.save(new Student(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getDateOfBirth(),studentDTO.getAddress(),studentDTO.getPhoneNumber(),studentDTO.getEmail()));
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        StudentDAO studentDAO = new StudentDAOImpl();
        return studentDAO.updateStudent(new Student(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getDateOfBirth(),studentDTO.getAddress(),studentDTO.getPhoneNumber(),studentDTO.getEmail()));
    }

    @Override
    public boolean deleteStudent(String studentId, StudentDTO studentDTO) {
        StudentDAO studentDAO = new StudentDAOImpl();
        return studentDAO.deleteStudent(studentId,new Student(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getDateOfBirth(),studentDTO.getAddress(),studentDTO.getPhoneNumber(),studentDTO.getEmail()));
    }

    @Override
    public StudentDTO search(String id) {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = studentDAO.search(id);
        return new StudentDTO(student.getStudentId(),student.getStudentName(),student.getDateOfBirth(),student.getAddress(),student.getPhoneNumber(),student.getEmail());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> allStudents = new ArrayList<>();

        for (Student student : all){
            allStudents.add(new StudentDTO(student.getStudentId(),student.getStudentName(),student.getDateOfBirth(),student.getAddress(),student.getPhoneNumber(),student.getEmail()));
        }
        return allStudents;
    }


}
