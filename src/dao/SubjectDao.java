package dao;

import java.sql.SQLException;
import java.util.List;

import domain.entityImpl.Subject;

public interface SubjectDao extends Dao<Subject>{

	List<Subject> readAll() throws SQLException;
	
}
