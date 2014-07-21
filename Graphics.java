//
//  Graphics.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.ptictactoe;

import com.ruthlessphysics.util.draw.SimpleText;


public class Graphics
{
	public static void drawCompleteBoard()
	{
		SimpleText.drawString("Player #1 (X\'s): "+Game.player1.getName(), 0, Game.windowY);
		SimpleText.drawString("Player #2 (O\'s): "+Game.player2.getName(), 0, Game.windowY-20);
	}
}
