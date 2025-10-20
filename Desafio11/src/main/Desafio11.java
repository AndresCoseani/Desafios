/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import vista.ConversorDeTemperatura;
import controlador.ControladorConversion;

public class Desafio11 {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            ConversorDeTemperatura vista = new ConversorDeTemperatura();
            vista.setVisible(true);

            new ControladorConversion(vista);
        });
    }
}
