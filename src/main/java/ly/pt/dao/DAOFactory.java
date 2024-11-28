package ly.pt.dao;


import ly.pt.dao.custom.impl.AdminDAOImpl;
import ly.pt.dao.custom.impl.CourseDaoImpl;
import ly.pt.dao.custom.impl.RegistrationDaoImpl;
import ly.pt.dao.custom.impl.StudentDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {
    }
    public static DAOFactory getDAOFactory() {
        return (daoFactory == null)? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOType {
        ADMIN,STUDENT,COURSE,REGISTRATION
    }
    public SuperDAO getDAO(DAOType types) {
        switch (types){
            case ADMIN:
                return new AdminDAOImpl();
            case STUDENT:
                return new StudentDaoImpl();
            case COURSE:
                return new CourseDaoImpl();
            case REGISTRATION:
                return new RegistrationDaoImpl();
            default:
                return null;
        }
    }
}