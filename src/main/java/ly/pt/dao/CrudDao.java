package ly.pt.dao;


import ly.pt.entity.Student;

import java.io.IOException;

public interface CrudDao<T> extends SuperDAO {

    boolean save(Student enitiy) throws IOException;

    boolean update(T entity) throws IOException;
    boolean delete(int id) throws IOException;



}
