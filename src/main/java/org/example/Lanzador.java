package org.example;

public class Lanzador {
    public static void mostrarMain() {
        Cuenta cuenta = new Cuenta(10000);

        // Crear hilos para cada tipo de transacción
        Thread[] hilos = new Thread[6];
        hilos[0] = new Thread(new HiloCliente(cuenta, 100, true, 400));
        hilos[1] = new Thread(new HiloCliente(cuenta, 50, true, 200));
        hilos[2] = new Thread(new HiloCliente(cuenta, 20, true, 600));
        hilos[3] = new Thread(new HiloCliente(cuenta, 100, false, 400));
        hilos[4] = new Thread(new HiloCliente(cuenta, 50, false, 200));
        hilos[5] = new Thread(new HiloCliente(cuenta, 20, false, 600));

        // Lanzar hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Verificar saldo final
        System.out.println("Saldo final: " + cuenta.getSaldo());
    }
}

