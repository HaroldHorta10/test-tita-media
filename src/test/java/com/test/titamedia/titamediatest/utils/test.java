package com.test.titamedia.titamediatest.utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test {

    public static void main(String[] args) {
       List<String> letter = List.of("abc", "ujk", "zzy", "ahj", "aaz", "oip");
        List<Integer> number = new ArrayList<>();
        letter.forEach(s -> number.add(IntStream
                .range(0, s.length())
                .filter(i -> s.charAt(i) != 164)
                .map(i -> s.charAt(i) - 96)
                .sum()));
        Collections.sort(number);

        System.out.println(number);

        System.out.println(getArrayDiv(3));

        List<Integer> numbers = getArrayOrder();
        System.out.println("La cantidad menor es: " + numbers.stream().findFirst().orElse(0));

    }

    private static List<Integer> getArrayOrder() {
        List<Integer> numbers = new ArrayList<>();
        getArrayDiv(3).forEach(strings -> numbers.add(strings.stream().map(Integer::parseInt).reduce(Integer::sum).orElse(0)));
        Collections.sort(numbers);
        return numbers;
    }

    private static List<List<String>> getArrayDiv(double tan) {
        List<Integer> shorts = List.of(1, 4, 6, 7, 8, 8, 127, 89);
        int dv = (int) Math.ceil((shorts.size() / tan));
        List<List<String>> result = new ArrayList<>();
        int from = 0;
        int to;
        for (int i = 0; i < tan; i++) {
            to = dv + from;
            List<Object> list = Arrays.stream(Arrays.copyOfRange(shorts.toArray(), from, to)).collect(Collectors.toList());
            List<String> strings = list.stream()
                    .map(object -> Objects.toString(object, null)).collect(Collectors.toList());
            from = to;
            strings.removeIf(Objects::isNull);
            result.add(strings);
        }
        return result;
    }


}
