public class Produto {
    private String nome;
    private double precoBase;

    public Produto(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public double aplicarImposto(double preco) {
        return preco * 1.1;
    }

    public double aplicarTaxaAdicional(double preco) {
        return preco + 50;
    }

    public double calcularPrecoFinal(Cliente cliente) {
        double precoComDesconto = cliente.aplicarDesconto(precoBase);
        double precoComImposto = aplicarImposto(precoComDesconto);
        double precoFinal = aplicarTaxaAdicional(precoComImposto);

        return Math.max(precoFinal, 0);
    }
}

