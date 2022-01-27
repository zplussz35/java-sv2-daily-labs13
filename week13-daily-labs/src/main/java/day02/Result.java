package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Result {
    private String correctAnswer;
    private Map<String, List<String>> results= new LinkedHashMap<>();

    private void readFromFile(String filename){
        try(BufferedReader br = Files.newBufferedReader(Path.of(filename))){

            correctAnswer=br.readLine();

            String line;
            while((line=br.readLine())!=null){
                String[] temp=line.split(" ");
                if(!results.containsKey(temp[0])){
                    results.put(temp[0],new ArrayList<>());
                }
                for (Map.Entry<String,List<String>> actual: results.entrySet()) {
                    if(actual.getKey().equals(temp[0])){
                        actual.getValue().add(temp[1]);
                    }
                }
            }
        }catch (IOException ioe){
            throw new IllegalStateException("Cannot reach file!",ioe);
        }
    }

    private boolean isCorrect(String code, int questionNumber){
        for (Map.Entry<String,List<String>> actual: results.entrySet()) {
            if(actual.getKey().equals(code)){
                if(actual.getValue().get(questionNumber-1).equals(String.valueOf(correctAnswer.toCharArray()[questionNumber-1]))){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public String searchBest(String filename){
        readFromFile(filename);
        int result=0;
        int maxResult=-100;
        String maxCode="";
        for (Map.Entry<String,List<String>> actual:results.entrySet()) {
            for (int i = 1; i <6 ; i++) {
                if(isCorrect(actual.getKey(),i)){
                    result+=i;
                }else if(!actual.getValue().get(i-1).equals("X")){
                    result-=2;
                }
            }
            if(result>=maxResult){
                maxResult=result;
                maxCode= actual.getKey();
            }
        }
        return maxCode;
    }


    public static void main(String[] args) {
        Result r = new Result();
        String result=r.searchBest("src/main/resources/result.txt");
        System.out.println(r.correctAnswer);
        System.out.println(r.results);
        System.out.println("result: "+result);
    }
}
