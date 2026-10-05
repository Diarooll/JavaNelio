package models.services;

public class TransportadoraService implements FreteService{
    @Override
    public double calcularFrete(double pesoKg) {
        double frete = 15 + (pesoKg * 5);
        return frete;
    }

    @Override
    public int prazo() {
        return 3;
    }
}
