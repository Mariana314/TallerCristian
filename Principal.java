import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        class Alumno {
        	
            String nombreAlumno;
            ArrayList<Double> calificaciones;
            double promedioNotas;

            Alumno(String nombreAlumno, Double... calificaciones) {
                this.nombreAlumno = nombreAlumno;
                this.calificaciones = new ArrayList<>(Arrays.asList(calificaciones));
                calcularPromedioNotas();
            }

            void calcularPromedioNotas() {
                this.promedioNotas = calificaciones.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            }
        }

        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        listaAlumnos.add(new Alumno("Juan", 3.5, 4.0, 3.8));
        listaAlumnos.add(new Alumno("Mariana", 4.2, 3.9, 4.5));
        listaAlumnos.add(new Alumno("David", 2.8, 3.1, 2.9));
        listaAlumnos.add(new Alumno("Stiven", 4.8, 4.9, 4.7));
        listaAlumnos.add(new Alumno("Ana", 1.5, 2.0, 1.8));

        System.out.println("Número total de alumnos: " + listaAlumnos.size());
        System.out.println("Número total de calificaciones ingresadas: " + (listaAlumnos.size() * 3));

        int aprueban = 0, reprueban = 0, puedenRecuperar = 0, noRecuperables = 0;
        double sumaPromediosNotas = 0;

        for (Alumno alumno : listaAlumnos) {
            if (alumno.promedioNotas >= 3.5) {
                aprueban++;
            } else {
                reprueban++;
                if (alumno.promedioNotas > 2) {
                    puedenRecuperar++;
                } else {
                    noRecuperables++;
                }
            }
            sumaPromediosNotas += alumno.promedioNotas;
        }

        System.out.println("Número de alumnos que aprueban: " + aprueban);
        System.out.println("Número de alumnos que reprueban: " + reprueban);
        System.out.println("Número de alumnos que pueden recuperar: " + puedenRecuperar);
        System.out.println("Número de alumnos que no son recuperables: " + noRecuperables);
        System.out.println("Promedio general de las calificaciones: " + (sumaPromediosNotas / listaAlumnos.size()));

        System.out.println("\nLista de alumnos y sus promedios finales:");
        for (Alumno alumno : listaAlumnos) {
            System.out.printf("%s: %.2f%n", alumno.nombreAlumno, alumno.promedioNotas);
        }
    }
}
