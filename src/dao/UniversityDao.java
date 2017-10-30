package dao;

import java.sql.SQLException;
import java.util.List;

import domain.entityImpl.University;;

public interface UniversityDao extends Dao<University> {

	List<University> readAll() throws SQLException;
	
}
