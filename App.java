package pucrs.myflight.consoleApp;
import pucrs.myflight.modelo.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class App {

	public static void main(String[] args) {


       //criação de rota
		CiaAerea cia = new CiaAerea("Latam");
		Geo geoOrigem = new Geo(-29.9939, -51.1711);
		Geo geoDestino = new Geo(-23.4356,-46.4731);

		Aeroporto origem = new Aeroporto("POA","Salgado Filho Intl Apt", geoOrigem);
		Aeroporto destino = new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", geoDestino);
		Aeronave aeronave = new  Aeronave("738","Boeing 800-400","145");
		Rota rota = new Rota(cia, origem,destino, aeronave);



		//criação do voo
		LocalDateTime datahora = LocalDateTime.of(2016, Month.AUGUST, 10, 8, 0);
		Duration duracao = Duration.ofSeconds(3600);
		Voo voo = new Voo(rota,datahora,duracao);



		//criação do vooEscalas
		Rota rotaFinal = new Rota(cia,origem,destino,aeronave);
		VooEscalas vooEscalas = new VooEscalas(rota,rotaFinal, datahora ,duracao);


		//Falta implementar os outros ToStrings
		//
		System.out.println(rotaFinal.toString());
	}


}
}
