package tw.leonchen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class PictureDao {
	
	@Autowired
	private SessionFactory factory;
	
	public Picture insert(Picture bean) {
		Session session = factory.openSession();
		
		if(bean!=null) {
			session.persist(bean);
			session.flush();
		}
		
		session.close();
		return bean;
	}
	

}
