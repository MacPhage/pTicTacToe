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

import com.ruthlessphysics.util.draw.Manager;

public class pTicTacToe
{
	public static void main(String args[])
	{
		new Manager(Game.windowX,Game.windowY,"pTicTacToe",true);
		
		while(!Display.isCloseRequested())
		{
			Manager.prep();
			
			Graphics.drawCompleteBoard();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		
	}
}
