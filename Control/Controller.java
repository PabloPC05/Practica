package simulator.Control;

// import the correct Factory interface
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Event;
import simulator.model.TrafficSimObserver;
import simulator.model.TrafficSimulator;

public class Controller {

    TrafficSimulator trafficSimulator;
    Factory<Event> eventsFactory;

    // Constructor
    public Controller(TrafficSimulator sim, Factory<Event> eventsFactory) {
        // Revisar si sim y eventsFactory son nulos
        if (sim == null || eventsFactory == null) {
            throw new IllegalArgumentException("El simulador y la factoría de eventos no pueden ser nulos");
        }
        this.trafficSimulator = sim;
        this.eventsFactory = eventsFactory;
    }

    // Función para cargar eventos
    public void loadEvents(InputStream in) {
        // Revisar si in es nulo
        if (in == null) {
            throw new IllegalArgumentException("El fichero de eventos no puede ser nulo");
        }
        try {
            JSONObject jsonInput = new JSONObject(new JSONTokener(in));
            List<Event> events = new ArrayList<>();
            JSONArray listaEventos = jsonInput.getJSONArray("events");
            for (int i = 0; i < listaEventos.length(); i++) {
                events.add(eventsFactory.create_instance(listaEventos.getJSONObject(i)));
            }
            trafficSimulator.addEvents(events);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al cargar los eventos");
        }
    }

    // Función para ejecutar n pasos de la simulación
    public void run(int n, OutputStream out) {
        // Revisar si out es nulo
        if (out == null) {
            throw new IllegalArgumentException("El fichero de salida no puede ser nulo");
        }
        try {
            // Creamos los JSON
            JSONObject jsonOutput = new JSONObject();
            JSONArray listaEstados = new JSONArray();
            // Avanzamos n pasos guardando los estados en cada paso
            for (int i = 0; i < n; i++) {
                trafficSimulator.advance();
                listaEstados.put(trafficSimulator.report());
            }
            // Escribimos el JSON con los estados en el fichero de salida
            jsonOutput.put("states", listaEstados);
            out.write(jsonOutput.toString().getBytes());
            out.flush(); // Nos aseguramos de que todos los datos se han escrito
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al ejecutar los pasos");
        }
    }

    // Método para añadir un observador
    public void addObserver(TrafficSimObserver o) {
        trafficSimulator.addObserver(o);
    }

    // Método para eliminar un observador
    public void removeObserver(TrafficSimObserver o) {
        trafficSimulator.removeObserver(o);
    }

    // Método para añadir un evento
    public void addEvent(Event e) {
        trafficSimulator.addEvent(e);
    }

    // Método para ejecutar n pasos de la simulación sin salida
    public void run(int n) {
        for (int i = 0; i < n; i++) {
            trafficSimulator.advance();
        }
    }
}
