public class ContaCorrente implements ContaEssencial, Tarifavel {

   private Agencia agencia;
   private String numeroConta;
   protected double saldo;
   private double limiteChequeEspecial;

   public ContaCorrente(Agencia agencia, String numeroConta, double saldo,
         double limiteChequeEspecial) {
      this.agencia = agencia;
      this.numeroConta = numeroConta;
      this.saldo = saldo;
      this.limiteChequeEspecial = limiteChequeEspecial;
   }

   @Override
   public void saque(Double valor) throws ContaException {
      if (valor > 0) {
         if (this.saldo + limiteChequeEspecial >= valor) {
            this.saldo -= valor;
         } else {
            throw new ContaException("Conta sem saldo suficiente: " + this.saldo);
         }
      } else {
         throw new ContaException("Valor inválido para saque: " + valor);
      }
   }

   @Override
   public void deposito(Double valor) throws ContaException {
      if (valor > 0) {
         this.saldo += valor;
      } else {
         throw new ContaException("Valor inválido para depósito: " + valor);
      }
   }

   public String getNumeroConta() {
      return numeroConta;
   }

   @Override
   public void cobrarTarifa(Double valorTarifa) throws ContaException {
      if (valorTarifa > 0) {
         if (this.saldo >= valorTarifa) {
            this.saldo -= valorTarifa;
         } else {
            throw new ContaException("Saldo insuficiente para cobrar a tarifa: " + this.saldo);
         }
      } else {
         throw new ContaException("Valor de tarifa inválido: " + valorTarifa);
      }
   }
}
