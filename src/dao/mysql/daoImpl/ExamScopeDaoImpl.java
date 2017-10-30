package dao.mysql.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.ExamScopeDao;
import dao.mysql.Connector;
import domain.entityImpl.ExamScope;

public class ExamScopeDaoImpl implements ExamScopeDao{

	@Override
	public void create(ExamScope entity) throws SQLException {
		String sql = "INSERT INTO exam_scope (`scope`,`enrollee_id`,`subject_id`) VALUES (?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setInt(1, entity.getScope());
			statement.setInt(2, entity.getEnrolleeID());
			statement.setInt(3, entity.getSubjectID());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
		} finally {
			try {
				resultSet.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				statement.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	@Override
	public ExamScope read(int id) throws SQLException {
		String sql = "SELECT * FROM exam_scope WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			ExamScope examScope = new ExamScope();
			if (resultSet.next()) {
				examScope.setId(id);
				examScope.setScope(resultSet.getInt("scope"));
				examScope.setEnrolleeID(resultSet.getInt("enrollee_id"));
				examScope.setSubjectID(resultSet.getInt("subject_id"));
			}
			return examScope;
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (NullPointerException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(ExamScope entity) throws SQLException {
		String sql = "UPDATE `exam_scope` SET `scope` = ?, `enrollee_id` = ?, `subject_id` = ? WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, entity.getScope());
			statement.setInt(2, entity.getEnrolleeID());
			statement.setInt(3, entity.getSubjectID());
			statement.setInt(4, entity.getId());
			statement.executeUpdate();
		} finally {
			try {
				statement.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM `exam_scope` WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} finally {
			try {
				statement.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	@Override
	public List<ExamScope> readAll() throws SQLException {
		String sql = "SELECT * FROM exam_scope";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = Connector.getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<ExamScope> examScopes = new ArrayList<>();
			while (r.next()) {
				ExamScope examScope = new ExamScope();
				examScope.setId(r.getInt("id"));
				examScope.setScope(r.getInt("scope"));
				examScope.setEnrolleeID(r.getInt("enrollee_id"));
				examScope.setSubjectID(r.getInt("subject_id"));
				examScopes.add(examScope);
			}
			return examScopes;
		} finally {
			try {
				r.close();
				s.close();
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

}
