package ly.pt.bo.custom.impl;

import ly.pt.bo.custom.StudentBO;
import ly.pt.dao.custom.StudentDAO;
import ly.pt.dao.custom.impl.StudentDAOImpl;
import ly.pt.entity.Student;
import ly.pt.model.StudentDTO;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = new StudentDAOImpl();
    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        return studentDAO.saveStudent(new Student(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getDateOfBirth(),studentDTO.getAddress(),studentDTO.getPhoneNumber(),studentDTO.getEmail()));
    }
}
