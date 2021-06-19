package br.maua.models;

import java.util.Random;

/**
 * Classee para escolher uma mensagem aleatoria para ser enviada
 * Fins de teste
 */
public class Mensagem {
    //Lista de frases aleatorias
    public static String[] bancoMensagens = new String[]{"Não se esqueça de beber água.",
            "Seja estranho. Seja aleatório. Seja quem você é. Porque você nunca sabe quem amaria a pessoa que você esconde.",
            "A vida é um caos aleatório, ordenada pelo tempo.",
            "A verdade, é que dói lembrar dela.",
            "O aleatório não existe, nosso cérebro sempre toma decisões mesmo que ocultas.",
            "A vida e uma caixa preta nunca saberemos o seu real significado.",
            "Não deveríamos temer a morte, mais sim a vida.",
            "O ruim de mentir, com tempo você acaba acreditando nas suas próprias mentiras.",
            "Cada instante é sempre.",
            "Quem tenta fazer todo mundo feliz acaba se sentido mais sozinho.",
            "Seja bondoso com seus amigos." };


    /**
     * Gera uma mensagem aleatoria
     * @return mensagem (string)
     */
    public static String gerarMensagem(){
        Random random = new Random();
        int i = random.nextInt(bancoMensagens.length);
        return bancoMensagens[i];
    }
}
