package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;

public class HeavyLifter extends Membro{
    private final String assinaturaRegular = "Podem contar conosco!";
    private final String assinaturaExtra = "N00b_qu3_n_Se_r3pita.bat";
    private final TipoDeMembro tipoDeMembro = TipoDeMembro.HEAVYLIFTER;

    /**
     * Construtor da classe
     * @param nome nome do membro
     * @param email email do membro
     */
    public HeavyLifter(String nome, String email) {
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
        System.out.println("Tipo: Heavy Lifter");
        System.out.println("------------------------------------");
    }
}
