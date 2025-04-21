package uy.edu.ucu.aed.tdas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class PilaConArregloTest {

    private IPila<Integer> pilaEnteros;
    private IPila<String> pilaStrings;

    @BeforeEach
    void setUp() {
        pilaEnteros = new PilaConArreglo<>(10);
        pilaStrings = new PilaConArreglo<>(10);
    }


    @Test
    public void testPilaVaciaAlInicio() {
        assertTrue(pilaEnteros.esVacia());
    }

    @Test
    public void testapilarYtope() {
        pilaStrings.apilar("Hola");
        pilaStrings.apilar("Mundo");
        assertEquals("Mundo", pilaStrings.tope());
    }

    @Test
    public void testdesapilar() {
        pilaEnteros.apilar(10);
        pilaEnteros.apilar(20);
        pilaEnteros.desapilar(); // Quita 20
        assertEquals(10, pilaEnteros.tope());
    }

    @Test
    public void testanular() {
        pilaEnteros.apilar(1);
        pilaEnteros.apilar(2);
        pilaEnteros.anular();
        assertTrue(pilaEnteros.esVacia());
        assertThrows(IllegalStateException.class, () -> pilaEnteros.tope());
    }

    @Test
    public void testtopeEnPilaVaciaLanzaExcepcion() {
        IPila<Double> pila = new PilaConArreglo<>(0);
        assertThrows(IllegalStateException.class, () -> pila.tope());
    }

    @Test
    public void testdesapilarEnPilaVaciaLanzaExcepcion() {
        IPila<Double> pila = new PilaConArreglo<>(0);
        assertThrows(IllegalStateException.class, () -> pila.tope());
    }

    @Test
    public void testCrecimientoDinamico() {
        IPila<Integer> pila = new PilaConArreglo<>(2); // Tamaño inicial chico
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3); // Esto debería forzar el crecimiento

        assertEquals(3, pila.tope());
        pila.desapilar();
        assertEquals(2, pila.tope());
    }
}
