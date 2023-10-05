package org.example;

public class Cuenta {
    private double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Métodos sincronizados para evitar condiciones de carrera
    public synchronized void depositar(double monto) {
        saldo += monto;
    }

    public synchronized void retirar(double monto) {
        saldo -= monto;
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}

