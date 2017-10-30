package service.serviceImpl;

import java.util.List;

import dao.mysql.daoImpl.UniversityDaoImpl;
import domain.entityImpl.University;
import service.Service;

public class UniversityService implements Service<University>{

	@Override
	public void create(University entity) {
		try {
			new UniversityDaoImpl().create(entity);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public University read(int id) {
		try {
			return new UniversityDaoImpl().read(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

	@Override
	public void update(University entity) {
		try {
			new UniversityDaoImpl().update(entity);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {
			new UniversityDaoImpl().delete(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public List<University> readAll() {
		try {
			return new UniversityDaoImpl().readAll();
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

}
