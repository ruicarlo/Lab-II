package view;

import bean.Filme;
import bean.Sala;
import bean.Secao;
import java.util.Date;
import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import util.Console;
import util.DateUtil;
import view.menu.SecaoMenu;

public class SecaoUI {

  private RepositorioSecao listaSecoes;
  private RepositorioFilme listaFilmes;
  private RepositorioSala listaSalas;

  public SecaoUI(RepositorioSecao listaSecoes, RepositorioFilme listaFilmes, RepositorioSala listaSalas) {
    this.listaSecoes = listaSecoes;
    this.listaFilmes = listaFilmes;
    this.listaSalas = listaSalas;
  }

  public SecaoUI(RepositorioSecao listaSecoes) {
    this.listaSecoes = listaSecoes;
  }

  public void executar() {
    int opcao = 0;
    do {
      System.out.println(SecaoMenu.getOpcoes());
      opcao = Console.scanInt("Digite sua opção:");
      switch (opcao) {
        case SecaoMenu.OP_CADASTRAR:
          cadastrarSecao();
          break;
        case SecaoMenu.OP_LISTAR:
          mostrarSecoes();
          break;
        case SecaoMenu.OP_VOLTAR:
          System.out.println("Retornando ao menu principal..");
          break;
        default:
          System.out.println("Opção inválida..");

      }
    } while (opcao != SecaoMenu.OP_VOLTAR);
  }

  private void cadastrarSecao() {
    System.out.println("Relacione o filme abaixo para a secao: ");
    new FilmeUI(listaFilmes).mostrarFilmes();
    String codigo = Console.scanString("Escolha o codigo do filme: ");
    Filme filme = listaFilmes.buscarPorCodigo(codigo);

    System.out.println("Relacione a sala abaixo para a secao: ");
    new SalaUI(listaSalas).mostrarSalas();
    Integer numero = Console.scanInt("Escolha o numero da sala: ");
    Sala sala = listaSalas.buscarPorNumero(numero);

    try {
      Date horario = DateUtil.stringToHour(Console.scanString("Digite o horario da secao: "));
      Secao secao = new Secao(sala, filme, horario);
      listaSecoes.add(secao);
    } catch (Exception e) {
      e.getMessage();
    }
  }

  public void mostrarSecoes() {
    int contador = 0;
    for (Secao secao : listaSecoes.getLista()) {
      if(contador > 0) {
        System.out.println("\n");
      }
      System.out.println("Codigo: "  + secao.getCodigo());
      System.out.println("Hora: "  + DateUtil.HourToString(secao.getHorario()));
      System.out.println("Filme: " + secao.getFilme().getNome() + "(" + secao.getFilme().getCodigo() + ")");
      System.out.println("Sala: "  + secao.getSala().getNumero());
      contador++;
    }
  }
}
