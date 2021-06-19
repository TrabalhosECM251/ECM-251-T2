package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.interfaces.Data;
import java.util.Scanner;
import static java.lang.Math.*;

public class Sistema implements Data {
    public HorarioDeAtividade hora = HorarioDeAtividade.REGULAR;

    @Override
    public int gerarAno(){
        return (int) floor(2021 +(231* PI)/exp(0));
    }

    public void menu(){
        System.out.print("--- Menu ---\n" +
                "Hora de trabalho:" + hora + "\n" +
                "1 - Cadastrar membros\n" +
                "2 - Postar mensagem pra cada membro cadastrado\n" +
                "3 - Trocar horario de trabalho\n" +
                "4 - Excluir membro\n" +
                "0 - Encerrar sistema");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op){
            case 1:
                cadastrarUsuarios();
                cadastrarUsuarios();
                cadastrarUsuarios();
                cadastrarUsuarios();
                break;
            case 2:
                postarMensagens();
                postarMensagens();
                postarMensagens();
                postarMensagens();
                break;
            case 3:
                if(this.hora == HorarioDeAtividade.REGULAR)
                    this.hora = HorarioDeAtividade.EXTRA;
                else
                    this.hora = HorarioDeAtividade.REGULAR;
                break;
            case 4:
                excluirMembro();
                excluirMembro();
        }
    }
}
