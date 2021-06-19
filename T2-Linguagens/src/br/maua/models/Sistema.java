package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;
import br.maua.interfaces.Data;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static br.maua.models.Mensagem.gerarMensagem;
import static java.lang.Math.*;

public class Sistema implements Data {
    public HorarioDeAtividade hora = HorarioDeAtividade.REGULAR;
    private ArrayList<Membro> membros = new ArrayList<>();

    @Override
    public int gerarAno() {
        return (int) floor(2021 + (231 * PI) / exp(0));
    }

    public Sistema() {
    }

    private void menu() throws Exception{
        System.out.print("--- Menu ---\n" +
                "Hora de trabalho:" + hora + "\tAno:" + gerarAno() + "\n" +
                "-----------------------------------\n" +
                "1 - Cadastrar membros\n" +
                "2 - Postar mensagem pra cada membro cadastrado\n" +
                "3 - Trocar horario de trabalho\n" +
                "4 - Excluir membro\n" +
                "0 - Encerrar sistema\n");


        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op) {
            case 1:
                System.out.print("Nome do usuario Mobile Member: ");
                String nome = sc2.nextLine();
                cadastrarUsuario(nome, "confia@email.com", TipoDeMembro.MOBILEMEMBER);

                System.out.print("Nome do usuario Heavy Lifter: ");
                nome = sc2.nextLine();
                cadastrarUsuario(nome, "foguetentemre@forget.com", TipoDeMembro.HEAVYLIFTER);

                System.out.print("Nome do usuario Script Guy: ");
                nome = sc2.nextLine();
                cadastrarUsuario(nome, "blablabla@teste.com", TipoDeMembro.SCRIPTGUY);

                System.out.print("Nome do usuario Big brother: ");
                nome = sc2.nextLine();
                cadastrarUsuario(nome, "bigbig@grandao.com", TipoDeMembro.BIGBROTHER);
                break;
            case 2:
                for (Membro membro : membros) {
                    System.out.println(membro.postarMensagem(gerarMensagem(), this.hora) + "\n");
                }
                break;
            case 3:
                if (this.hora == HorarioDeAtividade.REGULAR)
                    this.hora = HorarioDeAtividade.EXTRA;
                else
                    this.hora = HorarioDeAtividade.REGULAR;
                break;
            case 4:
                excluirMembro(1, TipoDeMembro.HEAVYLIFTER);
                excluirMembro(2, TipoDeMembro.SCRIPTGUY);
                break;
            case 5:

                break;
            case 0:
                System.out.println("Encerrando o sitema...");
                System.exit(0);
            default:
                System.out.println("Opcao invalida. Tente novamente");
                System.out.println("");
        }
    }

    private void cadastrarUsuario(String nome, String email, TipoDeMembro tipoDeMembro) throws Exception {
        int id = membros.size() + 1;
        switch (tipoDeMembro) {
            case BIGBROTHER:
                membros.add(new BigBrother(nome, email, id, TipoDeMembro.BIGBROTHER));
                break;
            case HEAVYLIFTER:
                membros.add(new HeavyLifter(nome, email, id, TipoDeMembro.HEAVYLIFTER));
                break;
            case MOBILEMEMBER:
                membros.add(new MobileMember(nome, email, id, TipoDeMembro.MOBILEMEMBER));
                break;
            case SCRIPTGUY:
                membros.add(new ScriptGuy(nome, email, id, TipoDeMembro.SCRIPTGUY));
                break;
        }
        try{
        FileWriter fileWriter = new FileWriter("arquivo_super_Secreto_nao_abrir.csv", true);
        fileWriter.append(id + ";" + email + ";" + nome + ";" + tipoDeMembro + "\n");
        fileWriter.close();
        }
        catch(Exception exception){
            System.out.println("Algo deu errado no cadastro.");
        }
    }


    private void excluirMembro(int referencia, TipoDeMembro tipoDeMembro) throws Exception {
        // Referencia atual
        int atual = 0;

        //Passagem por cada membro
        for(Membro membro:membros){
            //Se o membro atual é do tipo de interesse, incrementa a ref. atual
            if(membro.getTipoDeMembro() == tipoDeMembro) {
                atual += 1;
            }
            //Se a ref. atual é que desejamos remover, remove o membro do array de membros
            if(atual == referencia) {
                membros.remove(membro);
            }
        }
        try {
            File file = new File("arquivo_super_Secreto_nao_abrir.csv");
            file.delete();
            FileWriter fileWriter = new FileWriter("arquivo_super_Secreto_nao_abrir.csv", true);
            for (Membro membro : membros) {
                fileWriter.append(membro.getId() + ";" + membro.getEmail() + ";" + membro.getNome() + ";" + membro.getTipoDeMembro() + "\n");
            }
            fileWriter.close();
        }
        catch(Exception exception){
            System.out.println("Algo deu errado na exclusao.");
        }
    }

    public void iniciar() throws Exception{
        while(true)
            menu();
    }
}