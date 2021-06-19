package br.maua.models;

import br.maua.enums.TipoDeMembro;
import br.maua.interfaces.Apresentacao;
import br.maua.interfaces.PostarMensagem;

/**
 * Classe abstrata para representar um membro
 */
abstract class Membro implements PostarMensagem,Apresentacao {
    private String nome;
    private String email;
    private int id;
    private String assinaturaRegular;
    private String assinaturaExtra;
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
