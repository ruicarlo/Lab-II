package bean;

public class Sala {
  private Integer numero;
  private Integer capacidade;

  public Sala(Integer numero, Integer capacidade) {
    this.numero = numero;
    this.capacidade = capacidade;
  }

  public Integer getNumero() {
    return numero;
  }

  public Integer getCapacidade() {
    return capacidade;
  }

  public void diminuirLugar() throws Exception {
    if(capacidade > 0) {
      capacidade--;
    } else {
      throw new Exception("Venda esgotada");
    }
  }
}
