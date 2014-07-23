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

import java.awt.Point;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Line;

import com.ruthlessphysics.util.Debug;
import com.ruthlessphysics.util.ExtraMath;
import com.ruthlessphysics.util.draw.Manager;
import com.ruthlessphysics.util.draw.Rectangle;
import com.ruthlessphysics.util.draw.SimpleText;


public class Visuals
{
	public static int t = 3; //Line thickness
	
	public static void drawCompleteBoard()
	{	
		drawBoard();
		drawHalfPoints();
		if(Game.windowX > 200)
		{
			drawPlayerNames();
			drawBoxNames();
		}
	}
	
	public static void drawBoard()
	{
		//This used semi-deprecated com.ruthlessphysics.util.draw.Rectangles, which the only benefit is to easily adjust thickness
		
		//4 Horizontal lines
		new Rectangle((int)(Game.windowX*0.125),(int)(Game.windowY*0.125),(int)(Game.windowX*0.75),t,true);
		new Rectangle((int)(Game.windowX*0.125),(int)(Game.windowY*0.375),(int)(Game.windowX*0.75),t,true);
		new Rectangle((int)(Game.windowX*0.125),(int)(Game.windowY*0.625),(int)(Game.windowX*0.75),t,true);
		new Rectangle((int)(Game.windowX*0.125),(int)(Game.windowY*0.875),(int)(Game.windowX*0.75),t,true);
		//4 Vertical Lines
		new Rectangle((int)(Game.windowX*0.125),(int)(Game.windowY*0.125),t,(int)(Game.windowY*0.75),true);
		new Rectangle((int)(Game.windowX*0.375),(int)(Game.windowY*0.125),t,(int)(Game.windowY*0.75),true);
		new Rectangle((int)(Game.windowX*0.625),(int)(Game.windowY*0.125),t,(int)(Game.windowY*0.75),true);
		new Rectangle((int)(Game.windowX*0.875),(int)(Game.windowY*0.125),t,(int)(Game.windowY*0.75),true);
	}
	
	public static void drawBoxNames()
	{
		SimpleText.drawString("Box \'0\'",(int)(Game.windowX*0.125)+t+2,(int)(Game.windowY*0.625)+t+3);
		SimpleText.drawString("Box \'1\'",(int)(Game.windowX*0.375)+t+2,(int)(Game.windowY*0.625)+t+3);
		SimpleText.drawString("Box \'2\'",(int)(Game.windowX*0.625)+t+2,(int)(Game.windowY*0.625)+t+3);
		SimpleText.drawString("Box \'3\'",(int)(Game.windowX*0.125)+t+2,(int)(Game.windowY*0.375)+t+3);
		SimpleText.drawString("Box \'4\'",(int)(Game.windowX*0.375)+t+2,(int)(Game.windowY*0.375)+t+3);
		SimpleText.drawString("Box \'5\'",(int)(Game.windowX*0.625)+t+2,(int)(Game.windowY*0.375)+t+3);
		SimpleText.drawString("Box \'6\'",(int)(Game.windowX*0.125)+t+2,(int)(Game.windowY*0.125)+t+3);
		SimpleText.drawString("Box \'7\'",(int)(Game.windowX*0.375)+t+2,(int)(Game.windowY*0.125)+t+3);
		SimpleText.drawString("Box \'8\'",(int)(Game.windowX*0.625)+t+2,(int)(Game.windowY*0.125)+t+3);
	}
	
	public static void drawPlayerNames()
	{
		SimpleText.drawString("Player #1 (X\'s): "+Game.player1.getName(), 0, Game.windowY-10);
		SimpleText.drawString("Player #2 (O\'s): "+Game.player2.getName(), 0, Game.windowY-20);
	}
	
	public static void drawRawX(float x, float y)
	{
		int[] a = {Game.windowX,Game.windowY};
		int avg = ExtraMath.average(a);
		Manager.slick.draw(new Line(x-(int)(avg*0.1), y+(int)(avg*0.1), x+(int)(avg*0.1), y-(int)(avg*0.1))); // "Decreasing" X line
		Manager.slick.draw(new Line(x-(int)(avg*0.1), y-(int)(avg*0.1), x+(int)(avg*0.1), y+(int)(avg*0.1))); // "Increasing" X line
		
	}
	
	public static void drawRawO(float x, float y)
	{
		int[] a = {Game.windowX,Game.windowY}; 
		int avg = ExtraMath.average(a);
		Manager.slick.draw(new Circle(x,y,(int)(avg*0.10)));
	}
	
	public static void drawX(int b)
	{
		drawRawX(Game.box[b].x,Game.box[b].y);
	}
	
	public static void drawO(int b)
	{
		drawRawO(Game.box[b].x,Game.box[b].y);
	}
	
	public static void drawWinningMove(Point start, Point end)
	{
		Manager.slick.draw(new Line(start.x,start.y,end.x,end.y));
	}
	
	public static void drawHalfPoints()
	{
		Manager.slick.draw(new Circle((int)(Game.windowX*0.25),(int)(Game.windowY*0.75),3)); //0
		Manager.slick.draw(new Circle((int)(Game.windowX*0.50),(int)(Game.windowY*0.75),3)); //1
		Manager.slick.draw(new Circle((int)(Game.windowX*0.75),(int)(Game.windowY*0.75),3)); //2
		Manager.slick.draw(new Circle((int)(Game.windowX*0.25),(int)(Game.windowY*0.50),3)); //3
		Manager.slick.draw(new Circle((int)(Game.windowX*0.50),(int)(Game.windowY*0.50),3)); //4
		Manager.slick.draw(new Circle((int)(Game.windowX*0.75),(int)(Game.windowY*0.50),3)); //5
		Manager.slick.draw(new Circle((int)(Game.windowX*0.25),(int)(Game.windowY*0.25),3)); //6
		Manager.slick.draw(new Circle((int)(Game.windowX*0.50),(int)(Game.windowY*0.25),3)); //7
		Manager.slick.draw(new Circle((int)(Game.windowX*0.75),(int)(Game.windowY*0.25),3)); //8
	}
	
	public static void prepNextMove()
	{
		Visuals.drawCompleteBoard();
		Visuals.refreshBoard();
		Display.update();
		Display.sync(60);
	}
	
	public static void refreshBoard()
	{
		for(int i = 0; i < Game.progress.length; i++)
		{
			if(Game.progress[i] == 1)
			{
				drawX(i);
			}
			else if(Game.progress[i] == 2)
			{
				drawO(i);
			}
		}
	}
}
