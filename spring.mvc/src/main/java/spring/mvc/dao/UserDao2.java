package spring.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.model.User;

//@Repository
//@Transactional
public class UserDao2 {

//	@Transactional(readOnly = false)
//	public void saveUser(User user) {
//		getHibernateTemplate().save(user);
//		System.out.println("Done");
//	}
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	//@Transactional(readOnly = false)
	public void saveUser(User user) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		System.out.println("Done");
	}
	
}
