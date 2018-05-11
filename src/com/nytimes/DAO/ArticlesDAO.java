package com.nytimes.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.nytimes.pojo.Articles;
import com.nytimes.pojo.Docs;

@Repository
public class ArticlesDAO {
	public void addArticles(Articles articles) {
		Connection connection = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nytimes", "root", "123456");
			stmt = connection.createStatement();
			ArrayList<Docs> docs = articles.getResponse().getDocs();
			for (Docs d : docs) {
				String headline = d.getHeadline().getMain().replaceAll("'", "''");
				String snippet = d.getSnippet().replaceAll("'", "''");
				String brief = null;
				if (d.getBrief() != null) {
					brief = d.getBrief().replaceAll("'", "''");
				}
				String query = "INSERT INTO `nytimes`.`articles` (`headline`, `web_url`, `snippet`, `abstract`, `pub_date`, `source`, `subsection_name`, `document_type`, `type_of_material`, `word_count`, `score`) VALUES ('"
						+ headline + "', '" + d.getWeb_url() + "', '" + snippet + "', '" + brief + "', '"
						+ d.getPub_date() + "', '" + d.getSource() + "', '" + d.getSubsection_name() + "', '"
						+ d.getDocument_type() + "', '" + d.getType_of_material() + "', '" + d.getWord_count() + "', '"
						+ d.getScore() + "')";
				// System.out.println(query);
				stmt.executeUpdate(query);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
