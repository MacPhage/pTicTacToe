//
//  Game.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.ptictactoe;

import java.awt.Point;

import javax.swing.JOptionPane;

import com.ruthlessphysics.util.Debug;

public class Game
{
	public static int windowX = 600;
	public static int windowY = 600;
	public static int[] progress = {0,0,0,0,0,0,0,0,0};
	public static Player player1 = new Player();
	public static Player player2 = new Player();
	public static int numberOfTurns = 0;
	public static boolean canContinue = false;
	public static int winType;
	
	public static Point[] box = 
		{
			new Point(),
			new Point(),
			new Point(),
			new Point(),
			new Point(),
			new Point(),
			new Point(),
			new Point(),
			new Point(),
		};	
	
	public static void promptPlayers()
	{
		do
		{
			player1.setName(JOptionPane.showInputDialog("Player 1, please enter your name."));
			if(player1.getName().isEmpty())
			{
				canContinue = false;
			}
			else if(player1.getName().isEmpty() == false)
			{
				canContinue = true;
				Debug.alert("player1.getName():"+player1.getName()+"\n"+"player2.getName():"+player2.getName());
			}
		}
		while(canContinue == false);
		do
		{
			player2.setName(JOptionPane.showInputDialog("Player 2, please enter your name."));
			if(player2.getName().isEmpty())
			{
				canContinue = false;
			}
			else if(player2.getName().isEmpty() == false)
			{
				canContinue = true;
				Debug.alert("player1.getName():"+player1.getName()+"\n"+"player2.getName():"+player2.getName());
			}
		}
		while(canContinue == false);
	}
	
	public static void setupDefaults()
	{
		player1.setName("player1");
		player1.setID(1);
		player2.setName("player2");
		player2.setID(2);
		Debug.alert("player1:\n--"+player1.getName()+"\n--"+player1.getID()+"\nplayer2:\n--"+player2.getName()+"\n--"+player2.getID());
	}
	
	public static void promptWindowSize()
	{
		String in;
		do
		{
			in = JOptionPane.showInputDialog("Please enter your desired window size in pixels (a single number).");
			try
			{
				Double.parseDouble(in);
				canContinue = true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Debug.displayError(e);
				Debug.alert("That wasn\'t a valid window size.", "warning");
				canContinue = false;
			}
		}
		while(canContinue == false);
		windowX = (int)(Math.floor(Double.parseDouble(in)));
		windowY = windowX;
		setupPoints();
	}
	
	public static void setupPoints()
	{
		box[0] = new Point((int)(Game.windowX*0.25),(int)(Game.windowY*0.75));
		box[1] = new Point((int)(Game.windowX*0.50),(int)(Game.windowY*0.75));
		box[2] = new Point((int)(Game.windowX*0.75),(int)(Game.windowY*0.75));
		box[3] = new Point((int)(Game.windowX*0.25),(int)(Game.windowY*0.50));
		box[4] = new Point((int)(Game.windowX*0.50),(int)(Game.windowY*0.50));
		box[5] = new Point((int)(Game.windowX*0.75),(int)(Game.windowY*0.50));
		box[6] = new Point((int)(Game.windowX*0.25),(int)(Game.windowY*0.25));
		box[7] = new Point((int)(Game.windowX*0.50),(int)(Game.windowY*0.25));
		box[8] = new Point((int)(Game.windowX*0.75),(int)(Game.windowY*0.25));
	}
	
	static boolean checkForWin()
	{
		return (checkForWinX() || checkForWinO());
	}
	
	static boolean checkForWinX()
	{
		if(progress[0] == 1 && progress[1] == 1 && progress[2] == 1)
		{
			return true;
		}
		else if(progress[0] == 1 && progress[4] == 1 && progress[8] == 1)
		{
			return true;
		}
		else if(progress[0] == 1 && progress[3] == 1 && progress[6] == 1)
		{
			return true;
		}
		else if(progress[1] == 1 && progress[4] == 1 && progress[7] == 1)
		{
			return true;
		}
		else if(progress[2] == 1 && progress[5] == 1 && progress[8] == 1)
		{
			return true;
		}
		else if(progress[3] == 1 && progress[4] == 1 && progress[5] == 1)
		{
			return true;
		}
		else if(progress[6] == 1 && progress[7] == 1 && progress[8] == 1)
		{
			return true;
		}
		else if(progress[2] == 1 && progress[4] == 1 && progress[6] == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	static boolean checkForWinO()
	{
		if(progress[0] == 2 && progress[1] == 2 && progress[2] == 2)
		{
			return true;
		}
		else if(progress[0] == 2 && progress[4] == 2 && progress[8] == 2)
		{
			return true;
		}
		else if(progress[0] == 2 && progress[3] == 2 && progress[6] == 2)
		{
			return true;
		}
		else if(progress[1] == 2 && progress[4] == 2 && progress[7] == 2)
		{
			return true;
		}
		else if(progress[2] == 2 && progress[5] == 2 && progress[8] == 2)
		{
			return true;
		}
		else if(progress[3] == 2 && progress[4] == 2 && progress[5] == 2)
		{
			return true;
		}
		else if(progress[6] == 2 && progress[7] == 2 && progress[8] == 2)
		{
			return true;
		}
		else if(progress[2] == 2 && progress[4] == 2 && progress[6] == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean checkForTie()
	{
	    if(progress[0] != 0 && progress[1] != 0 && progress[2] != 0 && progress[3] != 0 && progress[4] != 0 && progress[5] != 0 && progress[6] != 0 && progress[7] != 0 && progress[8] != 0)
	    {
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}

	public static int checkForWinType()
	{
		if(progress[0] == 1 && progress[1] == 1 && progress[2] == 1)
		{
			return 0;
		}
		else if(progress[0] == 2 && progress[1] == 2 && progress[2] == 2)
		{
			return 0;
		}
		else if(progress[0] == 1 && progress[4] == 1 && progress[8] == 1)
		{
			return 1;
		}
		else if(progress[0] == 2 && progress[4] == 2 && progress[8] == 2)
		{
			return 1;
		}
		else if(progress[0] == 1 && progress[3] == 1 && progress[6] == 1)
		{
			return 2;
		}
		else if(progress[0] == 2 && progress[3] == 2 && progress[6] == 2)
		{
			return 2;
		}
		else if(progress[1] == 1 && progress[4] == 1 && progress[7] == 1)
		{
			return 3;
		}
		else if(progress[1] == 2 && progress[4] == 2 && progress[7] == 2)
		{
			return 3;
		}
		else if(progress[2] == 1 && progress[5] == 1 && progress[8] == 1)
		{
			return 4;
		}
		else if(progress[2] == 2 && progress[5] == 2 && progress[8] == 2)
		{
			return 4;
		}
		else if(progress[3] == 1 && progress[4] == 1 && progress[5] == 1)
		{
			return 5;
		}
		else if(progress[3] == 2 && progress[4] == 2 && progress[5] == 2)
		{
			return 5;
		}
		else if(progress[6] == 1 && progress[7] == 1 && progress[8] == 1)
		{
			return 6;
		}
		else if(progress[6] == 2 && progress[7] == 2 && progress[8] == 2)
		{
			return 6;
		}
		else if(progress[2] == 1 && progress[4] == 1 && progress[6] == 1)
		{
			return 7;
		}
		else if(progress[2] == 2 && progress[4] == 2 && progress[6] == 2)
		{
			return 7;
		}
		else
		{
			return -1;
		}
	}
	
	public static void winningMove()
	{
		Game.winType = Game.checkForWinType();
        if(Game.winType == 0)
        {
            Visuals.drawWinningMove(Game.box[0],Game.box[2]);
        }
        else if(Game.winType == 1)
        {
            Visuals.drawWinningMove(Game.box[0],Game.box[8]);
        }
        else if(Game.winType == 2)
        {
        	Visuals.drawWinningMove(Game.box[0],Game.box[6]);
        }
        else if(Game.winType == 3)
        {
        	Visuals.drawWinningMove(Game.box[1],Game.box[7]);
        }
        else if(Game.winType == 4)
        {
        	Visuals.drawWinningMove(Game.box[2],Game.box[8]);
        }
        else if(Game.winType == 5)
        {
        	Visuals.drawWinningMove(Game.box[3],Game.box[5]);
        }
        else if(Game.winType == 6)
        {
        	Visuals.drawWinningMove(Game.box[6],Game.box[8]);
        }
        else if(Game.winType == 7)
        {
            Visuals.drawWinningMove(Game.box[6],Game.box[2]);
        }
	}
}
