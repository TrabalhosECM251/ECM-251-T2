package br.maua;

import br.maua.models.Sistema;

public class Main {

    public static void main(String[] args) {
	//F7 Passou por aqui
        Sistema sistema = new Sistema();
        try {
            sistema.iniciar();
        }
        catch (Exception e){
            System.out.printf("Falha na inicializacao");
        }
    }
}
