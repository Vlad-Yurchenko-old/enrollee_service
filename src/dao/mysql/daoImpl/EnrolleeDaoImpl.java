package dao.mysql.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.EnrolleeDao;
import dao.mysql.Connector;
import domain.entityImpl.Enrollee;

public class EnrolleeDaoImpl implements EnrolleeDao {

	@Override   
	public void create(Enrollee entity) throws SQLException {
		String sql = "INSERT INTO enrollee (`name`,`sur_name`,`last_name`,`specialty_id`,`city`,`gender`,`score`) VALUES (?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getSurName());
			statement.setString(3, entity.getLastName());
			statement.setInt(4, entity.getSpecialtyID());
			statement.setString(5, entity.getCity());
			statement.setString(6, entity.getGender());
			statement.setInt(7, entity.getScore());
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
	public Enrollee read(int id) throws SQLException {
		String sql = "SELECT * FROM enrollee WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			Enrollee enrollee = new Enrollee();
			if (resultSet.next()) {
				enrollee.setId(id);
				enrollee.setName(resultSet.getString("name"));
				enrollee.setSurName(resultSet.getString("sur_name"));
				enrollee.setLastName(resultSet.getString("last_name"));
				enrollee.setSpecialtyID(resultSet.getInt("specialty_id"));
				enrollee.setCity(resultSet.getString("city"));
				enrollee.setGender(resultSet.getString("gender"));
				enrollee.setScore(resultSet.getInt("score"));
			}
			return enrollee;
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
	public void update(Enrollee entity) throws SQLException {
		String sql = "UPDATE `enrollee` SET `name` = ?,`sur_name` = ?,`last_name` = ?,`specialty_id` = ?,`city` = ?,`gender` = ?,`score` = ? WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getSurName());
			statement.setString(3, entity.getLastName());
			statement.setInt(4, entity.getSpecialtyID());
			statement.setString(5, entity.getCity());
			statement.setString(6, entity.getGender());
			statement.setInt(7, entity.getScore());
			statement.setInt(8, entity.getId());
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
		String sql = "DELETE FROM `enrollee` WHERE `id` = ?";
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
	public List<Enrollee> readAll() throws SQLException {
		String sql = "SELECT * FROM enrollee";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = Connector.getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<Enrollee> enrollees = new ArrayList<>();
			while (r.next()) {
				Enrollee enrollee = new Enrollee();
				enrollee.setId(r.getInt("id"));
				enrollee.setName(r.getString("name"));
				enrollee.setSurName(r.getString("sur_name"));
				enrollee.setLastName(r.getString("last_name"));
				enrollee.setSpecialtyID(r.getInt("specialty_id"));
				enrollee.setCity(r.getString("city"));
				enrollee.setGender(r.getString("gender"));
				enrollee.setScore(r.getInt("score"));
				enrollees.add(enrollee);
			}
			return enrollees;
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
