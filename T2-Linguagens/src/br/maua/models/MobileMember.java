package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;

/**
 * Classe para representar membros Mobile
 */
public class MobileMember extends Membro{
    //Assinatura usada em tempo regular
    private final String assinaturaRegular = "Happy Coding!";
    //Assinatura usada em hora extra
    private final String assinaturaExtra = "MAsK_S0c13ty";
    //Enum do tipo de membro
    private final TipoDeMembro tipoDeMembro = TipoDeMembro.MOBILEMEMBER;

    /**
     * Construtor da classe
     * @param nome nome do membro
     * @param email email do membro
     * @param id id do membro
     */
    public MobileMember(String nome, String email, int id, TipoDeMembro tipoDeMembro) {
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
                "Tipo: Mobile Member\n" +
                "------------------------------------\n");
    }
}
