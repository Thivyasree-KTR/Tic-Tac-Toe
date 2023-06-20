/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Lenovo
 */
public class TicTacToe implements ActionListener{
    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textfield=new JLabel();
    JButton label=new JButton();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;
    TicTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,700);
        frame.getContentPane().setBackground(new Color(50,50,50));  
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        
        label.setBackground(new Color(25,25,25));
        label.setForeground(new Color(25,255,0));
        label.setFont(new Font("Ink Free",Font.BOLD,25));
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVisible(false);
        label.setOpaque(true);
        label.addActionListener(this);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        
        for(int i=0;i<9;i++)
        {
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            
        }
                
        title_panel.add(textfield);
        title_panel.add(label,BorderLayout.WEST);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==label)
        {
            frame.dispose();
            TicTacToe t=new TicTacToe();
            
        }
        else
        {
            for(int i=0;i<9;i++)
            {
                if(e.getSource()==buttons[i])
                {
                    if(player1_turn)
                    {
                        if(buttons[i].getText()=="")
                        {
                            buttons[i].setForeground(new Color(255,0,0));
                            buttons[i].setText("X");
                            player1_turn=false;
                            textfield.setText("O turn");
                            check();
                        }
                    }
                    else
                    {
                        if(buttons[i].getText()=="")
                        {
                            buttons[i].setForeground(new Color(0,0,255));
                            buttons[i].setText("O");
                            player1_turn=true;
                            textfield.setText("X turn");
                            check();
                        }
                    }
                }           
            }
        }
        
        
        
    }
    public void firstTurn()
    {
        try {
            
            Thread.sleep(2000);
            for(int i=0;i<9;i++)
            {
                buttons[i].addActionListener(this);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        if(random.nextInt(2)==0)
        {
            player1_turn=true;
            textfield.setText("X turn");
        }
        else
        {
            player1_turn=false;
            textfield.setText("O turn");
        }
    } 
    public void check()
    {
        //X wins
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X"))
        {
            xWins(0,1,2);
        }
        else if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
        {
            xWins(3,4,5);
        }
        else if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xWins(6,7,8);
        }
        
        else if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X"))
        {
            xWins(0,3,6);
        }
        else if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X"))
        {
            xWins(1,4,7);
        }
        else if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xWins(2,5,8);
        }
        else if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xWins(0,4,8);
        }
        else if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
        {
            xWins(2,4,6);
        }
        //O Wins
        else if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
        {
            oWins(0,1,2);
        }
        else if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
        {
            oWins(3,4,5);
        }
        else if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(6,7,8);
        }
        
        else if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
        {
            oWins(0,3,6);
        }
        else if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
        {
            oWins(1,4,7);
        }
        else if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(2,5,8);
        }
        else if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(0,4,8);
        }
        else if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O"))
        {
            oWins(2,4,6);
        }
        else
        {
            int flag=0;
            for(int i=0;i<9;i++)
            {
                if(buttons[i].getText()!="")
                {
                    
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                label.setVisible(true);
                textfield.setText("Nobody wins");
                label.setText("Play Again");
                
                for(int i=0;i<9;i++)
                {
                    buttons[i].setEnabled(false);
                }
            }
        }
    }
    

    public void xWins(int a,int b,int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        label.setVisible(true);
        textfield.setText("X Wins");
        label.setText("Play Again");
    }
    public void oWins(int a,int b,int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        label.setVisible(true);
        textfield.setText("O Wins");
        label.setText("Play Again");
    }
    
}
