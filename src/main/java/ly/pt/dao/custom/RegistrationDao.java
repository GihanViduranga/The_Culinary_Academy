package ly.pt.dao.custom;


import ly.pt.dao.CrudDao;
import ly.pt.entity.Registration;

import java.io.IOException;
import java.util.List;

public interface RegistrationDao extends CrudDao<Registration> {

    boolean save(Registration Dto) throws IOException;

    boolean delete(Long id) throws IOException;

    List<Registration> getaAll() throws IOException;

    Registration searchByRID(Long id);


}
