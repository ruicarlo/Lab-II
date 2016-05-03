package view;

import bean.Sala;
import repositorio.RepositorioSala;
import util.Console;
import view.menu.SalaMenu;

public class SalaUI {

  private RepositorioSala lista;

  public SalaUI(RepositorioSala lista) {
    this.lista = lista;
  }

  public void executar() {
    int opcao = 0;
    do {
      System.out.println(SalaMenu.getOpcoes());
      opcao = Console.scanInt("Digite sua opção:");
      switch (opcao) {
        case SalaMenu.OP_CADASTRAR:
          cadastrarSala();
          break;
        case SalaMenu.OP_LISTAR:
          mostrarSalas();
          break;
        case SalaMenu.OP_VOLTAR:
          System.out.println("Retornando ao menu principal..");
          break;
        default:
          System.out.println("Opção inválida..");

      }
    } while (opcao != SalaMenu.OP_VOLTAR);
  }

  private void cadastrarSala() {
    Integer numero = Console.scanInt("Numero: ");
    if (lista.existeSala(numero)) {
      System.out.println("Esta sala já existente no cadastro");
    } else {
      Integer capacidade = Console.scanInt("Capacidade: ");
      lista.add(new Sala(numero, capacidade));
      System.out.println("Sala " + numero + " cadastrada com sucesso!");

    }
  }

  public void mostrarSalas() {
    System.out.println("-----------------------------\n");
    System.out.println(String.format("%-10s", "NUMERO") + "\t"
            + String.format("%-20s", "|CAPACIDADE") + "\t");
    for (Sala sala : lista.getLista()) {
      System.out.println(String.format("%-10s", sala.getNumero()) + "\t"
              + String.format("%-20s", "|" + sala.getCapacidade()));
    }

  }  
}
