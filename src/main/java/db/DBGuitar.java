package db;

import models.Guitar;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGuitar {

    private static Session session;
    private static Transaction transaction;


    public static void save(Guitar guitar) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(guitar);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Guitar guitar) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(guitar);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    /*  BELOW:
        We don't put void cos we need to return something,
        Create an empty list called result.
        We create a criteria object, which is required to return info which meets a given criteria.
        The criteria object attaches only to db entries with certain properties, and returns them.
        The session. means that its an invdividual instance of that search and we close that with session.close();
        we assign this returned data to results.
      */

    public static List<Guitar> listAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Guitar> result = null;
        try {
            Criteria criteria = session.createCriteria(Guitar.class);
            result = criteria.list();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    /*  Below we pass in type and the id(of guitar) and .eq means equivelent and we tell it to find the id of that


     */

    public static Guitar findOne(int id) {
        Guitar result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Guitar.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Guitar) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return result;

    }
}

