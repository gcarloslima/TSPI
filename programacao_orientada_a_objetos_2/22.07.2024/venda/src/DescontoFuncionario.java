public class DescontoFuncionario implements DescontoStrategy {
    
    public double calcularDesconto(double consumo) {
        return consumo * 0.30;
    }

}
