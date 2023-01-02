/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Calculator {
    public float calculateBMI(float weight, float height) {
        return weight / (height * height * 100000);
    }
    
//    public String classifyBMI(float ){
//        if (bmi < 19) {
//            classification = "Under-Standard";
//        } else if (bmi >= 19 && bmi < 25) {
//            classification = "Standard";
//        } else if (bmi >= 25 && bmi < 30) {
//            classification = "Overweight";
//        } else if (bmi >= 30 && bmi < 40) {
//            classification = "Fat - should lose weight ";
//        } else {
//            classification = "Very fat - should lose weight immediately";
//        }
//        
//    }
    public double calculateNumber(double eNum1, double eNum2, char operator){
        int result = 0;
        if(operator == '=') return result;
        if(operator == '+') return eNum1 + eNum2;
        if(operator == '-') return eNum1 - eNum2;
        if(operator == '*') return eNum1*eNum2;
        if(operator == '/') return eNum1/eNum2;
    }
}
