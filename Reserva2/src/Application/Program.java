package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner leia = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("N° do quarto: ");
		int numero = leia.nextInt();
		System.out.println("Digíte a data do Check-in: ");
		Date checkIn = sdf.parse(leia.next());
		System.out.println("Digíte a data do Check-out: ");
		Date checkOut = sdf.parse(leia.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva, a data do Check-out é inferior a data do Check-In");
		} else {

			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva: ");

			System.out.println("Digíte a data do Check-in: ");
			checkIn = sdf.parse(leia.next());
			System.out.println("Digíte a data do Check-out: ");
			checkOut = sdf.parse(leia.next());

			String erro = reserva.atualizacaoData(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Erro na criação da reserva " + erro);

			} else {
				System.out.println("Reserva: " + reserva);
			}

		}

	}

}
