package view;

import bean.Secao;
import bean.Venda;
import java.util.ArrayList;
import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import repositorio.RepositorioVenda;
import util.Console;
import util.DateUtil;
import view.menu.RelatorioMenu;

public class RelatorioUI {

  private RepositorioFilme listaFilmes;
  private RepositorioSala listaSalas;
  private RepositorioSecao listaSecoes;
  private RepositorioVenda listaVendas;

  public RelatorioUI(RepositorioFilme listaFilmes, RepositorioSala listaSalas, RepositorioSecao listaSecoes, RepositorioVenda listaVendas) {
    this.listaFilmes = listaFilmes;
    this.listaSalas = listaSalas;
    this.listaSecoes = listaSecoes;
    this.listaVendas = listaVendas;

  }

  public void executar() {
    int opcao = 0;
    do {
      System.out.println(RelatorioMenu.getOpcoes());
      opcao = Console.scanInt("Digite sua opção:");
      switch (opcao) {
//        case RelatorioMenu.OP_REL_FILME:
//          gerarRelatorioFilme();
//          break;
//        case RelatorioMenu.OP_REL_HORARIO:
//          gerarRelatorioHorario();
//          break;
//        case RelatorioMenu.OP_REL_SALA:
//          gerarRelatorioSala();
//          break;
        case RelatorioMenu.OP_REL_SECAO:
          gerarRelatorioSecao();
          break;
        case RelatorioMenu.OP_VOLTAR:
          System.out.println("Retornando ao menu principal..");
          break;
        default:
          System.out.println("Opção inválida..");

      }
    } while (opcao != RelatorioMenu.OP_VOLTAR);
  }

  private void gerarRelatorioSecao() {
    RepositorioSecao repSecao = new RepositorioSecao();
    for (Venda venda : listaVendas.getLista()) {
      if(!repSecao.existeSecaoPorCodigo(venda.getSecao().getCodigo())){
        repSecao.add(venda.getSecao());
      }
    }

    System.out.println("-----------------------------\n");
    System.out.println(String.format("%-10s", "CODIGO DA SECAO") + "\t"
            + String.format("%-40s", "|FILME") + "\t"
            + String.format("%-10s", "|HORARIO") + "\t"
            + String.format("%-10s", "|SALA")  + "\t"
            + String.format("%-10s", "|VENDAS")
    );
    for (Secao secao : repSecao.getLista()) {
      System.out.println(String.format("%-10s", secao.getCodigo()) + "\t"
              + String.format("%-40s", "|" + secao.getFilme().getNome()) + "\t"
              + String.format("%-10s", "|" + DateUtil.HourToString(secao.getHorario())) + "\t"
              + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
              + String.format("%-10s", "|" + secao.getLugaresDisponiveis())
      );    
    }
  }
}