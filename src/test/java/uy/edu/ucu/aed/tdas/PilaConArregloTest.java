package uy.edu.ucu.aed.tdas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class PilaConArregloTest {

    private PilaConArreglo<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new PilaConArreglo<>(10);
    }


    @Test
    public void testPilaVaciaAlInicio() {
        IPila<Integer> pila = new PilaConArreglo<>(10);
        assertTrue(pila.EsVacia());
    }

    @Test
    public void testMeteYTope() {
        IPila<String> pila = new PilaConArreglo<>(10);
        pila.Mete("Hola");
        pila.Mete("Mundo");
        assertEquals("Mundo", pila.Tope());
    }

    @Test
    public void testSaca() {
        IPila<Integer> pila = new PilaConArreglo<>(10);
        pila.Mete(10);
        pila.Mete(20);
        pila.Saca(); // Quita 20
        assertEquals(10, pila.Tope());
    }

    @Test
    public void testAnula() {
        IPila<Integer> pila = new PilaConArreglo<>(10);
        pila.Mete(1);
        pila.Mete(2);
        pila.Anula();
        assertTrue(pila.EsVacia());
        assertThrows(IllegalStateException.class, () -> pila.Tope());
    }

    @Test
    public void testTopeEnPilaVaciaLanzaExcepcion() {
        IPila<Double> pila = new PilaConArreglo<>(0);
        assertThrows(IllegalStateException.class, () -> pila.Tope());
    }

    @Test
    public void testSacaEnPilaVaciaLanzaExcepcion() {
        IPila<Double> pila = new PilaConArreglo<>(0);
        assertThrows(IllegalStateException.class, () -> pila.Tope());
    }

    @Test
    public void testCrecimientoDinamico() {
        IPila<Integer> pila = new PilaConArreglo<>(2); // Tamaño inicial chico
        pila.Mete(1);
        pila.Mete(2);
        pila.Mete(3); // Esto debería forzar el crecimiento

        assertEquals(3, pila.Tope());
        pila.Saca();
        assertEquals(2, pila.Tope());
    }
}
