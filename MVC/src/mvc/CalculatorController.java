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
    CalculatorView calculatorView = new CalculatorView();
    CalculatorModel calculatorModel = new CalculatorModel();
    
    public void start() {
       calculatorView.start();
       int value = calculatorView.getResult();
        switch (value) {
            case 1: {
                   int result = this.add();
                   calculatorView.printResults(result);
                   break;
            }
            case 2: {
                   int result = this.multiply();
                   calculatorView.printResults(result);
                   break;
            }
            default: {
                break;
            }
    }
    }
    
    
    int add() {
        int num1 = calculatorView.getNumber("1st");
        int num2 = calculatorView.getNumber("2nd");
        calculatorModel.addNumbers(num1, num2);
        int result = calculatorModel.getResult();
        return result;
             
    }

    int multiply() {
        int num1 = calculatorView.getNumber("1st");
        int num2 = calculatorView.getNumber("2nd");
        calculatorModel.multiplyNumbers(num1, num2);
        int result = calculatorModel.getResult();
        return result;
    }
    
}
