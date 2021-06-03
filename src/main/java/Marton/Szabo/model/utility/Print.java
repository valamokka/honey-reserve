package Marton.Szabo.model.utility;

import Marton.Szabo.model.entity.Honey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Print {

    public static void writeToFile (List<Honey> honeys, String totalIncome, String totalProfit ) {
        List<String> honeysToPrint = honeys.stream().map(Honey::toStringForPrintingSummary).collect(Collectors.toList());
        honeysToPrint.add("Osszes bevetel: "+totalIncome);
        honeysToPrint.add("Osszes profit: "+totalProfit);
        try {
            Files.write(Paths.get("/home/marton/Documents/result_"+LocalDate.now()+".doc"), honeysToPrint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
