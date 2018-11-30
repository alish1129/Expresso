package com.example.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 
public class CreateStudentDataBase {
	
		public static void main(String[] args) {
			//create a session factory
			SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(StockDao.class)
										.buildSessionFactory();
			
			
			//create a session
			Session session =factory.getCurrentSession();
			
			
			try {
				
				
				
				//create a student object
				System.out.println("create a new studnet object");
				StockDao tempStudent = new StockDao( 14, "prashant","azela12",0, 0, 0, 0, "1.4b", 0);
				
				//start a transaction
				session.beginTransaction();
				
				//save the student object
				System.out.println("Saving the student....");
				session.save(tempStudent);
				
				
				//comit transaction
				session.getTransaction().commit();
				
			}finally {
				factory.close();
			}
			
			
		}
}
