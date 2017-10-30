package dao.mysql.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.SubjectDao;
import dao.mysql.Connector;
import domain.entityImpl.Subject;

public class SubjectDaoImpl implements SubjectDao {

    @Override
    public void create(Subject entity) throws SQLException {
        String sql = "INSERT INTO subject (`name`) VALUES (?)";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = Connector.getConnection();
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getName());
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
    public Subject read(int id) throws SQLException {
        String sql = "SELECT `name` FROM subject WHERE `id` = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = Connector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            Subject subject = new Subject();
            if (resultSet.next()) {
                subject.setId(id);
                subject.setName(resultSet.getString("name"));
            }
            return subject;
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
    public void update(Subject entity) throws SQLException {
        String sql = "UPDATE `subject` SET `name` = ? WHERE `id` = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = Connector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getId());
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
        String sql = "DELETE FROM `subject` WHERE `id` = ?";
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
    public List<Subject> readAll() throws SQLException {
        String sql = "SELECT * FROM SUBJECT";
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = Connector.getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            List<Subject> subjects = new ArrayList<>();
            while (r.next()) {
                Subject subject = new Subject();
                subject.setId(r.getInt("id"));
                subject.setName(r.getString("name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
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
