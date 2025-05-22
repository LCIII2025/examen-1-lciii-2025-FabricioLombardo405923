package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    Estacionamiento estacionamiento = new Estacionamiento();

    @Test
    public void testRetirarVehiculo() throws Exception {
        Vehiculo resultado = new Vehiculo("asf300", "Tesla", Vehiculo.Tipo.AUTO);
        boolean bol=  estacionamiento.ingresarVehiculo("300", "Fabri", resultado);
        Ticket t= estacionamiento.retirarVehiculo(resultado.getPatente());
        assertTrue(bol);
        assertEquals(t.getVehiculo(), resultado);
        //TODO test

    }

    @Test
    public void testCalcularPrecio() throws Exception {
        Vehiculo vehiculo = new Vehiculo("asf300", "Tesla", Vehiculo.Tipo.AUTO);
        estacionamiento.ingresarVehiculo("300", "Fabri", vehiculo);
        Ticket t= estacionamiento.retirarVehiculo(vehiculo.getPatente());
         double calculo= t.calcularPrecio();
         double precio1 = 100;
         double precio2 = 200;
        assertEquals(calculo,precio1);
        assertEquals(calculo, precio2);
        // TODO test
    }

}