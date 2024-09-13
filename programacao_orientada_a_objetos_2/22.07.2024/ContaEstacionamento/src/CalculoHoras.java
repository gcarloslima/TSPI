import java.time.Duration;

public class CalculoHoras implements CalculoValor  {

    public Double calcularValor(Duration duracao, Veiculo veiculo) {
        
        if (veiculo instanceof Passeio) {
            long horas = duracao.toHours();
            return horas * 2.0;
        }

        return 0.0;
    }
}
