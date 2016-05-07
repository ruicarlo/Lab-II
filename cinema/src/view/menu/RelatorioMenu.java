package view.menu;

public class RelatorioMenu {
  public static final int OP_REL_FILME   = 1;
  public static final int OP_REL_HORARIO = 2;
  public static final int OP_REL_SALA    = 3;
  public static final int OP_REL_SECAO   = 4;
  public static final int OP_VOLTAR      = 0;

  public static String getOpcoes() {
    return ("\n--------------------------------------\n"
            + "1- Relatorio por Filme\n"
            + "2- Relatorio por Horario\n"
            + "3- Relatorio por Sala\n"
            + "4- Relatorio por Secao\n"
            + "0- Voltar"
            + "\n--------------------------------------");
  }    
}
