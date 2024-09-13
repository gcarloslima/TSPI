import java.time.Duration;

public class CalculoMensal implements CalculoValor {

    public Double calcularValor(Duration duracao, Veiculo veiculo) {

        if (veiculo instanceof Passeio) {
            long horas = duracao.toHours();
            long dias = horas / 24;
            long meses = dias / 30;

            meses = meses + ((dias % 30 == 0) ? 0 : 1);
            return meses * 300.0;
        }

        return 0.0;
    }
}
