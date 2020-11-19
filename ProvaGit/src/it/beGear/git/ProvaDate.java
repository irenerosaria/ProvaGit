package it.beGear.git;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProvaDate {

	public static void main(String[] args) {
		
	//Data odierna
	Date date1 = new Date();
    System.out.println("Date1: " + date1);
    
    //Comparazione di date
    Date date2 = new Date();
    System.out.println("Date2: " + date2);
    System.out.println(date1.before(date2));
    System.out.println(date1.after(date2));
	
	//Formattazioni: SHORT, MEDIUM, LONG, FULL
    DateFormat dateFormat1 = DateFormat.getDateInstance(DateFormat.FULL, Locale.ITALY);
    String dataStringa = dateFormat1.format(date1);
    System.out.println("Data --> Stringa: " + dataStringa);
    
    //Parsing String --> Date
    //Il parsing corregge automaticamente l'assegnazione dei giorni sbagliati
    String DataString="06/07/1999";//--SHORT
   
    //String DataString="06 lug 1999";//-->MEDIUM
    //String DataString="06 luglio 1999";//-->LONG
    //String DataString="sabato 29 settembre 1979";//-->FULL
    try {
    	DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
    	Date myDate = dateFormat2.parse(DataString);
    	System.out.println("Stringa --> Data: " + dateFormat2.format(myDate));
    } catch (ParseException e) {
    	e.printStackTrace();
    }
    
    //Data e ora odierna (immutabili)
    LocalTime prova = LocalTime.now();
    System.out.println("LocalTime: " + prova);
    LocalDateTime adesso = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    System.out.println("LocalDT: " + adesso);
    
    //Modifica del tempo
    adesso.getDayOfMonth();
    adesso.getMonth();
    adesso.getYear();
    adesso.getHour();
    adesso.getMinute();
    adesso.getSecond();
    //Vista l'immutabilità dobbiamo eseguire la riassegnazione
    adesso = adesso.plusMinutes(4);
    adesso = adesso.minusMinutes(45);
    
    System.out.println("Dopo la modifica: " + adesso);
    
    //Date custom (attenzione alla differenza mm MM + Nomi dei mesi con LL-LLL-LLLL)
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yy -- HH:mm:ss");
	System.out.println("LoaclDT custom: " + adesso.format(formatter));
	
	}

}