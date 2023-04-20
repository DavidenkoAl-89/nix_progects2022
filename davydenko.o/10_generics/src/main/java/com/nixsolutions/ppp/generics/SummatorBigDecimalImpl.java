package com.nixsolutions.ppp.generics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummatorBigDecimalImpl implements Summator<BigDecimal> {
    @Override
    public Map<String, Double> sum(Map<String, List<BigDecimal>> data) {
        List<BigDecimal> listBd;
        Map<String, Double> resultMap = new HashMap<>();
        for (String key : data.keySet()) {
            listBd = data.get(key);
            double temp = 0;
            for (BigDecimal bd : listBd) {
                temp += Double.parseDouble(String.valueOf(bd));
            }
            resultMap.put(key, temp);
        }
        return resultMap;
    }
}
