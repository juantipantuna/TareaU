public class RegistroTemperaturas {
    
    public static void main(String[] args) {
       
        String[] ciudades = {"Madrid", "Barcelona"};
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        String[] semanas = {"Semana1", "Semana2"};

        // Creamos la matriz 3D (Ciudad, dia y semana)
        double[][][] temperaturas = new double[ciudades.length][dias.length][semanas.length];

        // Llenamos la matriz
        for (int ciudad = 0; ciudad < ciudades.length; ciudad++) {
            for (int dia = 0; dia < dias.length; dia++) {
                for (int semana = 0; semana < semanas.length; semana++) {
                    // Math.random() genera numero entre 0 y 1
                    temperaturas[ciudad][dia][semana] = 15 + Math.random() * 20;
                }
            }
        }

        // Paso 4. Mostrar todas las temperaturas
        System.out.println("===TEMPERATURAS REGISTRADAS ===");
        for (int ciudad = 0; ciudad < ciudades.length; ciudad++) {
            System.out.println("\n" + ciudades[ciudad] + ":");
            for (int semana = 0; semana < semanas.length; semana++) {
                System.out.println(" " + semanas[semana] + ":");
                for (int dia = 0; dia < dias.length; dia++) {
                    // %.1f = muestra un decimal después del punto
                    System.out.printf("    %s: %.1fºC\n", dias[dia], temperaturas[ciudad][dia][semana]);
                }
            } 
        }

        // Paso 5: Calcular los promedios
        System.out.println("\n===TEMPERATURAS PROMEDIO ===");

        for (int ciudad = 0; ciudad < ciudades.length; ciudad++) {   
            System.out.println("\n" + ciudades[ciudad] + ":");
            for (int semana = 0; semana < semanas.length; semana++) {
                double suma = 0; // Empezamos con suma en 0

                // Sumamos todas las temperaturas de la semana
                for (int dia = 0; dia < dias.length; dia++) {
                    suma += temperaturas[ciudad][dia][semana];
                }

                // Promedio = suma total / numero de dias
                double promedio = suma / dias.length;
                System.out.printf("  %s: %.1fºC\n", semanas[semana], promedio);
            }
        }
    } 
}
