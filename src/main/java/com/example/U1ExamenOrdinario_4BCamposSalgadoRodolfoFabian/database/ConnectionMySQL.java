package com.example.U1ExamenOrdinario_4BCamposSalgadoRodolfoFabian.database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionMySQL {
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/AWU1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Chatapicara12-");
    }



    public static void main(String[] args) {

        try{
            Connection con = ConnectionMySQL.getConnection();
            System.out.println("Conexión exitosa");

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void closeConnections(Connection con, PreparedStatement pstm) {
    }
}