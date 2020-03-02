package hibernate_simple;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

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
			
			Student updateStudent=session.get(Student.class,2);
			
			updateStudent.setFirstname("Scobby");
			
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}

}
