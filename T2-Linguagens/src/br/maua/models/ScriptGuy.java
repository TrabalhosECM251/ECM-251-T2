package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;

public class ScriptGuy extends Membro{
    private final String assinaturaRegular = "Prazer em ajudar novos amigos de código!";
    private final String assinaturaExtra = "QU3Ro_S3us_r3curs0s.py";
    private final TipoDeMembro tipoDeMembro = TipoDeMembro.SCRIPTGUY;

    /**
     * Construtor da classe
     * @param nome nome do membro
     * @param email email do membro
     */
    public ScriptGuy(String nome, String email) {
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
        System.out.println("Tipo: Script Guy");
        System.out.println("------------------------------------");
    }
}
