package org.example;

public class HiloCliente implements Runnable {
    private Cuenta cuenta;
    private double monto;
    private boolean esDeposito;
    private int veces;

    public HiloCliente(Cuenta cuenta, double monto, boolean esDeposito, int veces) {
        this.cuenta = cuenta;
        this.monto = monto;
        this.esDeposito = esDeposito;
        this.veces = veces;
    }

    @Override
    public void run() {
        for (int i = 0; i < veces; i++) {
            if (esDeposito) {
                cuenta.depositar(monto);
            } else {
                cuenta.retirar(monto);
            }
        }
    }
}

