package pucrs.myflight.consoleApp;
import pucrs.myflight.modelo.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class App {

	public static void main(String[] args) {


       //criação de rota
		CiaAerea cia = new CiaAerea("Latam");
		//Localização do aeroporto de Porto Alegre
		Geo geoOrigem = new Geo(-29.9939, -51.1711);
		//Localização do aeroporto de Guarulhos
		Geo geoDestino = new Geo(-23.4356,-46.4731);

		Aeroporto origem = new Aeroporto("POA","Salgado Filho Intl Apt", geoOrigem);
		Aeroporto destino = new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", geoDestino);
		Aeronave aeronave = new  Aeronave("738","Boeing 800-400","145");
		Rota rota = new Rota(cia, origem,destino, aeronave);



		//Criação de voos das duas formas (Verificação)
		LocalDateTime datahora = LocalDateTime.of(2016, Month.AUGUST, 10, 8, 0);
		Duration duracao = Duration.ofSeconds(3600);

		//Forma com todos os parâmetros
		Voo voo = new Voo(rota,datahora,duracao);

		//Forma com a hora default
		Voo vooHoraDefault = new Voo(rota, duracao);


		//criação do vooEscalas
		Rota rotaFinal = new Rota(cia,origem,destino,aeronave);
		VooEscalas vooEscalas = new VooEscalas(rota,rotaFinal, datahora ,duracao);


		double distancia = geoOrigem.distanciaAtual(geoDestino);

		
		

		//Falta implementar os outros ToStrings
		//
		System.out.println(rotaFinal.toString());
	}


}

