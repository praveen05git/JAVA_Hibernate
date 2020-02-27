package hibernate_simple;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			//-------------------------Writing student to DB--------------------------------
			
			//Student new_student=new Student("Praveen","Kumar","praveen@mail.com");
			Student new_student=new Student("John","Wick","pk@mail.com");
			
			session.beginTransaction();
			
			session.save(new_student);
			
			session.getTransaction().commit();
			
			System.out.println("Written to DB");
			
			
		}
		finally
		{
			factory.close();
		}

	}

}
