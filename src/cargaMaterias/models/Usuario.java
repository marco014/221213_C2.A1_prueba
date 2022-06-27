package cargaMaterias.models;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
    private ArrayList<Alumno> alum =  new ArrayList<Alumno>(1);
    private  String solicitud;
    public Usuario() {
        this.solicitud = "Nada que mostrar";
    }
    public void addAlumno(Alumno alumno){
        alum.add(alumno);
    }
    public int comprobarPassword(int matricula, String pass) {

        int posicion = -1;
        for (int i = 0; i < alum.size(); i++) {
            if (matricula == alum.get(i).getMatricula() && alum.get(i).getPassword().equals(pass)) {
                posicion = i;
            }
        }
        return posicion;
    }
    public String Bienvenida(int i){
        return "Hola, bienvenido " + alum.get(i).getNombre() + "\n" + "Que deseas realizar?" +
                "\n" + "(1)Carga de materias" + "\n" + "(2)Carga manual" + "\n" + "(3)Salir" ;
    }
    public Alumno getAlumno(int i){
        return alum.get(i);
    }
    public void Enviarsolicitud(int index){
        String nombreM = alum.get(index).getCarga().getNombreMateria();
        String grupo =alum.get(index).getCarga().getGrupo();
        String matricula = "" + alum.get(index).getMatricula();
        String solicitud = "";

        solicitud =  "solicitud de: " + "\n" + alum.get(index).getNombre() + "\n" + "matricula: " + matricula   + " id: " +
                index + "\n" + "Desea solicitar carga manual de " + nombreM+ " del grupo: " + grupo ;
        this.solicitud = solicitud;
    }
    public String getSolicitud(){
        return solicitud;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alum;
    }

    public int BuscarMatricula(int matricula){
        int indice = -1;
        int i = 0;
        boolean bandera = false;
        Iterator<Alumno> iterador =  getAlumnos().iterator();
        while (iterador.hasNext() && !bandera){
            if(iterador.next().getMatricula() == matricula){
                indice = i;
                bandera = true;
            }
            i++;
        }
        return indice;
    }
}
