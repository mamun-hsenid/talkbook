package com.hsenid.talkbook.repository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {

    public static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private JdbcTemplate talkbookJdbcTemplate;
    String userInsertQuery = "insert into User (username,email) values (?, ?)";

    public void createUser(String username, String email){
        talkbookJdbcTemplate.update(userInsertQuery, new Object[]{username, email});
        logger.info("User created with user name [{}] and email [{}]", username, email);
    }


    public void setTalkbookJdbcTemplate(JdbcTemplate talkbookJdbcTemplate) {
        this.talkbookJdbcTemplate = talkbookJdbcTemplate;
    }
}
