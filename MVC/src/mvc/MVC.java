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
public class MVC {

static CalculatorController calculatorController = new CalculatorController();
static CalculatorView calculatorView = new CalculatorView();
static CalculatorModel calculatorModel = new CalculatorModel();
    public static void main(String[] args) {
        calculatorView.start();
    }


    
}
