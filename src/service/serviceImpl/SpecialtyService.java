package service.serviceImpl;

import java.util.List;

import dao.mysql.daoImpl.SpecialtyDaoImpl;
import domain.entityImpl.Specialty;
import service.Service;

public class SpecialtyService implements Service<Specialty>{

	@Override
	public void create(Specialty entity) {
		try {
			new SpecialtyDaoImpl().create(entity);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public Specialty read(int id) {
		try {
			return new SpecialtyDaoImpl().read(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

	@Override
	public void update(Specialty entity) {
		try {
			new SpecialtyDaoImpl().update(entity);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {
			new SpecialtyDaoImpl().delete(id);
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
	}

	@Override
	public List<Specialty> readAll() {
		try {
			return new SpecialtyDaoImpl().readAll();
		} catch (Exception e) {
			System.err.println("  : " + e.getMessage());
		}
		return null;
	}

}
