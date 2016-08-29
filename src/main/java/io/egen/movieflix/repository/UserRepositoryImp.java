package io.egen.movieflix.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import io.egen.movieflix.entity.User;


import org.springframework.stereotype.Repository;




@Repository
public class UserRepositoryImp implements UserRepository {
	
	
	@PersistenceContext
	public EntityManager em;

	
	@Override
	public User create(User user) {
		
		em.merge(user);
		return user;
	}
	
	
	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findById(String id) {
		TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
		query.setParameter("pId", id);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
		query.setParameter("pId", user.getId());
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			if(user.getPassword().equals(users.get(0).getPassword())){
				return user;
			}
		}
		
		return null;
	}

	
	
	

}
