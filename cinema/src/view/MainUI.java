package view;

import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import util.Console;
import view.menu.MainMenu;

public class MainUI {
    private RepositorioFilme listaFilmes;
    private RepositorioSala listaSalas;
    private RepositorioSecao listaSecoes;
//    private RepositorioConsultas listaConsultas;
//    private Agenda agenda;

    public MainUI() {
        listaFilmes = new RepositorioFilme();
        listaSalas  = new RepositorioSala();
        listaSecoes = new RepositorioSecao();
//        listaConsultas = new RepositorioConsultas();
//        agenda = new Agenda();
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case MainMenu.OP_FILME:
                    new FilmeUI(listaFilmes).executar();
                    break;
                case MainMenu.OP_SALA:
                    new SalaUI(listaSalas).executar();
                    break;
                case MainMenu.OP_SECAO:
                    new SecaoUI(listaSecoes, listaFilmes, listaSalas).executar();
                    break;
//                case MainMenu.OP_AGENDA:
//                    new AgendaUI(listaPacientes,agenda).executar();
//                    break;
//                case MainMenu.OP_HISTORICO:
//                    new HistoricoUI(listaConsultas).executar();
//                    break;
//                case MainMenu.OP_SAIR:
//                    System.out.println("Aplicação finalizada!!!");
//                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != MainMenu.OP_SAIR);
    }  
}
