package pucrs.myflight.consoleApp;
import pucrs.myflight.modelo.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class App {

	public static void main(String[] args) {


       //criação de rota
		CiaAerea cia = new CiaAerea("1235","Latam");
		//Localização do aeroporto de Porto Alegre
		Geo geoOrigem = new Geo(-29.9939, -51.1711);
		//Localização do aeroporto de Guarulhos
		Geo geoDestino = new Geo(-23.4356,-46.4731);

		Aeroporto origem = new Aeroporto("POA","Salgado Filho Intl Apt", geoOrigem);
		Aeroporto destino = new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", geoDestino);
		Aeronave aeronave = new  Aeronave("738","Boeing 800-400","145");
		Rota rota = new Rota(cia, origem,destino, aeronave);



		//Criação de voos das duas formas (Verificação)
		LocalDateTime datahora = LocalDateTime.now();
		Duration duracao = Duration.ofSeconds(3600);


		Voo voo = new VooDireto(rota, datahora);

		//criação do vooEscalas
		Rota rota2 = new Rota(cia,new Aeroporto("AA1","Teste 001", new Geo(21.0023, 52.3421)),
				new Aeroporto("BB1","Teste 002", new Geo(-19.4332, -51.1873)),aeronave);
		Rota rota3 = new Rota(cia,new Aeroporto("POA","Teste 003", new Geo(-32.8421, 16.3422)),
				new Aeroporto("AA1","Teste 004", new Geo(45.3422, 12.2342)),aeronave);
		Rota rota4 = new Rota(cia,new Aeroporto("POA","Teste 005", new Geo(-12.1322, 34.7832)),
				new Aeroporto("BB2","Teste 006", new Geo(23.5858, 16.6868)),aeronave);

		VooEscalas vooEscalas = new VooEscalas(datahora);
		vooEscalas.adicionarRota(rota2);
		vooEscalas.adicionarRota(rota3);
		vooEscalas.adicionarRota(rota4);

		VooDireto vooDireto = new VooDireto(rota4, datahora);

		double distancia = geoOrigem.distanciaAtual(geoDestino);

		System.out.println("Total de empresas: "+CiaAerea.getTotalCias());

		System.out.println(vooDireto.toString());
		System.out.println(vooEscalas.toString());
	}
}

