import java.time.Duration;

public class CalculoDiaria implements CalculoValor {

    public Double calcularValor(Duration duracao, Veiculo veiculo) {

        if (veiculo instanceof Passeio) {
            long horas = duracao.toHours();
            long dias = horas / 24;
            
            dias = dias + ((horas % 24 == 0) ? 0 : 1);
            return dias * 26.0;
        }

        return 0.0;
    }
}
