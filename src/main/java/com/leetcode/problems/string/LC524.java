package com.leetcode.problems.string;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/9/14 10:14
 */
public class LC524 extends TestCase {

    public void test1() {
        String s = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ettphsiunoglotjlccurlre");
        dictionary.add("ntgcykxhdfescxxypyew");

        System.out.println(findLongestWord(s, dictionary));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
        for (String str : dictionary) {
            System.out.println(str);
        }
        for (String d : dictionary) {
            int l = 0;
            int sl = 0;
            List<Integer> list = new ArrayList<>();
            while (l < d.length() && sl < s.length()) {
                while (sl < s.length() && s.charAt(sl) != d.charAt(l)) {
                    sl++;
                }
                if (sl >= s.length()) {
                    break;
                }
                list.add(sl);
                sl++;
                l++;
            }
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list) {
                sb.append(s.charAt(integer));
            }
            System.out.println(sb);
            System.out.println("--------------");
            System.out.println(l);
            System.out.println(d.length());
            if (l == d.length()) {
                return d;
            }
        }
        return "";
    }
}