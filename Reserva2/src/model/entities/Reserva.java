package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {

	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {

		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {

		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);

	}

	public String atualizacaoData(Date checkIn, Date checkOut) {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Erro na reserva, as datas de atualização devem ser futuras ";
		}

		if (!checkOut.after(checkIn)) {
			return "Erro na reserva, a data do Check-out é inferior a data do Check-In";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;

	}

	@Override

	public String toString() {

		return "N° Quarto " + numeroQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out "
				+ sdf.format(checkOut) + ", " + duracao() + " noites";

	}

}
