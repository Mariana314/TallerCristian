import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Principal2 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Double>> estudiantesCalificaciones = new HashMap<>();
        HashMap<String, Double> estudiantesPromedios = new HashMap<>();

        estudiantesCalificaciones.put("Juan", new ArrayList<>(Arrays.asList(3.5, 4.0, 3.8)));
        estudiantesCalificaciones.put("Mariana", new ArrayList<>(Arrays.asList(4.2, 3.9, 4.5)));
        estudiantesCalificaciones.put("David", new ArrayList<>(Arrays.asList(2.8, 3.1, 2.9)));
        estudiantesCalificaciones.put("Stivem", new ArrayList<>(Arrays.asList(4.8, 4.9, 4.7)));
        estudiantesCalificaciones.put("Ana", new ArrayList<>(Arrays.asList(1.5, 2.0, 1.8)));

        for (String estudianteNombre : estudiantesCalificaciones.keySet()) {
            ArrayList<Double> calificaciones = estudiantesCalificaciones.get(estudianteNombre);
            double promedio = calificaciones.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            estudiantesPromedios.put(estudianteNombre, promedio);
        }

        System.out.println("Cantidad total de estudiantes: " + estudiantesCalificaciones.size());
        System.out.println("Cantidad total de calificaciones ingresadas: " + (estudiantesCalificaciones.size() * 3));

        int estudiantesGanan = 0, estudiantesPierden = 0, estudiantesRecuperan = 0, estudiantesPierdenSinRecuperacion = 0;
        double sumaPromedios = 0;

        for (Double promedio : estudiantesPromedios.values()) {
            if (promedio >= 3.5) {
                estudiantesGanan++;
            } else {
                estudiantesPierden++;
                if (promedio > 2) {
                    estudiantesRecuperan++;
                } else {
                    estudiantesPierdenSinRecuperacion++;
                }
            }
            sumaPromedios += promedio;
        }

        System.out.println("Cantidad de estudiantes que ganan la materia: " + estudiantesGanan);
        System.out.println("Cantidad de estudiantes que pierden la materia: " + estudiantesPierden);
        System.out.println("Cantidad de estudiantes que pueden recuperar: " + estudiantesRecuperan);
        System.out.println("Cantidad de estudiantes que pierden sin recuperación: " + estudiantesPierdenSinRecuperacion);
        System.out.println("Promedio de las notas finales obtenidas: " + (sumaPromedios / estudiantesPromedios.size()));

        System.out.println("\nListado de estudiantes y sus notas finales:");
        for (String estudianteNombre : estudiantesPromedios.keySet()) {
            System.out.printf("%s: %.2f%n", estudianteNombre, estudiantesPromedios.get(estudianteNombre));
        }
    }
}