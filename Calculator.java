import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, devButton;
    JButton decButton, equButton, intButton, clrButton, perButton;

    JPanel panel;
    Font myFont = new Font("Default", Font.BOLD, 30);

    double num1=0, num2 =0, result =0;
    char operator;
    Calculator(){
        frame = new JFrame("Powered by Asadi.");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(240, 390);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(1,1, 238, 64);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(Color.black);
        textField.setForeground(Color.WHITE);
        textField.setText("0");

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        devButton = new JButton("/");
        decButton = new JButton(",");
        equButton = new JButton("=");
        intButton = new JButton("+-");
        clrButton = new JButton("AC");
        perButton = new JButton("%");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = devButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = intButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = perButton;

        for(int i=0; i<9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBackground(Color.GRAY);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }
        numberButtons[0].setBounds(1, 305, 119, 59);
        functionButtons[4].setBounds(121, 305, 59, 59);
        functionButtons[5].setBounds(181, 305, 59, 59);

        panel = new JPanel();
        panel.setBounds(0, 65, 240, 240);
        panel.setLayout(new GridLayout(4,4,0,0));
        panel.setBackground(Color.BLACK);

        panel.add(clrButton);//these 4 are in the 1st row
        panel.add(intButton);
        panel.add(perButton);
        panel.add(devButton);
        panel.add(numberButtons[7]);//these 4 are in the 2nd row
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);


        frame.add(textField);
        frame.add(numberButtons[0]);
        frame.add(functionButtons[4]);
        frame.add(functionButtons[5]);
        frame.add(panel);
        frame.setVisible(true);

    }
    public static void main(String args[]){
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                String string = textField.getText();
                if(string.equals("0") || string.equals("0.0")){
                    textField.setText("");
                }
                if(string.equals("-0") || string.equals("-0.0")){textField.setText("-");}
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            String string = textField.getText();
            if(string.contains(".") || string.equals("")){
                textField.setText(textField.getText().concat(""));
            }
            else{
                textField.setText(textField.getText().concat("."));
            }
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case'+' -> result = num1 + num2;
                case'-' -> result = num1 - num2;
                case'x' -> result = num1 * num2;
                case'/' -> result = num1 / num2;
            }
            if(result%1 == 0.0){
                int res = (int) Math.round(result);
                textField.setText(String.valueOf(res));
            }
            else{
                textField.setText(String.valueOf(result));
            }
            //textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
            textField.setText("0");
        }
        if(e.getSource() == intButton){
            num1 = Double.parseDouble(textField.getText()) * -1;
            textField.setText("");
            if(num1%1 == 0.0){
                int res = (int) Math.round(num1);
                //textField.setText("");
                textField.setText(res+"");}
            else{
                textField.setText(num1+"");
            }
        }
    }
}
