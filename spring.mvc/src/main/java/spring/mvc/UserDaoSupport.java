package spring.mvc;


import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoSupport extends HibernateDaoSupport{

	@Transactional(readOnly = false)
	public void saveUser(User user) {
		getHibernateTemplate().save(user);
	}
	
}
