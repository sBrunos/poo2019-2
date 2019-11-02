package pucrs.myflight.modelo;

public class GerenciadorAeronaves {
   public void ordenarDescricao() {
   avioes.sort(Comparator.comparing(a -> a.getDescricao()));
   // Invertendo o critério de comparação
   avioes.sort(Comparator.comparing(Aeronave::getDescricao).reversed());
 }
  
  public void ordenarCodigoDescricao() {
// Ordenando pelo código e desempatando pela descrição
 avioes.sort(Comparator.comparing(Aeronave::getCodigo).
thenComparing(Aeronave::getDescricao));
    }

   public void ordenarCodigo() {
      avioes.sort( (Aeronave a1, Aeronave a2) ->
          a1.getCodigo().compareTo(a2.getCodigo()));
  }
}
