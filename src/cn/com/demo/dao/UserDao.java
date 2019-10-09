package cn.com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.com.demo.entity.User;
import cn.com.demo.util.BaseDao;
import cn.com.demo.util.HibernateSessionFactory;

public class UserDao extends BaseDao{
  public void save(User obj){
	  super.save(obj);
  }
  
  public List<User> findByNameAndPwd(User user){
	  Session session=HibernateSessionFactory.getSession();
	  String hql="from User u where u.userName = ? and u.passWord = ?";
	  Query query=session.createQuery(hql);
	  query.setParameter(0, user.getUserName().trim());
	  query.setParameter(1, user.getPassWord());
	  List<User> list=query.list();
	  return list;
  }
  
  public boolean findUserByName(String userName){
	  Session session=HibernateSessionFactory.getSession();
	  String hql="from User u where u.userName = ?";
	  Query query=session.createQuery(hql);
	  query.setParameter(0,userName);
	  List<User> list = query.list();
	  if(list!=null && list.size()>0){
		  return false;
	  }
	  return true;
	  
  }
  
  
}
