import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        String[] arr = {"act","pots","tops","cat","stop","hat"};
        var sol = new Main().groupAnagrams(arr);
        Arrays.stream(arr).forEach(System.out::println);

        new HashMap<>()
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