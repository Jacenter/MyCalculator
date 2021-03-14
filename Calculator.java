package main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

public class Calculator extends JFrame {

    private JMenuBar menuBar;
    private JMenu file;
    private JMenu edit;
    private JMenu help;
    private JMenuItem close;
    private JMenuItem copy;
    private JMenuItem view;
    private JMenuItem about;

    private JTextArea display;

    private JButton clear;
    private JButton equals;
    private JButton zero;
    private JButton decimal;
    private JButton posneg;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;

    private JButton division;
    private JButton multiplication;
    private JButton subtraction;
    private JButton addition;

    private double tempFirst = 0.0;

    private boolean[] operation = new boolean[4];

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e){
            System.out.println("Could not load System Look");
        }
        new Calculator();
    }

    public Calculator()
    {
        super("Calculator");
        sendMenuBar();
        sendDisplay();
        sendButtons();
        sendUI(this);
    }
private void sendMenuBar(){
    menuBar = new JMenuBar();
    file = new JMenu(" File ");
    edit = new JMenu(" Edit ");
    help = new JMenu(" Help ");
    close = new JMenuItem("Close");
    copy = new JMenuItem("Copy");
    view = new JMenuItem("View Help");
    about = new JMenuItem("About Calculator");
    setJMenuBar(menuBar);
    menuBar.add(file);
    menuBar.add(edit);
    menuBar.add(help);

    close.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.exit(0);
                                }
                            });

    copy.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tempDisplay = display.getText();
            StringSelection string = new StringSelection(tempDisplay);
            Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
            system.setContents(string, string);
        }
    });

    view.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"There are currently no help topics to view.", "Calculator", JOptionPane.OK_OPTION);
        }
    });

    about.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"Copyright Dawars Calculator 2021.", "Calculator", JOptionPane.OK_OPTION);
        }
    });

    file.add(close);
    edit.add(copy);
    help.add(view);
    help.add(about);
}
private void sendDisplay(){
        display = new JTextArea("0");
        display.setBounds(10,10,280, 50);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        add(display);
}

private void sendButtons(){

        division = new JButton("/");
    division.setBounds(226, 70, 65, 55);
    division.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        setTempFirst(Double.parseDouble(display.getText()));
        display.setText("0");
        operation[0] = true;
        }
    });
    add(division);

    multiplication = new JButton("*");
    multiplication.setBounds(226, 132, 65, 55);
    multiplication.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setTempFirst(Double.parseDouble(display.getText()));
            display.setText("0");
            operation[1] = true;
        }
    });
    add(multiplication);

    subtraction = new JButton("-");
    subtraction.setBounds(226, 194, 65, 55);
    subtraction.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setTempFirst(Double.parseDouble(display.getText()));
            display.setText("0");
            operation[2] = true;
        }
    });
    add(subtraction);

    addition = new JButton("+");
    addition.setBounds(226, 256, 65, 55);
    addition.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setTempFirst(Double.parseDouble(display.getText()));
            display.setText("0");
            operation[3] = true;
        }
    });
    add(addition);

        clear = new JButton("Clear");
    clear.setBounds(154, 318, 137, 55);
    clear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText("0");
          setTempFirst(0.0);
          for (int i = 0; i <= 3; i++){
              operation[i] = false;
          }
        }
    });
    add(clear);

    equals = new JButton("=");
    equals.setBounds(10, 318, 137, 55);
    equals.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (operation[0])
                display.setText(Double.toString(getTempFirst() / Double.parseDouble(display.getText())));
                else if (operation[1])
                display.setText(Double.toString(getTempFirst() * Double.parseDouble(display.getText())));
            else if (operation[2])
                display.setText(Double.toString(getTempFirst() - Double.parseDouble(display.getText())));
            else if (operation[3])
                display.setText(Double.toString(getTempFirst() + Double.parseDouble(display.getText())));

                if (display.getText().endsWith(".0"))
                    display.setText(display.getText().replace(".0", ""));

                setTempFirst(0.0);
                for (int i = 0; i <= 3; i++)
                    operation[i] = false;
            }
    });
    add(equals);

    zero = new JButton("0");
    zero.setBounds(10, 256, 65, 55);
    zero.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText("0");
                return;
            }
            display.append("0");
        }
    });
    add(zero);

    decimal = new JButton(".");
    decimal.setBounds(82, 256, 65, 55);
    decimal.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().contains("."))
                return;
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText(".");
                return;
            }
            display.append(".");
        }
    });
    add(decimal);

    posneg = new JButton("+/-");
    posneg.setBounds(154, 256, 65, 55);
    posneg.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().equalsIgnoreCase("0"))
                return;
           display.setText(Double.toString(Double.parseDouble(display.getText()) * (-1)));
           if (display.getText().endsWith(".0"))
               display.setText(display.getText().replace(".0", " "));
        }
    });
    add(posneg);

        one = new JButton("1");
    one.setBounds(10, 194, 65, 55);
    one.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText("1");
                return;
            }
            display.append("1");
        }
    });
    add(one);

    two = new JButton("2");
    two.setBounds(82, 194, 65, 55);
    two.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText("2");
                return;
            }
            display.append("2");
        }
    });
    add(two);

    three = new JButton("3");
    three.setBounds(154, 194, 65, 55);
    three.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText("3");
                return;
            }
            display.append("3");
        }
    });
    add(three);

        four = new JButton("4");
    four.setBounds(10, 132, 65, 55);
    four.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText("4");
                return;
            }
            display.append("4");
        }
    });
    add(four);

    five = new JButton("5");
    five.setBounds(82, 132, 65, 55);
    five.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText("5");
                return;
            }
            display.append("5");
        }
    });
    add(five);

    six = new JButton("6");
    six.setBounds(154, 132, 65, 55);
    six.addActionListener(new ActionListener() {
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                  if (display.getText().length() > 13)
                                      return;
                                  if (display.getText().equalsIgnoreCase("0")) {
                                      display.setText("6");
                                      return;
                                  }
                                  display.append("6");
                              }
                          });
    add(six);

    seven = new JButton("7");
    seven.setBounds(10, 70, 65, 55);
    seven.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText("7");
                return;
            }
            display.append("7");
        }
    });
    add(seven);

    eight = new JButton("8");
    eight.setBounds(82, 70, 65, 55);
    eight.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText("8");
                return;
            }
            display.append("8");
        }
    });
    add(eight);

    nine = new JButton("9");
    nine.setBounds(154, 70, 65, 55);
    nine.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (display.getText().length() > 13)
                return;
            if (display.getText().equalsIgnoreCase("0")){
                display.setText("9");
                return;
            }
            display.append("9");
        }
    });
    add(nine);
}
private void sendUI(Calculator app)
{
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setSize(330,435);
    app.setResizable(false);
    app.setLayout(null);
    app.setLocationRelativeTo(null);
    app.setVisible(true);
}

    public double getTempFirst() {
        return tempFirst;
    }

    public void setTempFirst(double tempFirst) {
        this.tempFirst = tempFirst;
    }
}
