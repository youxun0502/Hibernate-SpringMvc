package tw.leonchen.model;


import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {

	@Autowired
	private SessionFactory factory;

	public House selectById(int houseid) throws SQLException {
		Session session = factory.getCurrentSession();
		return session.get(House.class, houseid);
	}
	public List<House> selectAll() {
		Session session = factory.getCurrentSession();
		Query<House> query = session.createQuery("from House", House.class);
		return query.list();
	}
	
	public House insert(House saveBean) {
		Session session = factory.getCurrentSession();
		session.persist(saveBean);
		return saveBean;
	}

}
