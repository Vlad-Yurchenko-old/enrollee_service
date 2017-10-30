package service.serviceImpl;

import java.util.List;

import dao.mysql.daoImpl.ExamScopeDaoImpl;
import domain.entityImpl.ExamScope;
import service.Service;

public class ExamScopeService implements Service<ExamScope>{

	@Override
	public void create(ExamScope entity) {
		try {
			new ExamScopeDaoImpl().create(entity);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public ExamScope read(int id) {
		try {
			return new ExamScopeDaoImpl().read(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

	@Override
	public void update(ExamScope entity) {
		try {
			new ExamScopeDaoImpl().update(entity);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {
			new ExamScopeDaoImpl().delete(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public List<ExamScope> readAll() {
		try {
			return new ExamScopeDaoImpl().readAll();
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

}
