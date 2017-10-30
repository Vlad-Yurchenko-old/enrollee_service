package dao.mysql.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.UniversityDao;
import dao.mysql.Connector;
import domain.entityImpl.University;

public class UniversityDaoImpl implements UniversityDao{

	@Override
	public void create(University entity) throws SQLException {
		String sql = "INSERT INTO univers (`name`,`city`) VALUES (?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getCity());
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
	public University read(int id) throws SQLException {
		String sql = "SELECT * FROM univers WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			University university = new University();
			if (resultSet.next()) {
				university.setId(id);
				university.setName(resultSet.getString("name"));
				university.setCity(resultSet.getString("city"));
			}
			return university;
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
	public void update(University entity) throws SQLException {
		String sql = "UPDATE `univers` SET `name` = ?, `city` = ? WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getCity());
			statement.setInt(3, entity.getId());
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
		String sql = "DELETE FROM `univers` WHERE `id` = ?";
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
	public List<University> readAll() throws SQLException {
		String sql = "SELECT * FROM univers";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = Connector.getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<University> universities = new ArrayList<>();
			while (r.next()) {
				University university = new University();
				university.setId(r.getInt("id"));
				university.setName(r.getString("name"));
				university.setCity(r.getString("city"));
				universities.add(university);
			}
			return universities;
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
