package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregator {

    public List<TransferPerClient> readTransfers(Path path){
            List<String> lines = readLines(path);
            return summerise(lines);
    }

    private List<String> readLines(Path path){
        try{
            return Files.readAllLines(path);
        }catch (IOException ioe){
            throw new IllegalStateException("Cannot reach file!",ioe);
        }
    }

    private List<TransferPerClient> summerise(List<String> lines) {
        Map<String,TransferPerClient>  transfers= new TreeMap<>();
        for (String line:lines) {
            String[] parts=line.split(",");
            String sourceClientId=parts[0];
            String targetClientId=parts[1];
            int amount=Integer.parseInt(parts[2]);

            TransferPerClient source= transfers.computeIfAbsent(sourceClientId,
                    k -> new TransferPerClient(sourceClientId));
            source.decreaseSum(amount);

            TransferPerClient target=transfers.computeIfAbsent(targetClientId,
                    k -> new TransferPerClient(targetClientId));
            target.increaseSum(amount);
        }
        return transfers.values().stream().toList();
    }


    public static void main(String[] args) {
        TransferAggregator transferAgg=new TransferAggregator();
        List<TransferPerClient> result=transferAgg.readTransfers(Paths.get("src/main/resources/transfer.csv"));
        for (TransferPerClient t:result) {
            System.out.println(t);
        }
    }


}
