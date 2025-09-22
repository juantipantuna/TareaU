 // Programa: CalculoDescuento.java
 // Objetivo: Calcular descuentos en compras usando métodos con parámetros, retorno y sobrecarga.
 // Autor: Juan Tipantuña
 // Fecha: 21/07/2025

public class CalculoDescuento {

    // Método que calcula el descuento recibiendo montoTotal y porcentajeDescuento
    public static double calcularDescuento(double montoTotal, double porcentajeDescuento) {
        double descuento = montoTotal * (porcentajeDescuento / 100);
        return descuento;
    }

    // Método sobrecargado que aplica un 10% de descuento por defecto
    public static double calcularDescuento(double montoTotal) {
        return calcularDescuento(montoTotal, 10.0); // 10% por defecto
    }

    // Método main con las llamadas requeridas
    public static void main(String[] args) {
        double compra = 100.0;
        
        System.out.println("=== CÁLCULO DE DESCUENTOS ===");
        
        // Llamada 1: Usando solo el monto total (10% por defecto)
        double descuento1 = calcularDescuento(compra);
        double totalPagar1 = compra - descuento1;
        
        System.out.println("\n--- Llamada con 10% de descuento por defecto ---");
        System.out.println("Monto total: $" + compra);
        System.out.println("Descuento (10%): $" + descuento1);
        System.out.println("Total a pagar: $" + totalPagar1);
        
        // Llamada 2: Proporcionando explícitamente 15% de descuento
        double descuento2 = calcularDescuento(compra, 15.0);
        double totalPagar2 = compra - descuento2;
        
        System.out.println("\n--- Llamada con 15% de descuento explícito ---");
        System.out.println("Monto total: $" + compra);
        System.out.println("Descuento (15%): $" + descuento2);
        System.out.println("Total a pagar: $" + totalPagar2);
    }
}