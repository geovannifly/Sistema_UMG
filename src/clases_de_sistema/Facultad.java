/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package clases_de_sistema;


import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author olgt1
 */
public class Facultad {
    private String id;
    private String nombre;
    private Curso cursos[];
    private Connection miconexion;

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }
    
    public void eliminar(){
        this.id = null;
        this.nombre = null;
    }
    
    public void CrearFacultadDB(/*parametros formulario*/){
        //crear mi inserciion en la DB 
        try {
            miconexion = linkDB.getConnection();
            if (miconexion != null){
                //insercion
                
                
                
                
                miconexion.close();
            }
            
        } catch (SQLException e) {
            
            //alternativa
        }
        
        
        
    }
    
}
