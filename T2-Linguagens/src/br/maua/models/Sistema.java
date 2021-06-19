package br.maua.models;

import br.maua.enums.HorarioDeAtividade;
import br.maua.enums.TipoDeMembro;
import br.maua.interfaces.Data;
import java.io.File;
import java.io.FileWriter;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.Scanner;
import static br.maua.models.Mensagem.gerarMensagem;
import static java.lang.Math.*;

//**
public class Sistema implements Data {

    /**
     * Atributos do sistema
     */
    //Horario de atividade atual
    public HorarioDeAtividade hora = HorarioDeAtividade.REGULAR;
    //ArrayList de membros
    private ArrayList<Membro> membros = new ArrayList<>();

    /**
     * Metodo para gerar ano aleatorio
     * @return ano
     */
    @Override
    public int gerarAno() {
        return (int) floor(2021 + (231 * PI) / exp(0));
    }

    /**
     * Construtor padrao
     */
    public Sistema() {
    }

    /**
     * Menu com opcoes para teste do sistema
     * @throws Exception caso algum erro ocorra
     */
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
            //Cadastra 4 usuarios
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

            //Posta uma mensagem pra acda usuario ativo
            case 2:
                for (Membro membro : membros) {
                    System.out.println(membro.postarMensagem(gerarMensagem(), this.hora) + "\n");
                }
                break;

            //Troca a hora de atividade
            case 3:
                if (this.hora == HorarioDeAtividade.REGULAR)
                    this.hora = HorarioDeAtividade.EXTRA;
                else
                    this.hora = HorarioDeAtividade.REGULAR;
                break;

            //Exclui o primeiro Heavy Lifter e o segundo Script guy
            case 4:
                if(excluirMembro(1, TipoDeMembro.HEAVYLIFTER))
                    System.out.println("Membro excluido com sucesso");
                if(excluirMembro(2, TipoDeMembro.SCRIPTGUY))
                    System.out.println("Membro excluido com sucesso");
                break;

            //Encerra o sistema
            case 0:
                System.out.println("Encerrando o sitema...");
                System.exit(0);

            //Caso uma opcao invalida seja inserida
            default:
                System.out.println("Opcao invalida. Tente novamente");
                System.out.println("");
        }
    }

    /**
     * Cadastro de um membro no sistema
     * @param nome nome do usuario
     * @param email email do usuario
     * @param tipoDeMembro tipo de usuario
     * @throws Exception caso algum erro ocorra
     */
    private void cadastrarUsuario(String nome, String email, TipoDeMembro tipoDeMembro) throws Exception {

        //Incremento no id de usuario
        int id = membros.size() + 1;

        //Avalia o ussuario a ser cadastrado
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

        //Adiciona o usuario ao banco de usuarios (.csv) na forma "id;email;nome;tipo\n"
        try{
        FileWriter fileWriter = new FileWriter("arquivo_super_Secreto_nao_abrir.csv", true);
        fileWriter.append(id + ";" + email + ";" + nome + ";" + tipoDeMembro + "\n");
        fileWriter.close();
        }
        //Caso algum erro ocorra ao tentar adicionar ao arquivo
        catch(Exception exception){
            System.out.println("Algo deu errado no cadastro.");
        }
    }

    /**
     * Exclusao de membro da base de usuario
     * @param referencia 1 = primeiro, 2 = segundo ...
     * @param tipoDeMembro tipo do membro a ser deletado
     * @throws Exception caso algum erro ocorra
     * @return true/false se excluiu ou nao o membro
     */
    private boolean excluirMembro(int referencia, TipoDeMembro tipoDeMembro) throws Exception {
        // Referencia atual
        int atual = 0;
        boolean achou = false;
        //Passagem por cada membro
        for(Membro membro:membros){
            //Se o membro atual é do tipo de interesse, incrementa a ref. atual
            if(tipoDeMembro == membro.getTipoDeMembro()) {
                atual += 1;
            }

            //Se a ref. atual é que desejamos remover, remove o membro do array de membros
            if(atual == referencia) {
                membros.remove(membro);
                achou = true;
                break;
            }

        }

        if(achou) {
            //Remocao do usuario do banco de usuarios
            try {
                File file = new File("arquivo_super_Secreto_nao_abrir.csv");
                file.delete();
                FileWriter fileWriter = new FileWriter("arquivo_super_Secreto_nao_abrir.csv", true);
                for (Membro membro : membros) {
                    fileWriter.append(membro.getId() + ";" + membro.getEmail() + ";" + membro.getNome() + ";" + membro.getTipoDeMembro() + "\n");
                }
                fileWriter.close();
            }
            //Caso algum erro ocorra na remocao
            catch (Exception exception) {
                System.out.println("Algo deu errado na exclusao.");
            }
        }
        return achou;
    }

    /**
     * Metodo para iniciar o sistema
     * @throws Exception caso algum erro ocorra
     */
    public void iniciar() throws Exception{
        while(true)
            menu();
    }
}