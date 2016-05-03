package repositorio;

import java.util.Date;
import bean.Secao;

public class RepositorioSecao extends IRepositorio<Secao> {
  
  public Secao buscarPorHorario(Date horario) {
    for(Secao secao : lista) {
      if(secao.getHorario().equals(horario)) {
        return secao;
      }
    }
    return null;
  }
  
  public boolean existeSecao(Date horario) {
    return buscarPorHorario(horario) != null;
  }
  
}
