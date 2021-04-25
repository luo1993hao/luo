package org.luo.practice.stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class FlatMapTest {
    public static void main(String[] args) {
        List<String> strings = Lists.newArrayList("hello","world");
        List<String[]> list = strings.stream().map(word->word.split("")).distinct().collect(toList());
        System.out.println(list);
        List<String> uniqueCharacters= strings.stream().map(x -> x.split("11")).flatMap(Arrays::stream).distinct().collect(toList());
        Function<String, Integer> strToInt = Integer::parseInt;
    }
}
