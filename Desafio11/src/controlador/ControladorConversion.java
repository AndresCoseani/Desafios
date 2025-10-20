/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Conversor;
import vista.ConversorDeTemperatura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Alumno
 */
public class ControladorConversion {
    private ConversorDeTemperatura vista;

    public ControladorConversion(ConversorDeTemperatura vista) {
        this.vista = vista;

        // Evento cuando cambia el combo
        vista.getCboConvertor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertir();
            }
        });

        // Evento cuando se presiona Enter en el campo de texto
        vista.getTxtValor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertir();
            }
        });
    }

    private void convertir() {
        try {
            double valor = Double.parseDouble(vista.getTxtValor().getText());
            String tipo = (String) vista.getCboConvertor().getSelectedItem();
            double resultado;

            if ("A celsius".equalsIgnoreCase(tipo)) {
                resultado = Conversor.fahrenheitACelsius(valor);
            } else {
                resultado = Conversor.celsiusAFahrenheit(valor);
            }

            vista.getTxtResultado().setText(String.format("%.2f", resultado));
        } catch (NumberFormatException e) {
            vista.getTxtResultado().setText("Error");
        }
    }
}
