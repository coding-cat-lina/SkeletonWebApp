package com.develogical;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class QueryProcessor {

    public static boolean isRootInteger(int number, int root) {
        double dResult = Math.pow(number, 1.0 / root);

        if ((dResult == Math.floor(dResult)) && !Double.isInfinite(dResult)) {
            return true;
        }
        return false;
    }

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
        if (query.toLowerCase().contains("minus")) {
            String[] splits = query.split(" minus ");
            splits[0] = splits[0].replace("What is ", "");
            splits[1] = splits[1].replace("?", "");
            int num = Integer.parseInt(splits[0]) - Integer.parseInt(splits[1]);
            return String.valueOf(num);
        }
        if (query.toLowerCase().contains("multiplied")) {
            String[] splits = query.split(" multiplied by ");
            splits[0] = splits[0].replace("What is ", "");
            splits[1] = splits[1].replace("?", "");
            int num = Integer.parseInt(splits[0]) * Integer.parseInt(splits[1]);
            return String.valueOf(num);
        }

        if (query.toLowerCase().contains("both a square and a cube")) {
            String replace = query.replace("Which of the following numbers is both a square and a cube: ", "").replace("?", "");
            String[] nums = replace.split(", ");
            List<Integer> int_nums = Arrays.stream(nums).map(Integer::valueOf).collect(Collectors.toList());
            Optional<Integer> result = int_nums.stream().filter(a -> isRootInteger(a, 2) && Math.round(Math.cbrt(a))==Math.cbrt(a)).findFirst();
            return String.valueOf(result.get());
        }

        return "";
    }
    
}
