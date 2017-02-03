package com.javarush.test.level30.lesson02.home01;


import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        Number number1 = new Number(NumerationSystemType._16, "10ff");
        Number result1 = convertNumberToOtherNumerationSystem(number1, NumerationSystemType._10);
        System.out.println(result);    //expected 110
        System.out.println(result1);
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        int numerationSystemIntValue = number.getNumerationSystem().getNumerationSystemIntValue();
        String digit = number.getDigit();

        if(digit.matches("\\d*\\.\\d*")) digit = new String((long)(double)Double.parseDouble(number.getDigit())+"");
        BigInteger bi = new BigInteger(digit,numerationSystemIntValue);
        if(bi.compareTo(new BigInteger("0"))==-1) throw new NumberFormatException();
        int numSys = numerationSystemIntValue;
        for (int i = 0; i < digit.length(); i++)
        {
            int c = Character.getNumericValue(digit.charAt(i));
            if(c >= numSys) throw new NumberFormatException();
        }
        BigInteger x = new BigInteger(digit, numerationSystemIntValue);
        String result = x.toString(expectedNumerationSystem.getNumerationSystemIntValue());
        return new Number(expectedNumerationSystem,result);
    }

}
