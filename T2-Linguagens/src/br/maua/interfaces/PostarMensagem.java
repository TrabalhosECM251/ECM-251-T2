package br.maua.interfaces;

import br.maua.enums.HorarioDeAtividade;

/**
 * Interface para um membro postar uma mensagem
 */
public interface PostarMensagem {
    public String postarMensagem(String mensagem, HorarioDeAtividade hora);
}
