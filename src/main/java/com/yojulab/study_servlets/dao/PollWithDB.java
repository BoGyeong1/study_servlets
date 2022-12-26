package com.yojulab.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB {

    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException {

        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM QUESTIONS_LIST " +
                " WHERE QUESTIONS_UID='" + questionsUid + "'";

        ResultSet resultSet = statement.executeQuery(query);
        HashMap<String, Object> result = null;
        while (resultSet.next()) {
            result = new HashMap<>();
            result.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            result.put("QUESTIONS", resultSet.getString("QUESTIONS"));
            result.put("ORDERS", resultSet.getInt("ORDERS"));

        }

        return result;
    }

    public ArrayList<HashMap> getAnswer(String questionsUid) throws SQLException {

        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT ANSWERS.QUESTIONS_UID, EXAMPLE_LIST.ORDERS, EXAMPLE_LIST.EXAMPLE " +
                " FROM ANSWERS 	INNER JOIN EXAMPLE_LIST " +
                " ON ANSWERS.EXAMPLE_UID = EXAMPLE_LIST.EXAMPLE_UID " +
                " WHERE QUESTIONS_UID = '" + questionsUid + "' " +
                " ORDER BY QUESTIONS_UID ";

        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<HashMap> answer_list = new ArrayList<>();
        while (resultSet.next()) {
            HashMap<String, Object> answer = new HashMap<>();
            answer.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            answer.put("ORDERS", resultSet.getInt("ORDERS"));
            answer.put("EXAMPLE", resultSet.getString("EXAMPLE"));

            answer_list.add(answer);
        }

        return answer_list;
    }

}
