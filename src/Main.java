import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


public class Codec { // CONCEPT OF DELIMITER
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            encodedString.append(s);
            encodedString.append("π");
        }
        return encodedString.toString();
    }

    public List<String> decode(String s) {
        String[] decodedStrings = s.split("π", -1); //-1 is limit parameter to ensure trailing empty strings are included
        // just accounts for  "" situation otherwise won't return anything
        return new ArrayList<>(Arrays.asList(decodedStrings).subList(0, decodedStrings.length - 1));
        //We remove the last element because it's an empty string resulting from the 'content' after the final delimiter
    }
}


//MINE
//public class Codec {
//    ArrayList<Integer> l = new ArrayList<>();
//
//    // Encodes a list of strings to a single string.
//    public String encode(List<String> strs) {
//        int count = 0;
//        String combined = "";
//        for (String s : strs) {
//            count += strs.size();
//            l.add(count);
//            combined += s;
//        }
//        decode(combined);
//        return combined;
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        List<String> separated = new ArrayList<>();
//        int priorEnd = -1;
//        while(!l.isEmpty()){
//            int wordEnd = l.remove(0);
//            separated.add(s.substring(priorEnd+1, wordEnd+1));
//            priorEnd = wordEnd;
//        }
//        return separated;
//    }
//}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));


// super limited by decode only accepting string. want to pass array or intervals so
//start is array[i] and end is array[i+1] non-inclusive substring and add to list but can't
// pass array. can make it in the class though outside methods so its accessible to both? lets try