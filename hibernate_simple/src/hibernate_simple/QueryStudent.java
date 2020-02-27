package hibernate_simple;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class QueryStudent {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			List<Student> StudentList=session.createQuery("from Student").getResultList();
			
			for(Student Stud:StudentList)
			{
				System.out.println(Stud);
			}
			
			//Qyery based on Last name s.lastname(java property name and not column name) 
			StudentList=session.createQuery("from Student s where s.lastname='K'").getResultList();
			
			for(Student Stud:StudentList)
			{
				System.out.println(Stud);
			}
			
			
			
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}

}
