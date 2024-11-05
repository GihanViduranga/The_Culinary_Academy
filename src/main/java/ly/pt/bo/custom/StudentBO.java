package ly.pt.bo.custom;

import ly.pt.model.StudentDTO;

import java.util.ArrayList;

public interface StudentBO {
    boolean saveStudent(StudentDTO studentDTO);
    boolean updateStudent(StudentDTO studentDTO);
    boolean deleteStudent(String studentId,StudentDTO studentDTO);
    StudentDTO search(String id);
    ArrayList<StudentDTO> getAllStudents();
}
