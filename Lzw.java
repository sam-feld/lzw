import java.util.*;
//Takes a command line argument.
//If the argument starts with a number, the program runs decompress, otherwise it runs compress.
public class Lzw {
    public static boolean isNumeric(char c){
        return 48 <= c && c <= 57;
}
    public static void compress(String file){
        HashMap<String, Integer> patterns = new HashMap<>();
        patterns.put("A",0);
        patterns.put("C",1);
        patterns.put("G",2);
        patterns.put("T",3);
        int index = 3;
        StringBuilder currentPattern = new StringBuilder();
        String newPattern = "";
        for (int i = 0; i < file.length(); i++) {
            currentPattern.append(file.charAt(i));
            newPattern = currentPattern.toString();
            if (!patterns.containsKey(newPattern)) {
                index++;//increment the code number
                patterns.put(newPattern, index);
                String oldPattern = newPattern.substring(0, newPattern.length()-1);
                System.out.print( patterns.get(oldPattern) + " ");
                currentPattern.setLength(0);//clear the pattern
                i--; //continue from last character of new pattern
} }
        System.out.print(patterns.get(newPattern));
    }
    public static void decompress(ArrayList<Integer> compressedFile){
        StringBuilder result = new StringBuilder();
        StringBuilder newPattern = new StringBuilder();
        ArrayList<String> foundPatterns = new ArrayList<>();
        foundPatterns.add("A");
        foundPatterns.add("C");
        foundPatterns.add("G");
        foundPatterns.add("T");
        //add first pattern to result
        String currentPattern = foundPatterns.get(compressedFile.get(0));
        result.append(currentPattern);
        String prevPattern = currentPattern;
        //add remaining patterns to result
        for (int i = 1; i < compressedFile.size(); i++) {
            int number = compressedFile.get(i);
            if (number < foundPatterns.size()) {
                newPattern.append(prevPattern).append(foundPatterns.get(number).charAt(0));
                currentPattern = foundPatterns.get(number);
            } else {
                newPattern.append(prevPattern).append(prevPattern.charAt(0));
                currentPattern = newPattern.toString();
}
            result.append(currentPattern);
            foundPatterns.add(newPattern.toString());
            newPattern.setLength(0);
            prevPattern = currentPattern;
        }
        System.out.println(result);
    }
public static ArrayList<Integer> ConvertToIntArrayList(String[] s){
ArrayList<Integer> compressedCode = new ArrayList<>();
        for (String string : s) {
            compressedCode.add(Integer.parseInt(string));
        }
        return compressedCode;
    }
    public static void main(String[] args){
        if (isNumeric(args[0].charAt(0))) {
            decompress(ConvertToIntArrayList(args));
        } else {
            compress(args[0]);
} }
}