package bean;

import java.util.Date;

public class Secao {
  private Sala sala;
  private Filme filme;
  private Date horario;
  private int lugaresDisponiveis;
  private static int autocodigo = 0;
  private int codigo;

  public Secao(Sala sala, Filme filme, Date horario) {
    this.sala = sala;
    this.filme = filme;
    this.horario = horario;
    lugaresDisponiveis = sala.getCapacidade();
    Secao.autocodigo++;
    this.codigo = Secao.autocodigo;
  }

  public int getCodigo() {
    return codigo;
  }

  public Sala getSala() {
    return sala;
  }

  public Filme getFilme() {
    return filme;
  }

  public Date getHorario() {
    return horario;
  }

  public int getLugaresDisponiveis() {
    return sala.getCapacidade()-lugaresDisponiveis;
  }

  public void dimuirLugar() throws Exception {
    if(lugaresDisponiveis > 0) {
      lugaresDisponiveis--;
    } else {
      throw new Exception("Secao esgotada");
    }
  }
}
