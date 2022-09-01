/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_de_sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fly10
 */
public class linkDB {
    //parametros
    
    private static Connection conn = null;
    public  static String login = "UMG";
    public static  String clave = "123456";
    private static String url= "jdbc:oracle:thin:@localhost:1521:xe";
    
    public Connection getExistingConnection(){
        return this.conn;
    }
    
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);
            if(conn != null){
                JOptionPane.showMessageDialog (null, "Conexion exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Error de Conexion");
            }
        }
        catch (ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error de conexion " + e.getMessage());
        }
        System.out.println("salgo de get connection con : " + conn.toString());
        return conn;
    }
    
        public static void desconexion(){
        try{
            conn.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog (null, "error al desconectra" + e.getMessage());
        }
    }
    
    
    
    
    
    public static void conectarDB(){
    
    }
    
}
