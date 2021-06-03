package Marton.Szabo.model.utility;

import Marton.Szabo.model.entity.Honey;

import java.util.List;

public class Calculate {

    public static String totalIncome(List<Honey> honeys) {
        return String.valueOf(honeys.stream().mapToInt(Honey::getTotalIncome).sum());
    }

    public static String totalProfit(List<Honey> honeys) {
        return String.valueOf(honeys.stream().mapToInt(Honey::getTotalProfit).sum());
    }

    public static String marciShare(List<Honey> honeys) {
        return String.valueOf((honeys.stream().mapToInt(Honey::getMyShare).sum()+6000));
    }

    public static String apuShare(List<Honey> honeys) {
        return String.valueOf(honeys.stream().mapToInt(Honey::getFatherShare).sum()-6000);
    }
}
