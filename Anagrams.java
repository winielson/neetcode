import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public List<List<String>> groupAnagramsNaive(String[] strs) {
        HashMap<String, Integer> anagramMap = new HashMap();
        List<List<String>> groupedAnagrams = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
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

        // Count how many times each letter appears in a string
        for (String str : strs) {
            // 1. create an integer array of 26 characters, since there are 26 letters
            int[] letterCount = new int[26];

            // 2. Go through each character in each string and increment the position in the int array given the letter
            for (char c : str.toCharArray()) {
                letterCount[c - 'a']++; // a - a => 97 - 97 = 0; e - a => 101 - 97 = 4
            }
            // 3. Convert int array to be a string so that it can act as the key for the anagramMap
            String key = Arrays.toString(letterCount);
            System.out.println("Key:" + key);
            // 4. Add key to map if not already there
            anagramMap.putIfAbsent(key, new ArrayList<>());
            // 5. Add string to the key's value (which is an array of strings)
            anagramMap.get(key).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        Anagrams instance = new Anagrams();
        String[] input = {"act", "pots", "tops", "cat", "stop", "hat"};
        List<List<String>> result = instance.groupAnagramsBetter(input);
        System.out.println("Answer: " + result.toString());
    }
}




