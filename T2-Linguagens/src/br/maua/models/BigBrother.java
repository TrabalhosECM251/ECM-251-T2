package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;

public class BigBrother extends Membro{
    //Assinatura usada em tempo regular
    private final String assinaturaRegular = "Sempre ajudando as pessoas membros ou não S2!";
    //Assinatura usada em hora extra
    private final String assinaturaExtra = "...";
    //Enum de tipo de usuario
    private final TipoDeMembro tipoDeMembro = TipoDeMembro.BIGBROTHER;

    /**
     * Construtor da classe
     * @param nome nome do membro
     * @param email email do membro
     * @param id id do membro
     */
    public BigBrother(String nome, String email, int id, TipoDeMembro tipoDeMembro) {
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
                "Tipo: Big Brother\n" +
                "------------------------------------\n");
    }
}
