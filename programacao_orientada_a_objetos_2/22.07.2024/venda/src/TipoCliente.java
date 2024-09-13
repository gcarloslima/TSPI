public enum TipoCliente {

    VIP(new DescontoClienteVIP()),
    REGULAR(new DescontoClienteRegular()),
    FUNCIONARIO(new DescontoFuncionario());

    private DescontoStrategy strategy;

    private TipoCliente(DescontoStrategy strategy) {
        this.strategy = strategy;
    }

    public DescontoStrategy getStrategy() {
        return strategy;
    }

}
