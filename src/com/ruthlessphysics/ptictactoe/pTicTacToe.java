//
//  pTicTacToe.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.ptictactoe;

import org.lwjgl.opengl.Display;

import com.ruthlessphysics.util.Debug;
import com.ruthlessphysics.util.Config;
import com.ruthlessphysics.util.draw.Manager;

public class pTicTacToe
{
	public static Config debugger = new Config("pTicTacToe");
	
	public static void main(String args[])
	{
		
		//Game.promptPlayers();
		//Game.promptWindowSize();
		
		Game.setupPoints();
		Game.setupDefaults();
		
		new Manager(Game.windowX,Game.windowY,debugger.title,true);
		
		Manager.prep();	
		
		while(!Display.isCloseRequested())
		{
			Visuals.prepNextMove();
			Game.player1.doNextTurn();
			Visuals.prepNextMove();
			if(Game.checkForWin())
			{
				if(Game.checkForWinX())
				{
					Game.winningMove();
					Debug.alert("Player 1 won!","information");
					break;
				}
				else if(Game.checkForWinO())
				{
					Game.winningMove();
					Debug.alert("Player 2 won!","information");
					break;
				}
			}
			else if(Game.checkForTie())
			{
				Debug.alert("The game resulted in a tie!","information");
				break;
			}
			Visuals.prepNextMove();
			Game.player2.doNextTurn();
			Visuals.prepNextMove();
			if(Game.checkForWin())
			{
				if(Game.checkForWinX())
				{
					Game.winningMove();
					Debug.alert("Player 1 won!","information");
					break;
				}
				else if(Game.checkForWinO())
				{
					Game.winningMove();
					Debug.alert("Player 2 won!","information");
					break;
				}
			}
			else if(Game.checkForTie())
			{
				Debug.alert("The game resulted in a tie!","information");
				break;
			}
		}
		Display.destroy();
		System.exit(0);
		
	}
}


