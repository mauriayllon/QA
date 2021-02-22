package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class CalcularFecha {
    public String calcularFecha(int day, String month, int year, int hour, int minute, int second) {
        String msg = null;
        List<String> months = new ArrayList<>();
        months.add("Enero");
        months.add("Febrero");
        months.add("Marzo");
        months.add("Abril");
        months.add("Mayo");
        months.add("Junio");
        months.add("Julio");
        months.add("Agosto");
        months.add("Septiembre");
        months.add("Octubre");
        months.add("Noviembre");
        months.add("Diciembre");
        if (day < 1 || day > 31) {
            msg = "Invalid day: " + day;
        } else if (hour < 0 || hour > 23) {
            msg = "Invalid hour: " + hour;
        } else if (minute < 0 || minute > 59) {
            msg = "Invalid minute: " + minute;
        } else if (second < 0 || second > 59) {
            msg = "Invalid second: " + second;
        } else if (!months.contains(month)) {
            msg = "Invalid month: " + month;
        } else if (year < 0) {
            msg = "Invalid year: " + year;
        }  else if (month.equals("Febrero") && (day == 30 || day == 31)) {
            msg = "Invalid day: " + day;
        } else if (month.equals("Febrero") && day == 29 && year % 4 != 0) {
            msg = "Invalid day: " + day;
        } else if (day == 31 && (month.equals("Abril") || month.equals("Junio") || month.equals("Septiembre") || month.equals("Noviembre"))) {
            msg = "Invalid day: " + day;
        } else if (second != 59) {
            int temp = second + 1;
            msg = day + " " + month + " " + year + " " + hour + " " + minute + " " + temp;
        } else if (minute != 59) {
            int temp = minute + 1;
            msg = day + " " + month + " " + year + " " + hour + " " + temp + " 00";
        } else if (hour != 23) {
            int temp = hour + 1;
            msg = day + " " + month + " " + year + " " + temp + " 00 00";
        } else if (day < 28) {
            int temp = day + 1;
            msg = temp + " " + month + " " + year + " 00 00 00";
        } else if (day == 28 && month.equals("Febrero")) {
            if (year % 4 != 0) {
                msg = "1 Marzo " + year + " 00 00 00";
            } else {
                msg = "29 Febrero " + year + " 00 00 00";
            }
        } else if (day == 28) {
            int temp = day + 1;
            msg = temp + " " + month + " " +months.get(months.indexOf(month)+1) + year + " 00 00 00";
        } else if (day == 29 && month.equals("Febrero")) {
            msg = "1 Marzo " + year + " 00 00 00";
        } else if (day == 29) {
            int temp = day + 1;
            msg = temp + " " + month + " " + year + " 00 00 00";
        } else if (day == 30 && (month.equals("Abril") || month.equals("Junio") || month.equals("Septiembre") || month.equals("Noviembre"))) {
            msg = "1 " + months.get(months.indexOf(month)+1) + " " + year + " 00 00 00";
        } else if (day == 30) {
            int temp = day + 1;
            msg = temp + " " + month + " " + year + " 00 00 00";
        } else if (day == 31 && (month.equals("Enero") || month.equals("Marzo") || month.equals("Mayo") || month.equals("Julio") || month.equals("Agosto") || month.equals("Octubre"))) {
            msg = "1 " + months.get(months.indexOf(month)+1) + " " + year + " 00 00 00";
        } else if (day == 31 && (month.equals("Diciembre"))) {
            int temp = year + 1;
            msg = "1 Enero " + temp + " 00 00 00";
        }
        return msg;
    }
}