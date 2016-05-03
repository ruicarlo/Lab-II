package bean;

import java.util.Date;

public class Secao {
  private Sala sala;
  private Filme filme;
  private Date horario;

  public Secao(Sala sala, Filme filme, Date horario) {
    this.sala = sala;
    this.filme = filme;
    this.horario = horario;
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
  
}
