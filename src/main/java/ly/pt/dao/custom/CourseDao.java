package ly.pt.dao.custom;


import ly.pt.dao.CrudDao;
import ly.pt.entity.Course;

import java.io.IOException;
import java.util.List;

public interface CourseDao extends CrudDao<Course> {

    boolean delete(String entity) throws IOException;

    List<Course> getaAll() throws IOException;

    List<Course> SearchCID(String cid) throws IOException;

    Course searchByCId(String id);

    boolean save(Course course) throws IOException;
}
