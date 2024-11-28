package ly.pt.dao.custom;


import ly.pt.dao.SuperDAO;
import ly.pt.entity.Admin;

import java.util.ArrayList;

public interface AdminDAO extends SuperDAO {
    boolean save(Admin admin);

    String getId(String username);

    ArrayList<Admin> getAll();

    boolean update(String hashedPassword, String userName);
}
