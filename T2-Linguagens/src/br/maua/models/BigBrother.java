package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;

public class BigBrother extends Membro{
    private final String assinaturaRegular = "Sempre ajudando as pessoas membros ou não S2!";
    private final String assinaturaExtra = "...";
    private final TipoDeMembro tipoDeMembro = TipoDeMembro.BIGBROTHER;

    /**
     * Construtor da classe
     * @param nome nome do membro
     * @param email email do membro
     */
    public BigBrother(String nome, String email) {
        super(nome, email);
    }

    /**
     * Metodo para postar mensagem
     * @param mensagem mensagem a ser postada
     * @param hora hora em que esta sendo postada
     */
    @Override
    public void postarMensagem(String mensagem, HorarioDeAtividade hora){
        if(hora == HorarioDeAtividade.EXTRA)
            System.out.printf(mensagem + "\n" + this.assinaturaExtra);
        else
            System.out.printf(mensagem + "\n" + this.assinaturaRegular);
    }

    /**
     * Apresentacao do membro
     */
    @Override
    public void apresentar(){
        System.out.println("Nome:" + this.getNome());
        System.out.println("Email:" + this.getEmail());
        System.out.println("Tipo: Big Brother");
        System.out.println("------------------------------------");
    }
}
