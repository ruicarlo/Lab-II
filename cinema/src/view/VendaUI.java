package view;

import bean.Secao;
import bean.Venda;
import repositorio.RepositorioSecao;

import repositorio.RepositorioVenda;
import util.Console;
import view.menu.VendaMenu;

public class VendaUI {

  private RepositorioVenda listaVendas;
  private RepositorioSecao listaSecoes;

  public VendaUI(RepositorioVenda vendas, RepositorioSecao secoes) {
    this.listaVendas = vendas;
    this.listaSecoes = secoes;
  }

  public void executar() {
    int opcao = 0;
    do {
      System.out.println(VendaMenu.getOpcoes());
      opcao = Console.scanInt("Digite sua opção:");
      switch (opcao) {
        case VendaMenu.OP_CADASTRAR:
          cadastrarVenda();
          break;
        case VendaMenu.OP_VOLTAR:
          System.out.println("Retornando ao menu principal..");
          break;
        default:
          System.out.println("Opção inválida..");

      }
    } while (opcao != VendaMenu.OP_VOLTAR);
  }

  private void cadastrarVenda() {
    System.out.println("Relacione a secao abaixo para a venda: ");
    new SecaoUI(listaSecoes).mostrarSecoes();
    int codigo = Console.scanInt("Escolha o codigo da secao: ");
    Secao secao = listaSecoes.buscarPorCodigo(codigo);

    try {
      secao.dimuirLugar();
      listaVendas.add(new Venda(secao));
      System.out.println("Venda efetuada com sucesso");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
