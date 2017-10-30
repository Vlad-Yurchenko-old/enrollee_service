package service;

import java.util.List;

import domain.Entity;

public interface Service <T extends Entity> {

	void create(T entity);
	
	T read (int id);
	
	void update(T entity);
	
	void delete(int id);
	
	List<T> readAll();
	
}
