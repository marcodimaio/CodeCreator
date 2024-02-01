package it.capgemini.archetype.srv.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class CustomDateUtils extends DateUtils {
	private static String[] MONTHS = { "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto",
			"Settembre", "Ottobre", "Novembre", "Dicembre" };

	public static String PATTERN_YYYYMMDD = "yyyyMMdd";

	public static final Calendar toCalendar(String day, String month, String year) {
		Calendar calendar = Calendar.getInstance();

		if (StringUtils.isNotEmpty(day) && StringUtils.isNotEmpty(month) && StringUtils.isNotEmpty(year)) {
			calendar.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}

		return calendar;
	}

	public static final XMLGregorianCalendar toXmlGregorianCalendar(GregorianCalendar calendar)
			throws DatatypeConfigurationException {
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
	}

	public static final Calendar toCalendar(XMLGregorianCalendar calendar) {

		if (calendar != null)
			return calendar.toGregorianCalendar();

		return null;
	}

	public static final Map<String, String> getDays() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("", "Giorno");

		for (int i = 1; i <= 31; i++) {
			map.put(String.valueOf(i), String.valueOf(i));
		}
		return map;
	}

	public static final Map<String, String> getMonths() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("", "Mese");

		// Ciclo da 1 a 12 perchè nel lato fronted ( javascript ) la validazione
		// dei mesi è da 1 a 12
		for (int i = 1; i <= 12; i++) {
			map.put(String.valueOf(i), MONTHS[i - 1]);
		}
		return map;
	}

	public static final Map<String, String> getYears(int fromYear, int toYear) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("", "Anno");
		for (int i = fromYear; i <= toYear; i++) {
			map.put(String.valueOf(i), String.valueOf(i));
		}

		return map;
	}

	public static final String toString(Date data, String pattern) {
		String strData = new SimpleDateFormat(pattern).format(data);

		return strData;
	}

	public static final Long toLong(Date data, String pattern) {
		String strData = new SimpleDateFormat(pattern).format(data);

		return new Long(strData);
	}

	public static final int getDay(Calendar date) {
		return date.get(Calendar.DAY_OF_MONTH);
	}

	public static final int getMonth(Calendar date) {
		return date.get(Calendar.MONTH) + 1;
	}

	public static final int getYear(Calendar date) {
		return date.get(Calendar.YEAR);
	}
}
