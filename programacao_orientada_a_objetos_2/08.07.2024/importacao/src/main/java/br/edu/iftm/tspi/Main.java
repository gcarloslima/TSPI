package br.edu.iftm.tspi;

import br.edu.iftm.tspi.service.ProcessaArquivosCliente;

public class Main {

    public static void main(String[] args) throws Exception {
        ProcessaArquivosCliente arquivosCliente = new ProcessaArquivosCliente();
        arquivosCliente.processaCliente();
    }

}