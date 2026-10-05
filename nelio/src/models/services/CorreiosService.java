package models.services;

public class CorreiosService implements FreteService{
    @Override
    public double calcularFrete(double pesoKg) {
        double frete = pesoKg * 8;
        return frete;
    }

    @Override
    public int prazo() {
        return 7;
    }
}
