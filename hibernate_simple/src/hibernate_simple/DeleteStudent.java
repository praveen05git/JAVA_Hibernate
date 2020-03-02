package hibernate_simple;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{	
			//--------------------------Updating student in DB------------------------------
			
			session.beginTransaction();
			
			Student deleteStudent=session.get(Student.class,2);
			
			session.delete(deleteStudent);
			
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}

}
