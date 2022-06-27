package cargaMaterias.models;

import java.util.ArrayList;

public class Alumno {
    String nombre, password;
    int matricula;
    Materia cargaDefault = new Materia();
    Materia carga;
    ArrayList<Materia> materias = new ArrayList<Materia>(7);
    public Alumno(String nombre, String password, int matricula) {
        this.nombre = nombre;
        this.password = password;
        this.matricula = matricula;
        this.carga = cargaDefault;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setCarga(Materia carga) {
        this.carga = carga;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public Materia getCarga() {
        return carga;
    }

    public void addMateria(Materia materia){
        materias.add(materia);
    }
}
