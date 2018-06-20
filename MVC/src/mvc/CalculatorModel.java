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
class CalculatorModel {
        int result;

    void addNumbers(int num1, int num2) {
        result = num1 + num2;
    }

    public int getResult() {
        return result;
    }

    void multiplyNumbers(int num1, int num2) {
        result = num1 * num2;
    }


}
