package ly.pt.bo.custom;

import ly.pt.model.StudentDTO;

public interface StudentBO {
    boolean saveStudent(StudentDTO studentDTO);
    boolean updateStudent(StudentDTO studentDTO);
}
