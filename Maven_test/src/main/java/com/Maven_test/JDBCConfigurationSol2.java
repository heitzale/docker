package com.Maven_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class JDBCConfigurationSol2 {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1/maven?user=root&password=";

	static Connection connection = null;
	static String code_commune = "78686";
    public static Connection getConnection(){		

    	try {
    	    //System.out.println("Connection : "+ DB_CONNECTION);

			Class.forName(DB_DRIVER);

            if(connection == null) {
                connection = DriverManager.getConnection(DB_CONNECTION);
            }
            ResultSet rset = null;
			Statement stmt = connection.createStatement();
			if (stmt.execute("SELECT Nom_commune, Code_postal"
					+ " FROM ville_france WHERE Code_commune_INSEE =" + code_commune)) {
				rset = stmt.getResultSet();
			} else {
				rset = null;
			}

			String 	nom_commune = null;
			String code_postal = null;
			String ligne_5 = null;

			while (rset.next()) {

				nom_commune = rset.getString("Nom_commune");
				code_postal = rset.getString("Code_postal");
//				ligne_5 = rset.getString("Ligne_5");
				
//				System.out.println(nom_commune + "" + code_postal + "" + ligne_5);
				System.out.println("La meilleure ville du monde est : " +nom_commune +" "+ code_postal);
			} //fin de la boucle

			
			rset.close();
			stmt.close();
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
            e1.printStackTrace();
        }
        return connection;
    }
    
}