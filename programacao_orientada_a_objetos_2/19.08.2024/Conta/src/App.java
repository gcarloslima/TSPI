public class App {
    public static void main(String[] args) throws Exception {
        Agencia caixaLuizote = new Agencia("025-08");
        ContaCorrente contaCorrente = new ContaCorrente(caixaLuizote, "1164-9", 500d, 1000);
        ContaPoupanca contaPoupanca = new ContaPoupanca(caixaLuizote, "1324-9", 700d);
        ContaSalario contaSalario = new ContaSalario(caixaLuizote, "1456-2", 1200d);
        
        caixaLuizote.addContaEssencial(contaCorrente);
        caixaLuizote.addContaEssencial(contaPoupanca);
        caixaLuizote.addContaRentavel(contaPoupanca);
        caixaLuizote.addContaEssencial(contaSalario);

        caixaLuizote.saque("1164-9", 1200);
        caixaLuizote.saque("1324-9", 1000);
        caixaLuizote.atualizaRendimentoContas(0.05);
        caixaLuizote.cobrarTarifaContas(15.0);
    }
}
