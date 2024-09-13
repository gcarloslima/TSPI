public class App {
    public static void main(String[] args) throws Exception {

        double consumo = 1000.00;
        TipoCliente tipoCliente = TipoCliente.VIP;

        CalculadoraDescontos calculadoraDescontos = new CalculadoraDescontos(consumo);

        calculadoraDescontos.setDescontoStrategy(tipoCliente.getStrategy());

        // switch ("Funcionario") {
        //     case "VIP":
        //         calculadoraDescontos.setDescontoStrategy(new DescontoClienteVIP());
        //         break;
        //     case "Regular":
        //         calculadoraDescontos.setDescontoStrategy(new DescontoClienteRegular());
        //         break;
        //     case "Funcionario":
        //         calculadoraDescontos.setDescontoStrategy(new DescontoFuncionario());
        //         break;
        // }

        System.out.printf("O desconto é de R$ %.2f", calculadoraDescontos.calcularDesconto());
    }
}
