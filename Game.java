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

import javax.swing.JOptionPane;

public class Game
{
	public static int windowX = 600;
	public static int windowY = 600;
	public static int[] progress = {0,0,0,0,0,0,0,0,0};
	
	public static Player player1 = new Player();
	public static Player player2 = new Player();
	
	void promptPlayers()
	{
		player1.setName(JOptionPane.showInputDialog("Player 1, please enter your name."));
		player2.setName(JOptionPane.showInputDialog("Player 2, please enter your name."));
	}
	
	boolean checkForWinX()
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
	boolean checkForWinO()
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

	boolean checkForTie()
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
	
}
