package ly.pt.bo.custom;


import ly.pt.bo.SuperBO;
import ly.pt.model.AdminDTO;

import java.util.ArrayList;

public interface AdminBO extends SuperBO {
    boolean saveAdmin(AdminDTO admin);

    String getIdByUserName(String username);

    ArrayList<AdminDTO> getAllAdmins();

    boolean updatePassword(String newPassword, String userName);
}
