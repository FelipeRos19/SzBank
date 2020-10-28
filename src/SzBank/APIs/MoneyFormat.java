package SzBank.APIs;

import SzBank.Main;

public class MoneyFormat {
	
	public static String format(final Double valor) {
        if (valor < 1000.0) {
            return Main.format(valor);
        }
        if (valor < 1000000.0) {
            return String.valueOf(String.valueOf(Main.format(valor / 1000.0))) + "k"; //Mil
        }
        if (valor < 1.0E9) {
            return String.valueOf(String.valueOf(Main.format(valor / 1000000.0))) + "M"; //Milh�o
        }
        if (valor < 1.0E12) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E9))) + "B"; //Bilh�o
        }
        if (valor < 1.0E15) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E12))) + "T"; //Trilh�o
        }
        if (valor < 1.0E18) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E15))) + "Q"; //Quadrilh�o
        }
        if (valor < 1.0E21) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E18))) + "QQ"; //Quintilh�o
        }
        if (valor < 1.0E24) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E21))) + "S"; //Sextilh�o
        }
        if (valor < 1.0E27) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E24))) + "SS"; //Septilh�o
        }
        if (valor < 1.0E30) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E27))) + "OC"; //Octilh�o
        }
        if (valor < 1.0E33) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E30))) + "N"; //Nonilh�o
        }
        if (valor < 1.0E36) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E33))) + "D"; //Decilh�o
        }
        if (valor < 1.0E39) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E36))) + "UD"; //Undecilh�o
        }
        if (valor < 1.0E42) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E39))) + "DD"; //Duodecilh�o
        }
        if (valor < 1.0E45) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E42))) + "TD"; //Tredecilh�o
        }      
        if (valor < 1.0E48) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E45))) + "QD"; //Quatuordecilh�o
        }
        if (valor < 1.0E51) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E48))) + "QID"; //Quindecilh�o
        }
        if (valor < 1.0E54) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E51))) + "SD"; //Sexdecilh�o
        }
        if (valor < 1.0E57) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E54))) + "SPD"; //Septendecilh�o
        }
        if (valor < 1.0E60) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E57))) + "OD"; //Octodecilh�o
        }
        if (valor < 1.0E63) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E60))) + "ND"; //Novendecilh�o 
        }
        if (valor < 1.0E66) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E63))) + "V"; //Vigintilh�o
        }
        if (valor < 1.0E69) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E66))) + "UV"; //Unvigintilh�o
        }
        if (valor < 1.0E72) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E69))) + "DV"; //Duovigintilh�o
        }
        if (valor < 1.0E75) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E72))) + "TV"; //Trevigintilh�o
        }
        if (valor < 1.0E78) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E75))) + "QV"; //Quatuorvigintilh�o
        }
        if (valor < 1.0E81) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E78))) + "QIV"; //Quinvigintilh�o
        }
        if (valor < 1.0E84) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E81))) + "SV"; //Sexvigintilh�o
        }
        if (valor < 1.0E87) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E84))) + "SPV"; //Septenvigintilh�o
        }
        if (valor < 1.0E90) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E87))) + "OV"; //Octovigintilh�o
        }
        if (valor < 1.0E93) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E90))) + "NV"; //Novemvigintilh�o
        }
        if (valor < 1.0E96) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E93))) + "TT"; //Trigentilh�o
        }
        return String.valueOf(valor);
	}
}