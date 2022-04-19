package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Calculater_yt extends JFrame{

	private JPanel con;
	private ActionListener insert = new InsertAction();
    private ActionListener command = new CommandAction();
	private JTextField inpt;
    private boolean start = true;
    private double result = 0;
    private String lastCommand = "=";
	
	public Calculater_yt() {
		// TODO Auto-generated constructor stub
		//Main Panel
		setTitle("ºÚº∆À„");
		setLayout(null);
		setBounds(100,100,240,220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		con=new JPanel();
		con.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(con);
		//input terminal
		inpt=new JTextField();
		inpt.setColumns(20);
		con.add(inpt);
		//button terminal
		JPanel jpb=new JPanel();
		jpb.setLayout(new GridLayout(4,4,5,5));
		con.add(jpb);
		JButton jb7=new JButton("7");
		JButton jb8=new JButton("8");
		JButton jb9=new JButton("9");
		JButton jbchu=new JButton("/");
		JButton jb4=new JButton("4");
		JButton jb5=new JButton("5");
		JButton jb6=new JButton("6");
		JButton jbchen=new JButton("*");
		JButton jb1=new JButton("1");
		JButton jb2=new JButton("2");
		JButton jb3=new JButton("3");
		JButton jbjian=new JButton("-");
		JButton jb0=new JButton("0");
		JButton jbdian=new JButton(".");
		JButton jbdengyu=new JButton("=");
		JButton jbjia=new JButton("+");
		List<JButton>jbjihe=new ArrayList<JButton>();	
		jbjihe.add(jb7);
		jbjihe.add(jb8);
		jbjihe.add(jb9);
		jbjihe.add(jbchu);
		jbjihe.add(jb4);
		jbjihe.add(jb5);
		jbjihe.add(jb6);
		jbjihe.add(jbchen);
		jbjihe.add(jb1);
		jbjihe.add(jb2);
		jbjihe.add(jb3);
		jbjihe.add(jbjian);
		jbjihe.add(jb0);
		jbjihe.add(jbdian);
		jbjihe.add(jbdengyu);
		jbjihe.add(jbjia);
		Iterator<JButton>it=jbjihe.iterator();
		while(it.hasNext()) {
			jpb.add(it.next());
		}
		//the keys' action
		jb7.addActionListener(insert);
		jb8.addActionListener(insert);
		jb9.addActionListener(insert);
		jbchu.addActionListener(command);
		jb4.addActionListener(insert);
		jb5.addActionListener(insert);
		jb6.addActionListener(insert);
		jbchen.addActionListener(command);
		jb1.addActionListener(insert);
		jb2.addActionListener(insert);
		jb3.addActionListener(insert);
		jbjian.addActionListener(command);
		jb0.addActionListener(insert);
		jbdian.addActionListener(insert);
		jbdengyu.addActionListener(command);
		jbjia.addActionListener(command);
	}
	 private class InsertAction implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            String input = e.getActionCommand();
	            String text = inpt.getText();
	            if (start){
	                inpt.setText("");
	                start = false;
	            }
	            if (text.startsWith(".")) {
	                inpt.setText("0" + inpt.getText() + input);
	            } else if (text.startsWith("-0.") || text.startsWith("0.")) {
	                inpt.setText(inpt.getText() + input);
	            } else if (text.startsWith("-0")) {
	                inpt.setText("-" + input);
	            } else if (text.startsWith("0")) {
	                inpt.setText(input);
	            } else {
	                inpt.setText(inpt.getText() + input);
	            }
	        }
	    }

	    private class CommandAction implements ActionListener {

	        public void actionPerformed(ActionEvent e) {
	            String command = e.getActionCommand();
	            if (start) {
	                if (command.equals("-")) {
	                    inpt.setText(command);
	                    start = false;
	                } else {
	                    lastCommand = command;
	                }
	            } else {
	                calculate(Double.parseDouble(inpt.getText()));
	                lastCommand = command;
	                start = true;
	            }
	        }
	    }

	    public void calculate(double x) {
	        char operator = lastCommand.charAt(0);
	        switch (operator) {
	        case '+':
	            result += x;
	            break;
	        case '-':
	            result -= x;
	            break;
	        case '*':
	            result *= x;
	            break;
	        case '/':
	            result /= x;
	            break;
	        case '=':
	            result = x;
	            break;
	        }
	        inpt.setText(""+result);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculater_yt cy=new Calculater_yt();
		cy.setVisible(true);
	}
}
