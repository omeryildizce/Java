package com.hibernateDemo;
 

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		// Unit of work
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			// HQL --> Hibernate Query Language
			// "from City c where c.countryCode='TUR' And c.district='Ankara'"
			// "from City c where c.name like '%kar%'"
			// "from City c order by c.name  desc"
//			session.beginTransaction();
//			List<String> countryCodes = session.createQuery("select c.countryCode from City c group by c.countryCode").getResultList();
//			for(String countryCode: countryCodes)
//			{
//				System.out.println(countryCode);
//			}
			// Insert
//			City city = new City();
//			city.setName("Duzce");
//			city.setCountryCode("TUR");
//			city.setDistrict("Karadeniz");
//			city.setPopulation(100000);
//			session.save(city);
			// Update
//			City city = session.get(City.class, 4080);
//			System.out.println(city.getName() + ": "+ city.getPopulation());
//			city.setPopulation(111000);
//			session.save(city);
//			session.getTransaction().commit();
			// Delete
			City city = session.get(City.class, 4080);
			session.delete(city);
			
			// System.out.println("Şehir eklendi."); 
			// System.out.println("Şehir güncellendi.");
			System.out.println("Şehir silindi.");
		}
		finally {
			factory.close();
		}
	}

}
