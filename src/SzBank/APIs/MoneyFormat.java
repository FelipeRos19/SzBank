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
            return String.valueOf(String.valueOf(Main.format(valor / 1000000.0))) + "M"; //Milhão
        }
        if (valor < 1.0E12) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E9))) + "B"; //Bilhão
        }
        if (valor < 1.0E15) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E12))) + "T"; //Trilhão
        }
        if (valor < 1.0E18) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E15))) + "Q"; //Quadrilhão
        }
        if (valor < 1.0E21) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E18))) + "QQ"; //Quintilhão
        }
        if (valor < 1.0E24) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E21))) + "S"; //Sextilhão
        }
        if (valor < 1.0E27) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E24))) + "SS"; //Septilhão
        }
        if (valor < 1.0E30) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E27))) + "OC"; //Octilhão
        }
        if (valor < 1.0E33) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E30))) + "N"; //Nonilhão
        }
        if (valor < 1.0E36) {
            return String.valueOf(String.valueOf(Main.format(valor / 1.0E33))) + "D"; //Decilhão
        }
        if (valor < 1.0E39) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E36))) + "UD"; //Undecilhão
        }
        if (valor < 1.0E42) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E39))) + "DD"; //Duodecilhão
        }
        if (valor < 1.0E45) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E42))) + "TD"; //Tredecilhão
        }      
        if (valor < 1.0E48) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E45))) + "QD"; //Quatuordecilhão
        }
        if (valor < 1.0E51) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E48))) + "QID"; //Quindecilhão
        }
        if (valor < 1.0E54) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E51))) + "SD"; //Sexdecilhão
        }
        if (valor < 1.0E57) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E54))) + "SPD"; //Septendecilhão
        }
        if (valor < 1.0E60) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E57))) + "OD"; //Octodecilhão
        }
        if (valor < 1.0E63) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E60))) + "ND"; //Novendecilhão 
        }
        if (valor < 1.0E66) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E63))) + "V"; //Vigintilhão
        }
        if (valor < 1.0E69) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E66))) + "UV"; //Unvigintilhão
        }
        if (valor < 1.0E72) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E69))) + "DV"; //Duovigintilhão
        }
        if (valor < 1.0E75) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E72))) + "TV"; //Trevigintilhão
        }
        if (valor < 1.0E78) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E75))) + "QV"; //Quatuorvigintilhão
        }
        if (valor < 1.0E81) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E78))) + "QIV"; //Quinvigintilhão
        }
        if (valor < 1.0E84) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E81))) + "SV"; //Sexvigintilhão
        }
        if (valor < 1.0E87) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E84))) + "SPV"; //Septenvigintilhão
        }
        if (valor < 1.0E90) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E87))) + "OV"; //Octovigintilhão
        }
        if (valor < 1.0E93) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E90))) + "NV"; //Novemvigintilhão
        }
        if (valor < 1.0E96) {
        	return String.valueOf(String.valueOf(Main.format(valor / 1.0E93))) + "TT"; //Trigentilhão
        }
        return String.valueOf(valor);
	}
}