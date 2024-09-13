package br.edu.iftm.tspi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.edu.iftm.tspi.dao.ContaDao;
import br.edu.iftm.tspi.domain.Cliente;
import br.edu.iftm.tspi.domain.Conta;

public class ProcessaLinhasConta {

    private List<String> lines;

    private ContaDao contaDao;

    private Integer lote;

    public ProcessaLinhasConta(List<String> lines) {
        this.lines = lines;
        contaDao = new ContaDao();
    }

    public void processa() throws Exception {
        for (String linha: lines) {
            String opcao = linha.substring(0, 1);
            if (opcao.equals("2")) {
                processaDetalhe(linha);
            } else if (opcao.equals("1")) {
                processaCabecalho(linha);
            } else {
                throw new Exception("Desconheço essa opção de processar a linha: "+opcao);
            }
        }
        contaDao.salvarLote(lote);
    }

    private void processaCabecalho(String linha) throws Exception {
        Integer lote = Integer.parseInt(linha.substring( 1, 4));
        Integer loteBanco = contaDao.getUltimoLote();
        Integer loteEsperado = loteBanco + 1;
        if (!lote.equals(loteEsperado)) {
            throw new Exception("Lote recebido: "+lote+ 
                                "diferente do lote esperado:"+loteEsperado);
        }
        this.lote = lote;
    }

    private void processaDetalhe(String linha) throws Exception {
        Conta conta = getConta(linha);
        contaDao.persistir(conta);
    }

    private Conta getConta(String linha) throws ParseException {
        Conta conta = new Conta();
        conta.setInclusaoAlteracao(linha.substring(1,2));
        
        String cpf = linha.substring(2,13);
        String valorLimite = linha.substring(13,25).trim();
        String diaVencimento = linha.substring(25,27).trim();
        String numeroConta = linha.substring(27,34).trim();
        
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        conta.setCliente(cliente);
        conta.setNumero(numeroConta);
        conta.setDiaVencimento(Integer.valueOf(diaVencimento));
        Double valorLimiteDouble = Double.parseDouble(valorLimite) / 100;
        conta.setValorLimite(valorLimiteDouble);
        return conta;
    }

}
