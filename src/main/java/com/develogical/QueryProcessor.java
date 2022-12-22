package com.develogical;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class QueryProcessor {

    public String process(String query) {

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("your name")) {
            return "Cat";
        }
        if (query.toLowerCase().contains("largest")) {
            String s = query.split(": ")[1].replace("?", "");
            String[] nums = s.split(", ");
            List<Integer> int_nums = Arrays.stream(nums).map(Integer::valueOf).collect(Collectors.toList());
            return Collections.max(int_nums).toString();
        }
        if (query.toLowerCase().contains("plus")) {
            String[] splits = query.split(" plus ");
            splits[0] = splits[0].replace("What is ", "");
            splits[1] = splits[1].replace("?", "");
            int num = Integer.parseInt(splits[0]) + Integer.parseInt(splits[1]);
            return String.valueOf(num);
        }

        return "";
    }
    
}
