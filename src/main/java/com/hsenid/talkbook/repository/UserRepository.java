package com.hsenid.talkbook.repository;

import com.hsenid.talkbook.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository {

    private JdbcTemplate talkbookJdbcTemplate;

    String userInsertQuery = "insert into users (user_id, username, email, password) values (?, ?, ?, ?)";

    String allUserGetQuery = "select * from users";

    String userUpdateQuery = "update users set password = ? where user_id = ? ";

    String userDeleteQuery = "delete from users where user_id = ?";

    public void createUser(User user){
        talkbookJdbcTemplate.update(userInsertQuery, new Object[]{user.getUserId(), user.getUsername(), user.getEmail(), user.getPassword()});
    }

    public List<User> getAllUsers() {
        List<User> allUsers = talkbookJdbcTemplate.query(allUserGetQuery, new UserRowMapper());
        return allUsers;
    }

    public void updateUser(User user, int userId) {
        talkbookJdbcTemplate.update(userUpdateQuery, new Object[]{user.getPassword(), userId});
    }

    public void deleteUser(int userId) {
        talkbookJdbcTemplate.update(userDeleteQuery, userId);
    }

    public class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();

            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));

            return user;
        }
    }

    public void setTalkbookJdbcTemplate(JdbcTemplate talkbookJdbcTemplate) {
        this.talkbookJdbcTemplate = talkbookJdbcTemplate;
    }
}
