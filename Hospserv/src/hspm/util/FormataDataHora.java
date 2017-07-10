package hspm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataDataHora {
	public static String formataData(String dt) {
		String data = dt.replace("+", "").trim();
		String ano = data.substring(0, 4);
		String mes = data.substring(4, 6);
		String dia = data.substring(6, 8);

		data = dia + "/" + mes + "/" + ano;

		return data;
	}

	public static String tirarBarrasData(String dt) {
		String data = dt.replace("+", "").trim();
		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6, 10);
		data = ano + mes + dia;
		return data;
	}

	public static String formataHora(String h) {
		String horaCompleta = h.trim();
		if (h.equals("")) {
			horaCompleta = "N/C";
		} else {
			String hora = horaCompleta.substring(0, 2);
			String minuto = horaCompleta.substring(2, 4);
			horaCompleta = hora + ":" + minuto;

		}
		return horaCompleta;
	}

	public static String calculaDiffHora(String horaIni, String horaFim) {
		String tempo = null;

		// Custom date format
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date d1 = null;
		Date d2 = null;
		Date horasmin = null;
		if ((horaIni.equals("N/C")) || (horaFim.equals("N/C"))) {
			tempo = "N/C";
		} else {
			try {
				d1 = format.parse(horaIni);
				d2 = format.parse(horaFim);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long diff = d2.getTime() - d1.getTime();
			long diffMinutes = diff / (60 * 1000);
			long diffHours = diff / (60 * 60 * 1000);
			long diffHorasMin = (diffMinutes % 60);
			try {
				horasmin = format.parse(diffHours + ":" + diffHorasMin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempo = DateFormat.getTimeInstance(DateFormat.SHORT).format(horasmin);
		}
		return tempo;
	}
	public static String calculaSomaTEmpo(String horaIni, String horaFim) {
		String horaSomada = "";
		String[] strHoraCompletaInicio = horaIni.split(":");
		String[] strHoraCompletaFim = horaFim.split(":");
		
	
		
		Integer hrInicio = Integer.parseInt(strHoraCompletaInicio[0]);
		Integer minInicio = Integer.parseInt(strHoraCompletaInicio[1]);
		Integer hrFim = Integer.parseInt(strHoraCompletaFim[0]);
		Integer minFim = Integer.parseInt(strHoraCompletaFim[1]);

		Integer minSoma = (hrInicio * 60) + (hrFim *60) + minInicio+ minFim;
		Integer hrTotal= minSoma/60;
		Integer minTotal= minSoma%60;
		horaSomada = String.format("%02d",hrTotal) + ":" + String.format("%02d",minTotal);
	
		return horaSomada;
	}
	
	public static String calculaSomaTotal(String jan, String fev,String mar, String abr,String mai, String jun,String jul, String ago,String set, String out,String nov, String dez) {
		String horaSomada = "";
		String[] strJan = jan.split(":");
		String[] strFev = fev.split(":");
		String[] strMar = mar.split(":");
		String[] strAbr = abr.split(":");
		String[] strMai = mai.split(":");
		String[] strJun = jun.split(":");
		String[] strJul = jul.split(":");
		String[] strAgo = ago.split(":");
		String[] strSet = set.split(":");
		String[] strOut = out.split(":");
		String[] strNov = nov.split(":");
		String[] strDez = dez.split(":");
	
		
	
		
		Integer hrJan = Integer.parseInt(strJan[0]);
		Integer minJan = Integer.parseInt(strJan[1]);
		Integer hrFev = Integer.parseInt(strFev[0]);
		Integer minFev = Integer.parseInt(strFev[1]);
		Integer hrMar = Integer.parseInt(strMar[0]);
		Integer minMar = Integer.parseInt(strMar[1]);
		Integer hrAbr = Integer.parseInt(strAbr[0]);
		Integer minAbr = Integer.parseInt(strAbr[1]);
		Integer hrMai = Integer.parseInt(strMai[0]);
		Integer minMai = Integer.parseInt(strMai[1]);
		Integer hrJun = Integer.parseInt(strJun[0]);
		Integer minJun = Integer.parseInt(strJun[1]);
		Integer hrJul = Integer.parseInt(strJul[0]);
		Integer minJul = Integer.parseInt(strJul[1]);
		Integer hrAgo = Integer.parseInt(strAgo[0]);
		Integer minAgo = Integer.parseInt(strAgo[1]);
		Integer hrSet = Integer.parseInt(strSet[0]);
		Integer minSet = Integer.parseInt(strSet[1]);
		Integer hrOut = Integer.parseInt(strOut[0]);
		Integer minOut = Integer.parseInt(strOut[1]);
		Integer hrNov = Integer.parseInt(strNov[0]);
		Integer minNov = Integer.parseInt(strNov[1]);
		Integer hrDez = Integer.parseInt(strDez[0]);
		Integer minDez = Integer.parseInt(strDez[1]);
		

		Integer minSoma = (hrJan * 60) + (hrFev * 60) +(hrMar * 60) +(hrAbr * 60) +(hrMai * 60) +(hrJun * 60) +(hrJul * 60) +(hrAgo * 60) +(hrSet * 60) +(hrOut * 60) +(hrNov * 60) +(hrDez * 60) + minJan + minFev + minMar + minAbr + minMai + minJun + minJul + minAgo + minSet + minOut + minNov + minDez;
		Integer hrTotal= minSoma/60;
		Integer minTotal= minSoma%60;
		horaSomada = hrTotal + ":" + minTotal;
	
		return horaSomada;
	}
	
}
