package ly.pt.dao.custom;



import ly.pt.dao.CrudDao;
import ly.pt.entity.Student;

import java.io.IOException;
import java.util.List;

public interface StudentDao extends CrudDao<Student> {
    boolean save(Student enitiy) throws IOException;

    boolean update(Student dto) throws IOException;

    boolean delete(int entity) throws IOException;

    List<Student> getaAll() throws IOException;


    List<Student> SearchSID(int sid) throws IOException;



    Student searchById(int id);
}
