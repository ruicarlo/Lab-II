package bean;

public class Filme {
  private String codigo;
  private String nome;
  private String genero;
  private String sinopse;

  public Filme(String codigo, String nome, String genero, String sinopse) {
    this.codigo = codigo;
    this.nome = nome;
    this.genero = genero;
    this.sinopse = sinopse;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getSinopse() {
    return sinopse;
  }

  public void setSinopse(String sinopse) {
    this.sinopse = sinopse;
  }

}
