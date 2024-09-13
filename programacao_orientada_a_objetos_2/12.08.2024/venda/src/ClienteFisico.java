public class ClienteFisico extends Cliente {
    public ClienteFisico(String nome) {
        super(nome);
    }

    @Override
    public double aplicarDesconto(double precoBase) {
        return precoBase * 0.9;
    }
}