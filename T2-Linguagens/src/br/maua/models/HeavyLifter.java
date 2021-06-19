package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;

/**
 * Classe para representar membros Heavy Lifter
 */
public class HeavyLifter extends Membro{
    //Assinatura usada em tempo regular
    private final String assinaturaRegular = "Podem contar conosco!";
    //Assinatura em hora extra
    private final String assinaturaExtra = "N00b_qu3_n_Se_r3pita.bat";
    //Enum do tipo de membro
    private final TipoDeMembro tipoDeMembro = TipoDeMembro.HEAVYLIFTER;

    /**
     * Construtor da classe
     * @param nome nome do membro
     * @param email email do membro
     * @param id id do membro
     */
    public HeavyLifter(String nome, String email, int id, TipoDeMembro tipoDeMembro) {
        super(nome, email, id, tipoDeMembro);
    }

    /**
     * Metodo para postar mensagem
     * @param mensagem mensagem a ser postada
     * @param hora hora em que esta sendo postada
     * @return Mensagem assinada
     */
    @Override
    public String postarMensagem(String mensagem, HorarioDeAtividade hora){
        //Caso seja hora extra
        if(hora == HorarioDeAtividade.EXTRA)
            return (mensagem + "\n" + this.assinaturaExtra);
        //caso seja hora regular
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
