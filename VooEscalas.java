package pucrs.myflight.modelo;
import java.lang.Math;
import java.time.Duration;
import java.time.LocalDateTime;

public class VooEscalas extends Voo
{
    private ArrayList<Rota> rotas = new ArrayList();

    // Construtor
    public VooEscalas(LocalDateTime dh) {
        super(dh);
    }

    public void adicionarRota(Rota rota) {
        rotas.add(rota);
    }

    public Rota getRota(){
        return rotas[0];
    }

    public ArrayList<Rota> getRotas() {
        return rotas;
    }

    Rota getRota(){
        return rotas[0];
    }

    public Duration getDuracao() {
        final int R = 6371;

        double oLat; double oLon;
        double dLat; double dLon;
        double distancia;
        Duration duracao = Duration.ofSeconds(0);

        for (Rota rota : rotas) {
            oLat= rota.getOrigem().getLocal().getLatitude();
            oLon= rota.getOrigem().getLocal().getLongitude();
            dLat= rota.getDestino().getLocal().getLatitude();
            dLon= rota.getDestino().getLocal().getLongitude();

            distancia = Math.sin(Math.toRadians(oLat)) * Math.sin(Math.toRadians(dLat)) + Math.cos(Math.toRadians(oLat)) * Math.cos(Math.toRadians(dLat)) * Math.cos(Math.toRadians(oLon - dLon));
            distancia = Math.acos(distancia);
            distancia = Math.toDegrees(distancia);
            distancia = distancia * 60 * 1.1515 * 1.609344;


            duracao = duracao.plusSeconds( (long) ((distancia / 805) * 3600));
            duracao = duracao.plusMinutes(30);
        }

        return duracao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status novo) {
        this.status = novo;
    }
    @Override
    public String toString() {
        try {


            String retorno = "Rota: " + rotas[i] + "Data  e hora: " + super.getDataHora() + "Duracao: " + this.getDuracao();

            if (rotas.length() > 1)
                for (int i = 1; i < rotas.length(); i++) {
                    retorno = "\n -> " + "Rota: " + rotas[i] + "Data  e hora: " + super.getDataHora() + "Duracao: " + this.getDuracao();
                }

            return retorno;
        }
        catch (Exception e) {
            return "Houve um problema ao acessar as rotas.";
        }
    }
}
