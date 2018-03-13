package help;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
 

@RestController
public class HelpController {
	
	@RequestMapping("/scrabble")
	public String help(@RequestParam(value="list", defaultValue="") String list) throws IOException, URISyntaxException {
		if (list.isEmpty())
			return "Parametro list vacio";
		else {
			list = list.replace(",","");
			list = list.replace(" ","");
			Set<String> words = permute(list);
			Dictionary dc = new Dictionary();		
			for(String s:words) {
				if(dc.contains(s))
					return s;
			}
			
			return "No se pudo formar una palabra valida";
		} 
	}
	
	public static Set<String> permute(String str){
		Set<String> permutations = new HashSet<String>();
	    HashMap<Integer, Set<String>> hmap = new HashMap<Integer, Set<String>>();
		
	    if (str == null) {
			return null;
		} else if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = permute(rem);
		
		for(String newStr : words) {
			for (int i = 0; i <= newStr.length(); i++) {
				String newWord = charAdd(newStr, firstChar, i);
				permutations.add(newWord);
			}
		}
		permutations.addAll(words);
		return permutations;
	}
	
	public static String charAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}
}


