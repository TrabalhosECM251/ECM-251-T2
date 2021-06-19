package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;

public class MobileMember extends Membro{
    private final String assinaturaRegular = "Happy Coding!";
    private final String assinaturaExtra = "MAsK_S0c13ty";
    private final TipoDeMembro tipoDeMembro = TipoDeMembro.MOBILEMEMBER;

    /**
     * Construtor da classe
     * @param nome nome do membro
     * @param email email do membro
     */
    public MobileMember(String nome, String email) {
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
                "Tipo: Mobile Member\n" +
                "------------------------------------\n");
    }
}
