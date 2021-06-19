package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;
import br.maua.interfaces.Data;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.*;

public class Sistema implements Data {
    public HorarioDeAtividade hora = HorarioDeAtividade.REGULAR;
    private ArrayList<Membro> membros = new ArrayList<>();

    @Override
    public int gerarAno(){
        return (int) floor(2021 +(231* PI)/exp(0));
    }

    private void menu(){
        System.out.print("--- Menu ---\n" +
                "Hora de trabalho:" + hora + "Ano:" + gerarAno() + "\n" +
                "1 - Cadastrar membros\n" +
                "2 - Postar mensagem pra cada membro cadastrado\n" +
                "3 - Trocar horario de trabalho\n" +
                "4 - Excluir membro\n" +
                "0 - Encerrar sistema");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op){
            case 1:
                cadastrarUsuario();
                cadastrarUsuario();
                cadastrarUsuario();
                cadastrarUsuario();
                break;
            case 2:
                postarMensagem();
                postarMensagem();
                postarMensagem();
                postarMensagem();
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
                break;
            case 0:
                System.out.println("Encerrando o sitema...");
                System.exit(0);
            default:
                System.out.println("Opcao invalida. Tente novamente");
                System.out.println("");
        }
    }

    private void cadastrarUsuario(String nome, String email, TipoDeMembro tipoDeMembro){
        switch (tipoDeMembro){
            case BIGBROTHER:
                membros.add(new BigBrother(nome, email));
                break;
            case HEAVYLIFTER:
                membros.add(new HeavyLifter(nome, email));
                break;
            case MOBILEMEMBER:
                membros.add(new MobileMember(nome, email));
                break;
            case SCRIPTGUY:
                membros.add(new ScriptGuy(nome, email));
                break;
        }
    }
}
