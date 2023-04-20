package com.nixsolutions.ppp.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummatorNumberImpl implements Summator<Float> {
    @Override
    public Map<String, Double> sum(Map<String, List<Float>> data) {
        List<Float> listFt;
        Map<String, Double> resultFt = new HashMap<>();
        for (Map.Entry<String, List<Float>> entry : data.entrySet()) {
            listFt = entry.getValue();
            double temp = 0;
            for (Float ft : listFt) {
                temp += ft;
            }
            resultFt.put(entry.getKey(), temp);
        }
        return resultFt;
    }
}

