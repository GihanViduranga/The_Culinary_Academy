package ly.pt.dao.custom.impl;

import ly.pt.config.FactoryConfiguration;
import ly.pt.dao.custom.CulinaryProgramsDAO;
import ly.pt.entity.CulinaryPrograms;
import ly.pt.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CulinaryProgramDAOImpl implements CulinaryProgramsDAO {
    @Override
    public boolean save(CulinaryPrograms program) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(program);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean Update(CulinaryPrograms program) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(program);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean Delete(String Id, CulinaryPrograms program) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(Id, program);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public ArrayList<CulinaryPrograms> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        ArrayList<CulinaryPrograms> culinaryPrograms = new ArrayList<>();

        String sql = "SELECT * FROM CulinaryPrograms";

        List<Object[]> programList = session.createNativeQuery(sql).getResultList();
        for (Object[] program : programList){
            String programId = (String) program[0];
            String programName = (String) program[3];
            String duration = (String) program[1];
            String fee = (String) program[2];

            CulinaryPrograms programs = new CulinaryPrograms(programId, programName, duration, fee);
            culinaryPrograms.add(programs);
        }
        transaction.commit();
        session.close();

        return culinaryPrograms;
    }
}
