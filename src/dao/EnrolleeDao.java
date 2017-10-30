package dao;

import java.sql.SQLException;
import java.util.List;

import domain.entityImpl.Enrollee;

public interface EnrolleeDao extends Dao<Enrollee> {

	List<Enrollee> readAll() throws SQLException;
	
}
