package ly.pt.dao.custom.impl;

import ly.pt.config.FactoryConfiguration;
import ly.pt.dao.custom.StudentDAO;
import ly.pt.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean saveStudent(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean updateStudent(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();

        return true;
    }
}
