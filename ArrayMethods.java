import java.util.*;

class ArrayMethods {
  // 1.1 Overloaded to work with a list of strings or a single string
  public static boolean isUnique(List<String> list) {
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < list.size(); ++i) {
      if (seen.contains(list.get(i))) {
        return false;
      }
      seen.add(list.get(i));
    }

    return true;
  }

  public static boolean isUnique(String string) {
    Set<Character> seen = new HashSet<>();
    for (int i = 0; i < string.length(); ++i) {
      char ch = string.charAt(i); 
      if (seen.contains(ch)) {
        return false;
      }

      seen.add(ch);
    }

    return true;
  }

  // 1.2
  public static boolean isPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    Map<Character, Integer> seen = new HashMap<>();

    for (int i = 0; i < s1.length(); ++i) {
      char ch = s1.charAt(i);
      seen.put(ch, seen.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < s2.length(); ++i) {
      char ch = s2.charAt(i);
      if (seen.containsKey(ch)) {
        if (seen.get(ch) == 0) {
          seen.remove(ch);
        }
        seen.put(ch, seen.get(ch) - 1);
      }
    }

    return (seen.size() == 0) ? true : false;
  }
}