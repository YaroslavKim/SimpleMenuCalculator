package com.gui;

import java.awt.*;
import java.awt.event.*;

public class TwoNumberCalculator extends Frame implements ActionListener {

    private static final int X_STD_OFFSET = 20;
    private static final int Y_STD_OFFSET = 50;

    private static final int FRAME_SIZE_X = 600;
    private static final int FRAME_SIZE_Y = 300;

    private static final int TFIELD_SIZE_HOR = 250;
    private static final int TFIELD_SIZE_VER = 30;

    private static final int TFIELDA_X = 50;
    private static final int TFIELDA_Y = 50;

    private static final int TFIELDB_X = 50 + X_STD_OFFSET + TFIELD_SIZE_HOR;
    private static final int TFIELDB_Y = 50;

    private static final int TFIELD_RESULT_X = 50;
    private static final int TFIELD_RESULT_Y = TFIELDA_Y + TFIELD_SIZE_VER + X_STD_OFFSET;

    private static final int BUTTON_X = 50;
    private static final int BUTTON_Y = TFIELD_RESULT_Y + Y_STD_OFFSET;

    private static final int BUTTON_SIZE_HOR = 50;
    private static final int BUTTON_SIZE_VER = 50;

    TextField tFieldA = new TextField("Number A");
    TextField tFieldB = new TextField("Number B");
    TextField tFieldResult = new TextField("Result");

    Button add = new Button("+");
    Button sub = new Button("-");
    Button mul = new Button("*");
    Button div = new Button("/");

    private int nextButtonX = BUTTON_X;

    private void buttonAdd(Button curButton) {
        curButton.setBounds(nextButtonX, BUTTON_Y, BUTTON_SIZE_HOR, BUTTON_SIZE_VER);
        nextButtonX += BUTTON_SIZE_HOR + X_STD_OFFSET;
        curButton.addActionListener(this);
        add(curButton);
    }

    public TwoNumberCalculator() {
        setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
        tFieldA.setBounds(TFIELDA_X, TFIELDA_Y, TFIELD_SIZE_HOR, TFIELD_SIZE_VER);
        tFieldB.setBounds(TFIELDB_X, TFIELDB_Y, TFIELD_SIZE_HOR, TFIELD_SIZE_VER);
        tFieldResult.setBounds(TFIELD_RESULT_X, TFIELD_RESULT_Y, TFIELD_SIZE_HOR, TFIELD_SIZE_VER);
        add(tFieldA);
        add(tFieldB);
        add(tFieldResult);
        addWindowListener(new WindowTerminationAdapter());
        tFieldResult.setEditable(false);
        buttonAdd(add);
        buttonAdd(sub);
        buttonAdd(mul);
        buttonAdd(div);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int numberA;
        int numberB;
        try {
            numberA = Integer.parseInt(tFieldA.getText());
            numberB = Integer.parseInt(tFieldB.getText());
        } catch(Exception e) {
            tFieldResult.setText("PLEASE INPUT ONLY NUMBERS");
            return;
        }
        int result = 0;
        Button buttonPressed = (Button)event.getSource();
        if (buttonPressed == add) {
            result = numberA + numberB;
        } else if (buttonPressed == sub){
            result = numberA - numberB;
        } else if (buttonPressed == mul) {
            result = numberA * numberB;
        } else if (buttonPressed == div) {
            try {
                result = numberA / numberB;
            } catch(Exception e) {
                tFieldResult.setText("ERROR");
                return;
            }
        }
        tFieldResult.setText(String.valueOf(result));
    }
}
