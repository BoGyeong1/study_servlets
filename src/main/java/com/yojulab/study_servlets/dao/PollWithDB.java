package com.yojulab.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class PollWithDB {

    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException {

        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM QUESTIONS_LIST " +
                " WHERE QUESTIONS_UID='" + questionsUid + "'";

        ResultSet reseltSet = statement.executeQuery(query);
        HashMap<String, Object> result = null;
        while (reseltSet.next()) {
            result = new HashMap<>();
            result.put("QUESTIONS_UID", reseltSet.getString("QUESTIONS_UID"));
            result.put("QUESTIONS", reseltSet.getString("QUESTIONS"));
            result.put("ORDERS", reseltSet.getInt("ORDERS"));

        }

        return result;
    }

}
