package cargaMaterias.models;

public class Materia {
    private String nombreMateria;
    private String grupo;

    public Materia(String nombreMateria, String grupo) {
        this.nombreMateria = nombreMateria;
        this.grupo = grupo;
    }
    public Materia(){
        this.nombreMateria =  "sin materia";;
        this.grupo = "sin grupo";
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public String getGrupo() {
        return grupo;
    }
}
