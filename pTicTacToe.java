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
import com.ruthlessphysics.util.draw.Manager;

public class pTicTacToe
{
	public static void main(String args[])
	{
		Debug.setTitle("pTicTacToe");
		new Manager(Game.windowX,Game.windowY,Debug.title,true);
		
		while(!Display.isCloseRequested())
		{
			Manager.prep();
			
			//Graphics.drawCompleteBoard();
			Graphics.drawBoard();
			//Game.player1.doNextTurn();
			//Game.player2.doNextTurn();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		
	}
}


