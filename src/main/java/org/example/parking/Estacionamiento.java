package org.example.parking;

import java.io.Console;
import java.util.*;

public class Estacionamiento {
    private final int capacidadMaxima = 50;
    private final  Map<String, Ticket> vehiculosEstacionados = new HashMap<>();
    private final Map<String, Cliente> clientesRegistrados = new HashMap<>();

    public boolean ingresarVehiculo(String dni, String nombre, Vehiculo vehiculo) {
        // TODO implementar la logica para registrar el ingreso de un nuevo vehiculo en el parking
        // la capacidad maxima del estacionamiento es de 50 vehiculos, si supera esta cap[acidad retornar FALSE
        // validar que no exista otro vehiculo con la misma patente, es un caso de error, retornar FALSE
        // validar si existe el cliente registrado, agregar el nuevo vehiculo en la lista del cliente existente, caso contrario crear un nuevo registro
        // si el proceso es exitoso retornar TRUE

        if (listarVehiculosEstacionados().size() <= capacidadMaxima)
        {

            String patente = vehiculo.getPatente();

            if (listarVehiculosEstacionados().isEmpty()) {
                Cliente nuevoCliente = new Cliente(dni, nombre);
                nuevoCliente.agregarVehiculo(vehiculo);
                clientesRegistrados.put(dni, nuevoCliente);
                Ticket t = new Ticket(nuevoCliente, vehiculo);
                vehiculosEstacionados.put(vehiculo.getPatente(), t);
                return true;
            }

            for (Ticket t : listarVehiculosEstacionados()) {
                if (t.getVehiculo().getPatente().equals(patente)) {
                    return false;
                }
            }

            Cliente cliente = clientesRegistrados.get(dni);
            if (cliente == null) {
                cliente = new Cliente(dni, nombre);
                clientesRegistrados.put(dni, cliente);
            }

            cliente.agregarVehiculo(vehiculo);
            return true;

            }


        return false;
    }

    public Ticket retirarVehiculo(String patente) throws Exception {
        // TODO implementar la lógica para retirar un vehiculo del parking
        // validar que exista la patente, caso contrario arrojar la exception "Vehiculo no encontrado"
        // calcular y retornar el ticket del vehiculoEstacionado (ver Ticket.marcarSalida())
        for (Ticket t: listarVehiculosEstacionados()){
            if (t.getVehiculo().getPatente().equals(patente)){
                t.marcarSalida();
                t.calcularPrecio();
                vehiculosEstacionados.remove(t.getVehiculo().getPatente());
                return t;

            }
            else {
                throw new Exception("Vehiculo no encontrado");
            }
        }


        return null;
    }

    public List<Ticket> listarVehiculosEstacionados() {
        return new ArrayList<>(vehiculosEstacionados.values());
    }
}
