package service.serviceImpl;

import java.util.List;

import dao.mysql.daoImpl.EnrolleeDaoImpl;
import domain.entityImpl.Enrollee;
import service.Service;

public class EnrolleeService implements Service<Enrollee>{

	@Override
	public void create(Enrollee entity) {
		try {
			new EnrolleeDaoImpl().create(entity);
		} catch (Exception e) {
			System.err.println(" : " + e.getMessage());
		}
	}

	@Override
	public Enrollee read(int id) {
		try {
			return new EnrolleeDaoImpl().read(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

	@Override
	public void update(Enrollee entity) {
		try {
			new EnrolleeDaoImpl().update(entity);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {
			new EnrolleeDaoImpl().delete(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public List<Enrollee> readAll() {
		try {
			return new EnrolleeDaoImpl().readAll();
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

}
