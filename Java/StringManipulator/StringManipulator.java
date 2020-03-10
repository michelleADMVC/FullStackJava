
public class StringManipulator {

	public String trimAndConcat(String a, String b) {
		String res ="";
		res = a.trim()+ b.trim();
		return res;
	}
	
	public String getIndexOrNull(String cadena, char letter){
		String res = "";
		if (cadena.indexOf(letter) != -1) {
			res = String.valueOf(cadena.indexOf(letter));
			return res;
		}else {
			return null;
		}
		
	}
	public String getIndexOrNull(String word, String substring) {
		String res = "";
		if (word.indexOf(substring) != -1) {
			res = String.valueOf(word.indexOf(substring));
			return res;
		}else {
			return null;
		}
		
	}
	
	public String concatSubstring(String str, int init, int end, String newStr) {
		char[] aCaracteres = str.toCharArray();
		String first = "";
		String last = "";
		for (int i = 0; i < init; i++) {
			first += aCaracteres[i];
		}
		for (int i = end; i < str.length(); i++) {
			last += aCaracteres[i];
		}
		
		return first + newStr +last;
	}

}