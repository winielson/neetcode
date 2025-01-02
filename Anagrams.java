import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public List<List<String>> groupAnagramsNaive(String[] strs) {
        HashMap<String, Integer> anagramMap = new HashMap();
        List<List<String>> groupedAnagrams = new ArrayList<>();

        for(int i = 0; i < strs.length; i++) {
            // Step 1: Convert string to character array
            char[] charArray = strs[i].toCharArray();
            // Step 2: Sort the character array
            Arrays.sort(charArray);
            // Step 3: Convert the sorted character array back to a string
            String sortedString = new String(charArray);

            if (anagramMap.containsKey(sortedString)) {
                // Get index of the key in the groupedAnagrams array and push
                groupedAnagrams.get(anagramMap.get(sortedString)).add(strs[i]);
            } else {
                // Add sorted value to hashmap
                anagramMap.put(sortedString, groupedAnagrams.size());
                // Push a new array into the 2d array with the new value
                groupedAnagrams.add(new ArrayList<>(List.of(strs[i])));
            }
        }

        return groupedAnagrams;
    }

    public List<List<String>> groupAnagramsBetter(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap();

        for(String str: strs) {
            int[] letterCount = new int[26];

            for(char c: str.toCharArray()) {
                letterCount[c - 'a']++; // a - a => 97 - 97 = 0; e - a => 101 - 97 = 4
            }
            String key = Arrays.toString(letterCount);
            System.out.println("Key:"+key);
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        Anagrams instance = new Anagrams();
        String[] input = {"act","pots","tops","cat","stop","hat"};
        List<List<String>> result = instance.groupAnagramsBetter(input);
        System.out.println("Answer: " + result.toString());
    }
}




