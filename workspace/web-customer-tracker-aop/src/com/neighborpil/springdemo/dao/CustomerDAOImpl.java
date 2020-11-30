package com.neighborpil.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neighborpil.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0) {

			theQuery = currentSession
					.createQuery("from Customer "
							+ "where lower(firstName) like :theName or lower(lastName) like :theName "
							+ "order by lastName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");	
		}
		else {
			// name is empty so just get all customers
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the custoemr .. finally 
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hiberante session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// nwo reterieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}
}



















