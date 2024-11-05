package ly.pt.bo.custom.impl;

import ly.pt.bo.custom.AdminBO;
import ly.pt.dao.custom.AdminDAO;
import ly.pt.dao.custom.impl.AdminDAOImpl;
import ly.pt.entity.Admin;
import ly.pt.model.AdminDTO;

public class AdminBOImpl implements AdminBO {
    @Override
    public boolean saveAdmin(AdminDTO admin) {
        AdminDAO adminDAO = new AdminDAOImpl();
        return adminDAO.save(new Admin(admin.getUserId(), admin.getUserName(),admin.getPassword(),admin.getForgetPassword()));
    }
}
