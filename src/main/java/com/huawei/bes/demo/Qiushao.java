package com.huawei.bes.demo;

import java.math.BigDecimal;
import java.util.*;

public class Qiushao {
    /**
     * 根据随机数获取损失次数
     * @param input 0-1的随机数
     * @return
     */
    public static Integer getLossAmount(Float input)
    {
        if (input <= 0.10)
        {
            return 0;
        }
        else if (input > 0.10 && input <= 0.70)
        {
            return 1;
        }
        else if (input > 0.70 && input <= 0.95)
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }

    /**
     * 根据随机数得到对应损失的钱
     * @param input
     * @return
     */
    public static Integer getLossMoney(Float input)
    {
        if (input <= 0.20)
        {
            return 1000;
        }
        else if (input > 0.20 && input <= 0.60)
        {
            return 5000;
        }
        else if (input > 0.60 && input <= 0.90)
        {
            return 10000;
        }
        else if(input > 0.90 && input <= 0.96)
        {
            return 50000;
        }
        else if(input > 0.96 && input <= 0.99)
        {
            return 200000;
        }
        else
        {
            return 500000;
        }
    }

    /**
     * 获取一次模拟损失的金额总数
     * @return
     */
    public static Integer getlossTotalMoney()
    {
        Random random = new Random();
        Integer lossAmount = getLossAmount(random.nextFloat());
        Integer lossTotalMoney = 0;
        for(int i=1 ;i<=lossAmount; i++)
        {
            lossTotalMoney = lossTotalMoney + getLossMoney(random.nextFloat());
        }
        return lossTotalMoney;
    }

    /**
     * 获取最终结果
     * @param simulationAmount 模拟次数
     */
    public static Map<Integer,BigDecimal> getFinalResult(int simulationAmount)
    {
        Map<Integer,BigDecimal> result = new HashMap<Integer,BigDecimal>();
        Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
        for( int i=0; i<simulationAmount;i++)
        {
            int looseTotalMoney = getlossTotalMoney();
            if(temp.containsKey(looseTotalMoney))
            {
                temp.put(looseTotalMoney,temp.get(looseTotalMoney)+1);
            }
            else
            {
                temp.put(looseTotalMoney,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : temp.entrySet())
        {
            BigDecimal probability = new BigDecimal(entry.getValue()).divide(new BigDecimal(simulationAmount));
            result.put(entry.getKey(),probability);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("总损失金额\t概率");
        List<Map.Entry<Integer,BigDecimal>> list = new ArrayList<>(getFinalResult(10000).entrySet());
        Collections.sort(list, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        for(Map.Entry<Integer,BigDecimal> e : list)
        {
           if(((int)e.getKey())==0)
           {
               System.out.println(e.getKey()+"\t\t\t"+e.getValue());
           }
            else{
               System.out.println(e.getKey()+"\t\t"+e.getValue());
           }
        }
    }
}
