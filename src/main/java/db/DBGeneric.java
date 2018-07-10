package db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public abstract class DBGeneric {

    private static Session session;
    private static Transaction transaction;

    public static <T extends Object> void save(T object){
        session = HibernateUtil.getSessionFactory().openSession();

        try{transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Throwable e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    protected static <T extends Object> List<T> getAll(Class<T> searchingClass){
        List<T> results = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = session.createCriteria(searchingClass);
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    protected static <T extends Object> T find(int id, Class<T> searchingClass){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;

        try {
            Criteria cr = session.createCriteria(searchingClass);
            cr.add(Restrictions.eq("id", id));
            result = (T) cr.uniqueResult();
        } catch(Throwable e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

}
