
package clases_de_sistema;


public class Facultad {
    
    private String idrepresentante;
    private String nombrerepresentante;
    private String idfacultad;
    private String nombrefacultad;
    private String nombrefacultadAnterior;
    
    
    public Facultad(){
    
    }
    
    public Facultad(String idFacultad, String nombreFacultad){
        this.idfacultad = idFacultad;
        this.nombrefacultad = nombreFacultad;
        
    }
    
    public String getIdrepresentante() {
        return idrepresentante;
    }

    public void setIdrepresentante(String idrepresentante) {
        this.idrepresentante = idrepresentante;
    }

    public String getNombrerepresentante() {
        return nombrerepresentante;
    }

    public void setNombrerepresentante(String nombrerepresentante) {
        this.nombrerepresentante = nombrerepresentante;
    }

    public String getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(String idfacultad) {
        this.idfacultad = idfacultad;
    }

    public String getNombrefacultad() {
        return nombrefacultad;
    }

    public void setNombrefacultad(String nombrefacultad) {
        this.nombrefacultad = nombrefacultad;
    }

    public String getNombrefacultadAnterior() {
        return nombrefacultadAnterior;
    }

    public void setNombrefacultadAnterior(String nombrefacultadAnterior) {
        this.nombrefacultadAnterior = nombrefacultadAnterior;
    }
   
    @Override
    public String toString(){
        return idfacultad + " - " + nombrefacultad;
    }
    
    @Override
    public boolean equals(Object obj){
        return this.idfacultad.equals(((Facultad) obj).idfacultad);
    }
    
}
