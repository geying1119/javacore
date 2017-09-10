package com.kobe.basic;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer; 
// to resolve conflict with java.util.Timer

public class TimerTest
{  
   static void main(String[] args)
   {        
	   ActionListener listener = new TimePrinter();

      // construct a timer that calls the listener
      // once every 2 seconds
      Timer t = new Timer(2000, listener);
      t.start();

      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

class TimePrinter implements ActionListener
{  
   public void actionPerformed(ActionEvent event)
   {  
      Date now = new Date();
      System.out.println("The time is " + now);	
      Toolkit.getDefaultToolkit().beep();
   }
}

