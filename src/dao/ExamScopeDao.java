package dao;

import java.sql.SQLException;
import java.util.List;

import domain.entityImpl.ExamScope;

public interface ExamScopeDao extends Dao<ExamScope> {

	List<ExamScope> readAll() throws SQLException;
	
}
