package view.menu;

public class MainMenu {

  public static final int OP_FILME     = 1;
  public static final int OP_SALA      = 2;
  public static final int OP_SECAO     = 3;
  public static final int OP_VENDA     = 4;
  public static final int OP_RELATORIO = 5;
  public static final int OP_SAIR      = 0;

  public static String getOpcoes() {
    return ("\n--------------------------------------\n"
            + "1- Menu Filmes\n"
            + "2- Menu Salas\n"
            + "3- Menu Secao\n"
            + "4- Menu Venda\n"
            + "5- Menu Relatorio\n"
            + "0- Sair da Aplicação"
            + "\n--------------------------------------");
  }
}
