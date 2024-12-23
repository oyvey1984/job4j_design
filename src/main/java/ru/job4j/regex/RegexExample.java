package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Job4j", Pattern.CASE_INSENSITIVE);

        String text = "Я учусь на курсе Job4j";
        Matcher matcher = pattern.matcher(text);
        boolean isPresent = matcher.find();
        System.out.println(isPresent);

        String text1 = "Job4j и Job4j и Job4j";
        Matcher matcher1 = pattern.matcher(text1);
        while (matcher1.find()) {
            System.out.println("Найдено совпадение");
        }

        String text2 = "Job4j1 и Job4j2 и Job4j3";
        Matcher matcher2 = pattern.matcher(text2);
        while (matcher2.find()) {
            System.out.println("Найдено совпадение: " + matcher2.group());
        }

        String text3 = "Job4j1 и Job4j2 и Job4j3";
        Matcher matcher3 = pattern.matcher(text3);
        while (matcher3.find()) {
            System.out.println("Найдено совпадение. iStart: " + matcher3.start()
                    + " iEnd: " + matcher3.end());
        }

        String textOne = "Job4j";
        Matcher matcherOne = pattern.matcher(textOne);
        boolean isPresentOne = matcherOne.matches();
        System.out.println(isPresentOne);

        String textTwo = "job4j";
        Matcher matcherTwo = pattern.matcher(textTwo);
        boolean isPresentTwo = matcherTwo.matches();
        System.out.println(isPresentTwo);

        Pattern pattern4 = Pattern.compile("123");
        String text4 = "1231 и 1232 и 1233";
        Matcher matcher4 = pattern4.matcher(text4);
        String result4 = matcher4.replaceAll("Job4j");
        System.out.println(result4);
    }
}
