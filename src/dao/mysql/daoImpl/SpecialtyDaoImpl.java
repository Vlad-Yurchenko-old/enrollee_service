package dao.mysql.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.SpecialtyDao;
import dao.mysql.Connector;
import domain.entityImpl.Specialty;

public class SpecialtyDaoImpl implements SpecialtyDao{

	@Override
	public void create(Specialty entity) throws SQLException {
		String sql = "INSERT INTO specialty (`name`,`set`,`univers_id`) VALUES (?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, entity.getName());
			statement.setInt(2, entity.getSet());
			statement.setInt(3, entity.getUniversityID());
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
	public Specialty read(int id) throws SQLException {
		String sql = "SELECT * FROM specialty WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			Specialty specialty = new Specialty();
			if (resultSet.next()) {
				specialty.setId(id);
				specialty.setName(resultSet.getString("name"));
				specialty.setSet(resultSet.getInt("set"));
				specialty.setUniversityID(resultSet.getInt("univers_id"));
			}
			return specialty;
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
	public void update(Specialty entity) throws SQLException {
		String sql = "UPDATE `specialty` SET `name` = ?, `set` = ?, `univers_id` = ? WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getName());
			statement.setInt(2, entity.getSet());
			statement.setInt(3, entity.getUniversityID());
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
		String sql = "DELETE FROM `specialty` WHERE `id` = ?";
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
	public List<Specialty> readAll() throws SQLException {
		String sql = "SELECT * FROM specialty";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = Connector.getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<Specialty> specialties = new ArrayList<>();
			while (r.next()) {
				Specialty specialty = new Specialty();
				specialty.setId(r.getInt("id"));
				specialty.setName(r.getString("name"));
				specialty.setSet(r.getInt("set"));
				specialty.setUniversityID(r.getInt("univers_id"));
				specialties.add(specialty);
			}
			return specialties;
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
