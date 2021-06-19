package br.maua.models;

import br.maua.enums.TipoDeMembro;
import br.maua.interfaces.Apresentacao;
import br.maua.interfaces.PostarMensagem;

/**
 * Classe abstrata para representar um membro
 */
abstract class Membro implements PostarMensagem,Apresentacao {
    //Nome do membro (nick)
    private String nome;
    //Email do membro
    private String email;
    //ID do membro
    private int id;
    //Assinatura em hora regular
    private String assinaturaRegular;
    //Assinatura em hora extra
    private String assinaturaExtra;
    //Enum do tipo de membro
    private TipoDeMembro tipoDeMembro;

    /**
     * Construtor de um membro
     * @param nome nome do membro
     * @param email email do membro
     */
    public Membro(String nome, String email, int id, TipoDeMembro tipoDeMembro){
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.tipoDeMembro = tipoDeMembro;
    }

    /**
     * Getters
     */
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getAssinaturaRegular() {
        return assinaturaRegular;
    }

    public String getAssinaturaExtra() {
        return assinaturaExtra;
    }

    public TipoDeMembro getTipoDeMembro(){
        return this.tipoDeMembro;
    }

    public int getId() {
        return id;
    }
}
