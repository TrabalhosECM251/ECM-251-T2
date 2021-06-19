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
     * @param id id do membro
     */
    public HeavyLifter(String nome, String email, int id) {
        super(nome, email, id);
    }

    /**
     * Metodo para postar mensagem
     * @param mensagem mensagem a ser postada
     * @param hora hora em que esta sendo postada
     * @return Mensagem assinada
     */
    @Override
    public String postarMensagem(String mensagem, HorarioDeAtividade hora){
        if(hora == HorarioDeAtividade.EXTRA)
            return (mensagem + "\n" + this.assinaturaExtra);
        else
            return (mensagem + "\n" + this.assinaturaRegular);
    }

    /**
     * Apresentacao do membro
     * @return texto de apresentacao
     */
    @Override
    public String apresentar(){
        return ("Nome:" + this.getNome() + "\n" +
                "Email:" + this.getEmail() + "\n" +
                "Tipo: Heavy Lifter\n" +
                "------------------------------------\n");
    }
}
