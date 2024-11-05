package ly.pt.dao.custom.impl;

import ly.pt.config.FactoryConfiguration;
import ly.pt.dao.custom.StudentDAO;
import ly.pt.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(Student student) {
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

    @Override
    public boolean deleteStudent(String id, Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(id, student);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Student search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class,id);

        transaction.commit();
        session.close();

        return student;
    }

    @Override
    public ArrayList<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        ArrayList<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM Student";

        List<Object[]> studentList = session.createNativeQuery(sql).list();
        for (Object[] student : studentList){
            String id = (String) student[0];
            String address = (String) student[1];
            String dateOfBirth = (String) student[2];
            String email = (String) student[3];
            String phoneNumber = (String) student[4];
            String name = (String) student[5];


            Student student1 = new Student(id, name,dateOfBirth,address,phoneNumber, email);
            students.add(student1);
        }
        transaction.commit();
        session.close();

        return students;
    }

}
