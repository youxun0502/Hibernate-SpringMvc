package tw.leonchen.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import tw.leonchen.model.ParkBean;

public class DemoParkBeanAction {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		
		ParkBean pBean = new ParkBean();
		pBean.setParkname("Beautiful Park");
		//session.save(hBean);
		session.persist(pBean);
		
		ts.commit();
		session.close();
		factory.close();
	}
}


