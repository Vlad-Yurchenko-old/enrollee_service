package service.serviceImpl;

import java.util.List;

import dao.mysql.daoImpl.SubjectDaoImpl;
import domain.entityImpl.Subject;
import service.Service;

public class SubjectService implements Service<Subject>{

	@Override
	public void create(Subject entity) {
		try {
			new SubjectDaoImpl().create(entity);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public Subject read(int id) {
		try {
			return new SubjectDaoImpl().read(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

	@Override
	public void update(Subject entity) {
		try {
			new SubjectDaoImpl().update(entity);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {
			new SubjectDaoImpl().delete(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public List<Subject> readAll() {
		try {
			return new SubjectDaoImpl().readAll();
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

}
