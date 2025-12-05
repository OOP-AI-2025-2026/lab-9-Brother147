package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    // ----------------- TASK 1 -----------------
    // removeShorterStrings
    public void removeShorterStrings(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i += 2) {
            if (i + 1 < list.size()) {
                String first = list.get(i);
                String second = list.get(i + 1);

                if (first.length() < second.length()) {
                    // оставляем второй (длиннее или равен при tie?)
                    result.add(second);
                } else if (first.length() > second.length()) {
                    // оставляем первый
                    result.add(first);
                } else {
                    // одинаковая длина — по условию тестов оставляем ВТОРОЙ
                    result.add(second);
                }
            } else {
                // нечётный "хвост" — просто добавляем последний элемент
                result.add(list.get(i));
            }
        }

        list.clear();
        list.addAll(result);
    }

    // ----------------- TASK 2 -----------------
    // stutter
    public void stutter(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        List<String> result = new ArrayList<>(list.size() * 2);
        for (String s : list) {
            result.add(s);
            result.add(s);
        }

        list.clear();
        list.addAll(result);
    }

    // ----------------- TASK 3 -----------------
    // switchPairs
    public void switchPairs(List<String> list) {
        if (list == null || list.size() < 2) {
            return;
        }

        for (int i = 0; i + 1 < list.size(); i += 2) {
            String tmp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tmp);
        }
    }

    // ----------------- TASK 4 -----------------
    // removeDuplicates
    public void removeDuplicates(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        Set<String> seen = new LinkedHashSet<>();
        for (String s : list) {
            if (!seen.contains(s)) {
                seen.add(s);
            }
        }

        list.clear();
        list.addAll(seen);
    }

    // ----------------- TASK 5 -----------------
    // markLength4
    public void markLength4(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (s.length() == 4) {
                result.add("****");
            }
            result.add(s);
        }

        list.clear();
        list.addAll(result);
    }

    // ----------------- TASK 6 -----------------
    // isPalindrome
    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null) {
            return true;
        }

        // Не трогаем саму очередь: копируем в список
        List<Integer> list = new ArrayList<>(queue);
        int n = list.size();

        for (int i = 0; i < n / 2; i++) {
            if (!Objects.equals(list.get(i), list.get(n - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    // ----------------- TASK 7 -----------------
    // reorder (отсортировать очередь по возрастанию)
    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) {
            return;
        }

        List<Integer> list = new ArrayList<>(queue);
        Collections.sort(list);
        queue.clear();
        queue.addAll(list);
    }

    // ----------------- TASK 8 -----------------
    // rearrange (сначала все чётные, затем все нечётные, с сохранением порядка)
    public void rearrange(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) {
            return;
        }

        List<Integer> src = new ArrayList<>(queue);
        queue.clear();

        // сначала чётные
        for (Integer x : src) {
            if (x % 2 == 0) {
                queue.add(x);
            }
        }
        // затем нечётные
        for (Integer x : src) {
            if (x % 2 != 0) {
                queue.add(x);
            }
        }
    }

    // ----------------- TASK 9 -----------------
    // maxLength
    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return 0;
        }

        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    // ----------------- TASK 10 -----------------
    // removeEvenLength
    public void removeEvenLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() % 2 == 0) {
                it.remove();
            }
        }
    }

    // ----------------- TASK 11 -----------------
    // numInCommon
    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty()) {
            return 0;
        }

        Set<Integer> s1 = new HashSet<>(list1);
        Set<Integer> s2 = new HashSet<>(list2);

        s1.retainAll(s2); // пересечение множеств
        return s1.size();
    }

    // ----------------- TASK 12 -----------------
    // isUnique
    public boolean isUnique(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }

        Collection<String> values = map.values();
        Set<String> set = new HashSet<>(values);
        return set.size() == values.size();
    }

    // ----------------- TASK 13 -----------------
    // intersect
    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        if (map1 == null || map2 == null || map1.isEmpty() || map2.isEmpty()) {
            return result;
        }

        for (Map.Entry<String, Integer> e : map1.entrySet()) {
            String key = e.getKey();
            Integer val = e.getValue();
            if (map2.containsKey(key) && Objects.equals(val, map2.get(key))) {
                result.put(key, val);
            }
        }

        return result;
    }

    // ----------------- TASK 14 -----------------
    // reverse
    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        if (map == null || map.isEmpty()) {
            return result;
        }

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            Integer key = e.getKey();
            String value = e.getValue();

            Integer current = result.get(value);
            if (current == null || key > current) {
                result.put(value, key);
            }
        }

        return result;
    }

    // ----------------- TASK 15 -----------------
    // rarest
    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            // в заданиях пустой Map не проверяется, но на всякий случай вернём 0
            return 0;
        }

        // value -> сколько раз встречается
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer value : map.values()) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        int bestValue = 0;
        int bestCount = Integer.MAX_VALUE;
        boolean first = true;

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int value = e.getKey();
            int count = e.getValue();

            if (count < bestCount || (count == bestCount && value < bestValue)) {
                bestCount = count;
                bestValue = value;
                first = false;
            } else if (first) {
                bestValue = value;
                bestCount = count;
                first = false;
            }
        }

        return bestValue;
    }

    // ----------------- TASK 16 -----------------
    // maxOccurrences
    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;

        for (Integer x : list) {
            int c = freq.getOrDefault(x, 0) + 1;
            freq.put(x, c);
            if (c > max) {
                max = c;
            }
        }

        return max;
    }

}

