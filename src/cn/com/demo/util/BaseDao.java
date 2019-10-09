package cn.com.demo.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;


public abstract class BaseDao {
   public void save(Object obj){
	   Session session = HibernateSessionFactory.getSession();
	   Transaction transaction = session.beginTransaction();
	   session.save(obj);
	   transaction.commit();
   }
   
   public void update(Object obj){
	   Session session = HibernateSessionFactory.getSession();
	   Transaction transaction = session.beginTransaction();
	   session.update(obj);
	   transaction.commit();
   }
   
   public void delete(Object obj){
	   Session session = HibernateSessionFactory.getSession();
	   Transaction transaction = session.beginTransaction();
	   session.delete(obj);
	   transaction.commit();
   }
   
   @SuppressWarnings("rawtypes")
   public Object get(Class cla,Object obj){
	   Session session = HibernateSessionFactory.getSession();
	   return session.get(cla, (Serializable)obj);
   }
}
