 // Universidad: Estatal Amazonica
 // Carrera: Tecnologia de la informacion 
 // Estudiante: Juan Tipantuña
 // Materia: Principios de Programación
 // Proyecto: Tienda Express
 // Fecha: 16 de septiembre deo 2025
//Url Vide: https://vm.tiktok.com/ZMAAK3xRK/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiendaExpress {
    
    // Método para mostrar el menú
    static void mostrarMenu() {
        System.out.println("\n=== TIENDA EXPRESS ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Ver carrito");
        System.out.println("3. Pagar");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    // Método para leer la opción del usuario
    static int leerOpcion(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }
    
    // Método para agregar producto al carrito
    static void agregarProducto(List<Double> carrito, double precio) {
        carrito.add(precio);
        System.out.println("Producto agregado: $" + precio);
    }
    
    // Método para calcular el total con impuestos
    static double total(double base, double imp) {
        return base + (base * imp);
    }
    
    // Método para validar correo electrónico
    static boolean validarCorreo(String correo) {
        return correo.contains("@") && correo.contains(".") && correo.length() > 5;
    }
    
    // Método para confirmar la compra
    static void confirmarCompra(String correo, double total) {
        System.out.println("\n=== COMPRA CONFIRMADA ===");
        System.out.println("Correo del cliente: " + correo);
        System.out.println("Total a pagar: $" + String.format("%.2f", total));
        System.out.println("Factura enviada a: " + correo);
        System.out.println("¡Gracias por su compra!");
    }
    
    // Método para procesar el pago
    static void pagar(List<Double> carrito, Scanner sc) {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío. Agregue productos primero.");
            return;
        }
        
        // Calcular subtotal
        double subtotal = 0;
        for (double precio : carrito) {
            subtotal += precio;
        }
        
        // Calcular total con impuestos (16%)
        double totalConImpuestos = total(subtotal, 0.16);
        
        System.out.println("\n=== RESUMEN DE COMPRA ===");
        System.out.println("Productos en carrito: " + carrito.size());
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Impuestos (16%): $" + String.format("%.2f", subtotal * 0.16));
        System.out.println("Total: $" + String.format("%.2f", totalConImpuestos));
        
        // Solicitar correo electrónico
        String correo;
        do {
            System.out.print("\nIngrese su correo electrónico para enviar la factura: ");
            correo = sc.nextLine();
            
            if (!validarCorreo(correo)) {
                System.out.println("Correo inválido. Intente nuevamente.");
            }
        } while (!validarCorreo(correo));
        
        // Confirmar compra
        confirmarCompra(correo, totalConImpuestos);
        carrito.clear(); // Vaciar carrito después de pagar
    }
    
    // Método para mostrar el carrito
    static void mostrarCarrito(List<Double> carrito) {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        
        System.out.println("\n=== CARRITO DE COMPRAS ===");
        for (int i = 0; i < carrito.size(); i++) {
            System.out.println("Producto " + (i + 1) + ": $" + carrito.get(i));
        }
        
        double subtotal = 0;
        for (double precio : carrito) {
            subtotal += precio;
        }
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
    }
    
    // Método principal que orquesta el programa
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> carrito = new ArrayList<>();
        int opcion;
        
        System.out.println("Bienvenido a Tienda Express!");
        
        do {
            mostrarMenu();
            opcion = leerOpcion(sc);
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el precio del producto: $");
                    try {
                        double precio = Double.parseDouble(sc.nextLine());
                        if (precio > 0) {
                            agregarProducto(carrito, precio);
                        } else {
                            System.out.println("El precio debe ser mayor a 0.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Precio inválido. Intente nuevamente.");
                    }
                    break;
                    
                case 2:
                    mostrarCarrito(carrito);
                    break;
                    
                case 3:
                    pagar(carrito, sc);
                    break;
                    
                case 4:
                    System.out.println("Gracias por visitar Tienda Express. ¡Hasta pronto!");
                    break;
                    
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            
        } while (opcion != 4);
        
        sc.close();
    }
}
