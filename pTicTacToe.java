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
import org.newdawn.slick.geom.Circle;
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
			
			Visuals.drawCompleteBoard();
			
			Visuals.drawRawX(Game.windowX/2,Game.windowY/2);
			Visuals.drawRawO(Game.windowX/2,Game.windowY/2);
			
			//Game.player1.doNextTurn();
			//Game.player2.doNextTurn();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		
	}
}


