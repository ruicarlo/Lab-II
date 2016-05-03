package view;

import bean.Filme;
import repositorio.RepositorioFilme;
import util.Console;
import view.menu.FilmeMenu;

public class FilmeUI {

  private RepositorioFilme lista;

  public FilmeUI(RepositorioFilme lista) {
    this.lista = lista;
  }

  public void executar() {
    int opcao = 0;
    do {
      System.out.println(FilmeMenu.getOpcoes());
      opcao = Console.scanInt("Digite sua opção:");
      switch (opcao) {
        case FilmeMenu.OP_CADASTRAR:
          cadastrarFilme();
          break;
        case FilmeMenu.OP_LISTAR:
          mostrarFilmes();
          break;
        case FilmeMenu.OP_VOLTAR:
          System.out.println("Retornando ao menu principal..");
          break;
        default:
          System.out.println("Opção inválida..");

      }
    } while (opcao != FilmeMenu.OP_VOLTAR);
  }

  private void cadastrarFilme() {
    String codigo = Console.scanString("Codigo: ");
    if (lista.existeFilmePorCodigo(codigo)) {
      System.out.println("O codigo do filme já existente no cadastro");
    } else {
      String nome = Console.scanString("Nome: ");
      String genero = Console.scanString("Genero: ");
      String sinopse = Console.scanString("Sinopse: ");

      lista.add(new Filme(codigo, nome, genero, sinopse));
      System.out.println("Filme " + nome + " cadastrado com sucesso!");

    }
  }

  public void mostrarFilmes() {
    System.out.println("-----------------------------\n");
    System.out.println(String.format("%-10s", "CODIGO") + "\t"
            + String.format("%-20s", "|NOME") + "\t"
            + String.format("%-20s", "|GENERO")
            + String.format("%-20s", "|SINOPSE"));
    for (Filme filme : lista.getLista()) {
      System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
              + String.format("%-20s", "|" + filme.getNome()) + "\t"
              + String.format("%-20s", "|" + filme.getGenero())
              + String.format("%-20s", "|" + filme.getSinopse()));
    }

  }
}
