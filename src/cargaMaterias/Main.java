package cargaMaterias;

import cargaMaterias.models.Alumno;
import cargaMaterias.models.Materia;
import cargaMaterias.models.Usuario;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static Usuario usuar = new Usuario();
    static Scanner teclado = new Scanner(System.in);
    private static Materia asignarMateria;

    public static void main(String[] args) {
        Alumno alum;
        usuar.addAlumno(alum = new Alumno("Francisco", "00001", 221201));
        usuar.addAlumno(alum = new Alumno("Joanna", "00002", 221202));
        usuar.addAlumno(alum = new Alumno("Yuliza", "00003", 221203));
        usuar.addAlumno(alum = new Alumno("Edgar", "0004", 221204));
        usuar.addAlumno(alum = new Alumno("Jose", "0005", 221205));
        int opcion;
        do {
            System.out.println("Como desea ingresar?");
            System.out.println("1. ALUMNO");
            System.out.println("2. DOCENTE");
            System.out.println("3. SALIR");
            opcion = teclado.nextByte();
            switch (opcion){
                case 1:
                    loginAlumno(asignarMateria);
                    break;
                case 2:
                    loginDocente();
                    break;
                case 3:
                    System.out.println("Que tenga un buen dia Diana.");
                    break;
            }
        } while (opcion!=3);
    }
    public static void loginAlumno(Materia asignarMateria){
        int matricula, index;
        String password, grupo;
        byte cargaMateria;
        Materia materia;

        System.out.println("Ingrese sus datos");
        System.out.println("Matricula: ");
        matricula = teclado.nextInt();
        System.out.println("Contraseña: ");
        password = teclado.next();
        while (usuar.comprobarPassword(matricula, password) != -1){
            index = usuar.comprobarPassword(matricula,password);
            do {
                System.out.println(usuar.Bienvenida(index));
                matricula = teclado.nextInt();
                while (matricula == 1) {
                    if (usuar.getAlumno(index).getMaterias().isEmpty()) {
                        do {
                            System.out.println("Cuantas materias desea cargar?");
                            cargaMateria = teclado.nextByte();
                            if (cargaMateria > 7)
                                System.out.println("Esa cantida no esta permitida. （ﾉ´д｀）");
                        } while (cargaMateria > 7);
                        for (int i= 0; i<cargaMateria; i++){
                            usuar.getAlumno(index).addMateria(asignarMateria());
                        }
                        System.out.println("Materias cargadas recientemente");
                        Iterator<Materia> iterator = usuar.getAlumno(index).getMaterias().iterator();
                        while (iterator.hasNext()){
                            materia = iterator.next();
                            System.out.println(materia.getNombreMateria() + "   " + materia.getGrupo());
                        }
                    }else {
                        System.out.println("Ya has cargado materias recientemente. ");
                    }
                }

                while (matricula == 2){
                    System.out.println("Que materias desea cargar manualmente?");
                    usuar.getAlumno(index).setCarga(asignarMateria);
                    System.out.println("Solicitud enviada");
                    usuar.Enviarsolicitud(index);
                }
            } while (matricula != 3);
        }
    }

    public static Materia asignarMateria(){
        System.out.println("Nombre de la materia: ");
        String materia = teclado.next();
        System.out.println("Grupo: ");
        String grupo = teclado.next();
        Materia mate1 = new Materia(materia, grupo);
        return mate1;
    }

    public static void loginDocente(){
        int matricula, acceder = 221200;
        String pass, password1 = "12345";
        byte opcion;
        Materia materia;
        System.out.println("Ingrese sus datos");
        System.out.println("Clave: ");
        matricula = teclado.nextInt();
        System.out.println("Matricula: ");
        pass = teclado.next();

        while (pass.equals(password1) && acceder == matricula){
            do {
                System.out.println("Bienvenida Diana");
                System.out.println("Que desea realizar?");
                System.out.println("1. Solicitudes de cara manual");
                System.out.println("2. Buscar matricula y visulizar materias");
                System.out.println("3. Salir");
                opcion = teclado.nextByte();
                while (opcion == 1){
                    System.out.println(usuar.getSolicitud());
                }
                while (opcion == 2){
                    System.out.println("Ingrese la matricula: ");
                    matricula = teclado.nextInt();
                    acceder = usuar.BuscarMatricula(matricula);
                    if (acceder == -1){
                        System.out.println("Materias");
                        Iterator<Materia> iterator = usuar.getAlumno(acceder).getMaterias().iterator();
                        while (iterator.hasNext()){
                            materia = iterator.next();
                            System.out.println(materia.getNombreMateria() + "  " + materia.getGrupo());
                        }
                    }
                }
            } while (opcion !=3);
        }

    }

}
