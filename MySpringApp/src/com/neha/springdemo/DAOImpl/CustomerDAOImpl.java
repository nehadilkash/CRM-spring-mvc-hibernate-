package com.neha.springdemo.DAOImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neha.springdemo.DAO.CustomerDAO;
import com.neha.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = null;
		List<Customer> customers = null;
		try {
			session = sessionFactory.getCurrentSession();
			Query<Customer> query = session.createQuery("from Customer order by firstName", Customer.class);
			customers = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;

	}

	@Override
	public boolean addCustomer(Customer customer) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

	@Override
	public boolean deletCustomer(int customerId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Customer customer = session.get(Customer.class, customerId);
			session.delete(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updtaeCustomer(Customer customer) {
		try {
			
			System.out.println(customer);
			Session session = sessionFactory.getCurrentSession();
			session.update(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
