public class CalculadoraDescontos {

    private double consumo;

    private DescontoStrategy descontoStrategy;

    public CalculadoraDescontos(double consumo) {
        this.consumo = consumo;
    }

    public void setDescontoStrategy(DescontoStrategy descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }

    public double calcularDesconto() {
        return descontoStrategy.calcularDesconto(consumo);
    }

}