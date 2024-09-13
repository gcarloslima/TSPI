
public class ClienteJuridico extends Cliente {
    public ClienteJuridico(String nome) {
        super(nome);
    }

    @Override
    public double aplicarDesconto(double precoBase) {
        return precoBase * 0.8;
    }
}