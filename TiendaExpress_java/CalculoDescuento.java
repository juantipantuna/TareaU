/**
 * Programa: CalculoDescuento.java
 * Objetivo: Calcular descuentos en compras usando métodos con parámetros, retorno y sobrecarga.
 * Autor: Juan Tipantuña
 * Fecha: 21/09/2025
 */

public class CalculoDescuento {

    // Método que calcula el descuento recibiendo montoTotal y porcentajeDescuento
    public static double calcularDescuento(double montoTotal, double porcentajeDescuento) {
        double descuento = montoTotal * (porcentajeDescuento / 100);
        return descuento;
    }

    // Método sobrecargado que aplica un 10% de descuento por defecto
    public static double calcularDescuento(double montoTotal) {
        return calcularDescuento(montoTotal, 10.0); // Reutiliza el método anterior con 10%
    }

    public static void main(String[] args) {
        double montoCompra = 1000.0; // Ejemplo: monto de compra

        // Llamada 1: Usando el método sobrecargado (10% por defecto)
        double descuento1 = calcularDescuento(montoCompra);
        double totalPagar1 = montoCompra - descuento1;

        System.out.println("--- Descuento del 10% (por defecto) ---");
        System.out.println("Monto de compra: $" + montoCompra);
        System.out.println("Descuento aplicado: $" + descuento1);
        System.out.println("Total a pagar: $" + totalPagar1);
        System.out.println();

        // Llamada 2: Proporcionando explícitamente 15% de descuento
        double porcentajePersonalizado = 15.0;
        double descuento2 = calcularDescuento(montoCompra, porcentajePersonalizado);
        double totalPagar2 = montoCompra - descuento2;

        System.out.println("--- Descuento del " + porcentajePersonalizado + "% ---");
        System.out.println("Monto de compra: $" + montoCompra);
        System.out.println("Descuento aplicado: $" + descuento2);
        System.out.println("Total a pagar: $" + totalPagar2);
    }
}