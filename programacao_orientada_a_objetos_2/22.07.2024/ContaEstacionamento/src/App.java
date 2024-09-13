import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws Exception {
        LocalDateTime inicio = LocalDateTime.of(2024, 7, 1, 14, 30);
        LocalDateTime fim = LocalDateTime.of(2024, 7, 2, 10, 30);
        Veiculo v = new Passeio();
        ContaEstacionamento conta = new ContaEstacionamento(inicio,fim, v);
        conta.setCalculoValor(new CalculoMensal());
        System.out.println(conta.valorConta());
    }
}
