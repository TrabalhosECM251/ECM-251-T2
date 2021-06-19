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
                "Tipo: Big Brother\n" +
                "------------------------------------\n");
    }
}
