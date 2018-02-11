package dealership;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserDAO {
	public void addUserDetails(String username, String password) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {
			// use the session object to save java object

			// create student object
			System.out.println("Creating a new user object");
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);

			// Start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the user...");
			session.save(newUser);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		} finally {
			factory.close();
		}
	}

	public boolean checkDetails(String username, String password) {
		// create session factory
		boolean res = false;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {
			// use the session object to save java object

			// create student object
			System.out.println("Checking to see if the user exists...");
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);

			// Start a transaction
			session.beginTransaction();

			Query query = session.createQuery("from User where username = :username and password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			User user = (User) query.uniqueResult();
			if (user != null)
				if (user.getUsername() != null && user.getPassword() != null && user.getUsername().equals(username)
						&& user.getPassword().equals(password)) {
					res = true;
				}

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		} finally {
			factory.close();
		}
		return res;
	}

	public ArrayList<Car> getCars() {
		ArrayList<Car> carlist = new ArrayList<Car>();
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Car.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();
		try {

			// Start a transaction
			session.beginTransaction();
			// Save the list of cars to Arraylist: Query result is saved in the form of list
			carlist = (ArrayList<Car>) session.createQuery("FROM Car").list();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		} finally {
			factory.close();
		}

		return carlist;
	}
}
