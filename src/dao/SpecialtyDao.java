package dao;

import java.sql.SQLException;
import java.util.List;

import domain.entityImpl.Specialty;

public interface SpecialtyDao extends Dao<Specialty> {

	List<Specialty> readAll() throws SQLException;
	
}
