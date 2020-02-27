package hibernate_simple;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{	
			//--------------------------Reading student from DB------------------------------
			
			session.beginTransaction();
			
			Student readStudent=session.get(Student.class,1);
			
			System.out.println(readStudent);
			
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}

}
