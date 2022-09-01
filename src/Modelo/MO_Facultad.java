/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import clases_de_sistema.Estudiante;
import clases_de_sistema.Facultad;
import clases_de_sistema.linkDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MO_Facultad {
   
    Connection miconexion;
       
    public ArrayList<Facultad> getFacultades(JTable tabla){
        Statement sentencia = null;
        ResultSet resultado = null;
        ArrayList<Facultad> listaFacultades = new ArrayList<>();
        String sql = "Select * from facultad";
        
        try {
            miconexion = linkDB.getConnection();
            sentencia = miconexion.createStatement();                    
            resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                Facultad Facu = new Facultad();
                Facu.setIdfacultad(Integer.toString(resultado.getInt("id_facultad")));
                //Facu.setIdfacultad("5");
                Facu.setNombrefacultad(resultado.getString("nombre"));
                listaFacultades.add(Facu);
                //System.out.println("valor: " + Facu.getIdfacultad()+ " valor: "+ Facu.getNombrefacultad());
            }
            
        } catch (SQLException ex) {
            System.out.println("resultado error : " + ex.getMessage());
        }

        return listaFacultades;
    }
    
    public String agregarEstudiante(Connection Con, Estudiante est){
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO ESTUDIANTE (Nombre, Celular, Carnet, Año_Ingreso, Correo, Password) VALUES(?,?,?,?,?,?)";
        
        String sql = "insert into Facultad (nombre, representante_id_representante) values (?, ? )";
        try{
            pst = Con.prepareStatement(sql);
            pst.setString(1, est.getNombre());
            pst.setString(2, est.getNo_celular());
            pst.setString(3, est.getCarnet());
            pst.setString(4, est.getAnio_ingreso());
            pst.setString(5, est.getCorreo_electronico());
            pst.setString(6, est.getPassword());
            
            mensaje = "Insercion realizada con exito";
            int i = pst.executeUpdate();
            Con.commit();
            pst.close();
            System.out.println("Records Inserted:" + i);
            System.out.println("Estudiante Agregado: " + est.toString());
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
        return mensaje;
    }
    
        public String modificarEstudiante(Connection con, Estudiante est){
        
        PreparedStatement pst = null;
        String sql = "UPDATE ESTUDIANTE SET "
                + "NOMBRE = (?),"
                + "CELULAR = (?),"
                + "AÑO_INGRESO = (?),"
                + "CORREO = (?),"
                + "PASSWORD = (?) "
                + "WHERE CARNET = (?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, est.getNombre());
            pst.setString(2, est.getNo_celular());
            pst.setString(3, est.getAnio_ingreso());
            pst.setString(4, est.getCorreo_electronico());
            pst.setString(5, est.getPassword());
            pst.setString(6, est.getCarnet());


            
            mensaje = "Modficiacion realizada con exito";
            int i = pst.executeUpdate();
            con.commit();
            pst.close();
            System.out.println("Items Modified: " + i);
            
        } catch(SQLException e){
            mensaje = "Error" + e.getMessage();
        }
        
        return mensaje;
    }
    
    
    public void eliminarFacultad(String idfacultad){
        
        
        PreparedStatement pst = null;
        String sql = "DELETE FROM facultad WHERE id_facultad = (?)";
        
        
        try{
            miconexion = linkDB.getConnection();
            pst = miconexion.prepareStatement(sql);
            pst.setString(1, idfacultad);

            int i = pst.executeUpdate();
            miconexion.commit();
            miconexion.close();
            
            System.out.println("Items Deleted: " + i);
            
        } catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }
    
    
    
}
