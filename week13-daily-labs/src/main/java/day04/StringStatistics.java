package day04;

import java.util.HashMap;
import java.util.Map;

public class StringStatistics {


    public Map<Character,Integer> getMGH(String input){
        Map<Character,Integer> result = new HashMap<>();
        for (Character c:input.toCharArray()) {
            if(c.equals('a')||c.equals('e')||c.equals('i')||c.equals('o')||c.equals('u')||
                    c.equals('A')||c.equals('E')||c.equals('I')||c.equals('O')||c.equals('U')){
                if(!result.containsKey(c)){
                    result.put(c,1);
                }
                else{
                    result.put(c,result.get(c)+1);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        StringStatistics statistics = new StringStatistics();
        System.out.println(statistics.getMGH("English is my favourite language!"));
    }
}
