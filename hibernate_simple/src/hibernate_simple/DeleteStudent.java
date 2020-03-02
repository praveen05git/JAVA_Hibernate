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
			//--------------------------Deleting student from DB------------------------------
			
			session.beginTransaction();
			
			//Student deleteStudent=session.get(Student.class,2);
			
			//session.delete(deleteStudent);
			
			//Deleting student with id=3
			
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}

}
