import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String args[]){
        String[] arr = {"act","pots","tops","cat","stop","hat"};
        var sol = new Solution().groupAnagrams(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
                Arrays.stream(strs)
                        .collect(Collectors.groupingBy(s -> {
                            int[] count = new int[26];
                            for (char c : s.toCharArray()) {
                                count[c - 'a']++;
                            }
                            return Arrays.toString(count);
                        }))
                        .values()
        );
    }
}