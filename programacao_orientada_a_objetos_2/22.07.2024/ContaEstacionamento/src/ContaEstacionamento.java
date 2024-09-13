import java.time.Duration;
import java.time.LocalDateTime;

public class ContaEstacionamento {

    private Veiculo veiculo;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    private CalculoValor calculoValor;

    public ContaEstacionamento(LocalDateTime inicio,LocalDateTime fim,Veiculo veiculo) {
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
    }

    public void setCalculoValor(CalculoValor calculoValor) {
        this.calculoValor = calculoValor;
    }

    public Double valorConta() {
        Duration duracao = Duration.between(inicio, fim);
        
        return calculoValor.calcularValor(duracao, veiculo); 
    }
    
}
