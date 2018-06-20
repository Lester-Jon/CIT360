/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author Jon
 */
class CalculatorController {

    int add() {
        int num1 = MVC.calculatorView.getNumber("1st");
        int num2 = MVC.calculatorView.getNumber("2nd");
        MVC.calculatorModel.addNumbers(num1, num2);
        int result = MVC.calculatorModel.getResult();
        return result;
             
    }

    int multiply() {
        int num1 = MVC.calculatorView.getNumber("1st");
        int num2 = MVC.calculatorView.getNumber("2nd");
        MVC.calculatorModel.multiplyNumbers(num1, num2);
        int result = MVC.calculatorModel.getResult();
        return result;
    }
    
}
