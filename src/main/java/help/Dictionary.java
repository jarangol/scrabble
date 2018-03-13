package help;

//read files
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import java.util.HashSet;
import java.util.Set;

public class Dictionary{
    Set<String> wordsSet = new HashSet<>();
    public Dictionary(){
    	wordsSet.add("hola");
    	ClassLoader classLoader = getClass().getClassLoader();
    	File file = new File(classLoader.getResource("file/twl06.txt").getFile());

    	try (Scanner scanner = new Scanner(file)) {
    		while (scanner.hasNextLine()) {
    			String line = scanner.nextLine();
    			wordsSet.add(line);
    		}
    		scanner.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
//    	
    }

    public boolean contains(String word){
        if (wordsSet.contains(word))
        	return true;
        else
        	return false;
//    	return Integer.toString(wordsSet.size());
    }
}

