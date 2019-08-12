package com.robson.uteis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PadraoData {
	
	public static Date StringParaDate(String s) throws ParseException {
		Date data = new SimpleDateFormat("dd/MM/yyyy").parse(s);
		return data;
	}
}
