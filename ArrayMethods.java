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

    Map<Character, Integer> seenOne = new HashMap<>();
    Map<Character, Integer> seenTwo = new HashMap<>();
    
    for (int i = 0; i < s1.length(); ++i) {
      char ch = s1.charAt(i);
      seenOne.put(ch, seenOne.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < s2.length(); ++i) {
      char ch = s2.charAt(i);
      seenTwo.put(ch, seenTwo.getOrDefault(ch, 0) + 1);
    }
    
    for (int i = 0; i < s1.length(); ++i) {
      char ch = s1.charAt(i);
      if (seenOne.get(ch) != seenTwo.get(ch)) {
        return false;
      }
    }

    return true;
  }
  // 1.3
  public static String urlify(char[] url, int trueLength) {
    int numOfSpaces = characterCount(url, 0, trueLength, ' ');
    int newIndex = trueLength - 1 + numOfSpaces * 2;

    for (int oldIndex = trueLength - 1; oldIndex >= 0; --oldIndex) {
      if (url[oldIndex] == ' ') {
        url[newIndex] = '0';
        url[newIndex - 1] = '2';
        url[newIndex - 2] = '%';
        newIndex -= 3;
      } else {
        url[newIndex] = url[oldIndex];
        newIndex--;
      }
    }

    return new String(url).trim();
  }

  public static int characterCount(char[] charArray, int start, int end, int target) {
    int spaces = 0;
    for (int i = start; i < end; ++i) {
      if (charArray[i] == target) {
        spaces++;
      }
    }

    return spaces;
  }
}