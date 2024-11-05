package ly.pt.dao.custom.impl;

import ly.pt.config.FactoryConfiguration;
import ly.pt.dao.custom.AdminDAO;
import ly.pt.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDAOImpl implements AdminDAO {

    @Override
    public boolean save(Admin admin) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(admin);
        transaction.commit();
        session.close();
        return true;
    }
}
