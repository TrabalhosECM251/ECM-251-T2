package br.maua;

import br.maua.models.Sistema;

/**
 * Classe para executar o sistema
 * @author Renan Scheidt Reschke RA: 19.02009-0
 * @author Felipe Freitas Villani RA: 19.01370-0
 * @version JDK 15
 */
public class Main {

    public static void main(String[] args) {
        //Cria uma instancia do sistema
        Sistema sistema = new Sistema();
        //Tenta iniciar o sistema
        try {
            sistema.iniciar();
        }
        //Caso algum erro ocorra na inicializacao
        catch (Exception e){
            System.out.println("Ocorreu algum erro");
        }
    }
}
