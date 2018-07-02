package db;

import models.Guitar;
import models.Guitarist;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGuitarist {

    private static Session session;
    private static Transaction transaction;


    public static void save(Guitarist guitarist) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(guitarist);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Guitarist guitarist) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(guitarist);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Guitarist> listAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Guitarist> result = null;
        try {
            Criteria criteria = session.createCriteria(Guitarist.class);
            result = criteria.list();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static Guitarist findOne(int id) {
        Guitarist result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Guitarist.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Guitarist) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return result;

    }


}
