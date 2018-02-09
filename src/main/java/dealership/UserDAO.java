package dealership;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
}
