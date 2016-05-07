package view;

import bean.Filme;
import bean.Sala;
import bean.Secao;
import bean.Venda;
import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import repositorio.RepositorioVenda;
import util.Console;
import util.DateUtil;
import view.menu.MainMenu;

public class MainUI {

  private RepositorioFilme listaFilmes;
  private RepositorioSala listaSalas;
  private RepositorioSecao listaSecoes;
  private RepositorioVenda listaVendas;
//    private Agenda agenda;

  public MainUI() {
    listaFilmes = new RepositorioFilme();
    listaSalas = new RepositorioSala();
    listaSecoes = new RepositorioSecao();
    listaVendas = new RepositorioVenda();
    //popular();
  }

  private void popular() {
    try{
      Filme filme1 = new Filme("primeiravez", "como se fosse a primeira vez", "comedia", "teste teste");
      Filme filme2 = new Filme("ultsamurai", "o ultimo samurai", "acao", "o samurai eh bem legal");
      Sala sala1 = new Sala(1, 10);
      Sala sala2 = new Sala(2, 20);
      Secao secao1 = new Secao(sala1, filme1,DateUtil.stringToHour("10:00"));
      Secao secao2 = new Secao(sala2, filme2,DateUtil.stringToHour("12:00"));
      
      listaFilmes.add(filme1);
      listaFilmes.add(filme2);
      listaSalas.add(sala1);
      listaSalas.add(sala2);
      listaSecoes.add(secao1);
      listaSecoes.add(secao2);
      
      secao1.dimuirLugar();listaVendas.add(new Venda(secao1));
      secao1.dimuirLugar();listaVendas.add(new Venda(secao1));
      secao1.dimuirLugar();listaVendas.add(new Venda(secao1));
      secao1.dimuirLugar();listaVendas.add(new Venda(secao1));
      secao1.dimuirLugar();listaVendas.add(new Venda(secao1));

      secao2.dimuirLugar();listaVendas.add(new Venda(secao2));

    }catch(Exception e) {
    }
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
        case MainMenu.OP_VENDA:
          new VendaUI(listaVendas, listaSecoes).executar();
          break;
        case MainMenu.OP_RELATORIO:
          new RelatorioUI(listaFilmes, listaSalas, listaSecoes, listaVendas).executar();
          break;
        case MainMenu.OP_SAIR:
          System.out.println("Aplicação finalizada!!!");
          break;
        default:
          System.out.println("Opção inválida..");

      }
    } while (opcao != MainMenu.OP_SAIR);
  }
}
