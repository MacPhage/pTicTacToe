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

import com.ruthlessphysics.util.draw.Rectangle;
import com.ruthlessphysics.util.draw.SimpleText;


public class Graphics
{
	
	//TOP
	static int posTopLeftX = (int)(Game.windowX*0.25);
	static int posTopLeftY = (int)(Game.windowY*0.25);

	static int posTopMiddleX = (int)(Game.windowX*0.50);
	static int posTopMiddleY = (int)(Game.windowY*0.25);

	static int posTopRightX = (int)(Game.windowX*0.75);
	static int posTopRightY = (int)(Game.windowY*0.25);

	//MIDDLE
	static int posMiddleLeftX = (int)(Game.windowX*0.25);
	static int posMiddleLeftY = (int)(Game.windowY*0.50);

	static int posMiddleMiddleX = (int)(Game.windowX*0.50);
	static int posMiddleMiddleY = (int)(Game.windowY*0.50);

	static int posMiddleRightX = (int)(Game.windowX*0.75);
	static int posMiddleRightY = (int)(Game.windowY*0.50);

	//BOTTOM
	static int posBottomLeftX = (int)(Game.windowX*0.25);
	static int posBottomLeftY = (int)(Game.windowY*0.75);

	static int posBottomMiddleX = (int)(Game.windowX*0.50);
	static int posBottomMiddleY = (int)(Game.windowY*0.75);

	static int posBottomRightX = (int)(Game.windowX*0.75);
	static int posBottomRightY = (int)(Game.windowY*0.75);
	
	public static void drawCompleteBoard()
	{
		SimpleText.drawString("Player #1 (X\'s): "+Game.player1.getName(), 0, Game.windowY);
		SimpleText.drawString("Player #2 (O\'s): "+Game.player2.getName(), 0, Game.windowY-20);
	}
	
	public static void drawBoard()
	{
		new Rectangle((int)(Game.windowX*0.125),(int)(Game.windowY*0.125),(int)(Game.windowX*0.125)-(int)(Game.windowX*0.875),(int)(Game.windowY*0.125)-(int)(Game.windowY*0.875),true);
		new Rectangle((int)(Game.windowX*0.125),(int)(Game.windowY*0.125),(int)(Game.windowX*0.125)-(int)(Game.windowX*0.375),(int)(Game.windowY*0.125)-(int)(Game.windowY*0.375),true);
		new Rectangle((int)(Game.windowX*0.125),(int)(Game.windowY*0.125),(int)(Game.windowX*0.125)-(int)(Game.windowX*0.625),(int)(Game.windowY*0.125)-(int)(Game.windowY*0.625),true);
		new Rectangle((int)(Game.windowX*0.375),(int)(Game.windowY*0.375),(int)(Game.windowX*0.375)-(int)(Game.windowX*0.625),(int)(Game.windowY*0.375)-(int)(Game.windowY*0.625),true);
		new Rectangle((int)(Game.windowX*0.375),(int)(Game.windowY*0.375),(int)(Game.windowX*0.375)-(int)(Game.windowX*0.875),(int)(Game.windowY*0.375)-(int)(Game.windowY*0.875),true);
		new Rectangle((int)(Game.windowX*0.625),(int)(Game.windowY*0.625),(int)(Game.windowX*0.625)-(int)(Game.windowX*0.875),(int)(Game.windowY*0.625)-(int)(Game.windowY*0.875),true);
	}
	
	/*
	

void drawBoard()
{
	rectangle((int)(windowX*0.125),(int)(windowY*0.125),(int)(windowX*0.875),(int)(windowY*0.875));
	rectangle((int)(windowX*0.125),(int)(windowY*0.125),(int)(windowX*0.375),(int)(windowY*0.375));
	rectangle((int)(windowX*0.125),(int)(windowY*0.125),(int)(windowX*0.625),(int)(windowY*0.625));
	rectangle((int)(windowX*0.375),(int)(windowY*0.375),(int)(windowX*0.625),(int)(windowY*0.625));
	rectangle((int)(windowX*0.375),(int)(windowY*0.375),(int)(windowX*0.875),(int)(windowY*0.875));
	rectangle((int)(windowX*0.625),(int)(windowY*0.625),(int)(windowX*0.875),(int)(windowY*0.875));
}

void drawHalfPoints()
{
	setcolor(2);
	circle((int)(windowX*0.25),(int)(windowY*0.25),3);
	circle((int)(windowX*0.25),(int)(windowY*0.50),3);
	circle((int)(windowX*0.25),(int)(windowY*0.75),3);
	
	circle((int)(windowX*0.50),(int)(windowY*0.25),3);
	circle((int)(windowX*0.50),(int)(windowY*0.50),3);
	circle((int)(windowX*0.50),(int)(windowY*0.75),3);
	
	circle((int)(windowX*0.75),(int)(windowY*0.25),3);
	circle((int)(windowX*0.75),(int)(windowY*0.50),3);
	circle((int)(windowX*0.75),(int)(windowY*0.75),3);
	setcolor(15);
}

void drawX(int Xpos, int Ypos)
{
	int offset = -12;
	int i = 15;
	setcolor(13);
	while(i > 0)
	{
		line(Xpos-35,Ypos+35+i+offset,Xpos+35,Ypos-35+i+offset); //x1,y1,x2,y2
		line(Xpos-35,Ypos-35+i+offset,Xpos+35,Ypos+35+i+offset); //x1,y1,x2,y2
		i--;
	}
	
	//outtextxy(Xpos-6,Ypos-12,"X"); //left,top,right,bottom
	setcolor(15);
}

void drawO(int Xpos, int Ypos)
{
	int i = 37;
	setcolor(11);
	while(i > 25)
	{
		circle(Xpos,Ypos,i); //x,y,radius
		i--;
	}
	//outtextxy(Xpos-6,Ypos-12,"O"); //left,top,right,bottom
	setcolor(15);
}

int boxDirectorX(int box)
{
    switch(box)
    {
        case 0:
            return posTopLeftX;
        case 1:
            return posTopMiddleX;
        case 2:
            return posTopRightX;
        case 3:
            return posMiddleLeftX;
        case 4:
            return posMiddleMiddleX;
        case 5:
            return posMiddleRightX;
        case 6:
            return posBottomLeftX;
        case 7:
            return posBottomMiddleX;
        case 8:
            return posBottomRightX;
        default:
            return 0;
    }
}

int boxDirectorY(int box)
{
    switch(box)
    {
        case 0:
            return posTopLeftY;
        case 1:
            return posTopMiddleY;
        case 2:
            return posTopRightY;
        case 3:
            return posMiddleLeftY;
        case 4:
            return posMiddleMiddleY;
        case 5:
            return posMiddleRightY;
        case 6:
            return posBottomLeftY;
        case 7:
            return posBottomMiddleY;
        case 8:
            return posBottomRightY;
        default:
            return 0;
    }
}

void drawBoxNames()
{
	outtextxy((int)(windowX*0.125),(int)(windowY*0.125),"Box \'0\'");
	outtextxy((int)(windowX*0.375),(int)(windowY*0.125),"Box \'1\'");
	outtextxy((int)(windowX*0.625),(int)(windowY*0.125),"Box \'2\'");
	outtextxy((int)(windowX*0.125),(int)(windowX*0.375),"Box \'3\'");
	outtextxy((int)(windowX*0.375),(int)(windowX*0.375),"Box \'4\'");
	outtextxy((int)(windowX*0.625),(int)(windowX*0.375),"Box \'5\'");
	outtextxy((int)(windowX*0.125),(int)(windowX*0.625),"Box \'6\'");
	outtextxy((int)(windowX*0.375),(int)(windowX*0.625),"Box \'7\'");
	outtextxy((int)(windowX*0.625),(int)(windowX*0.625),"Box \'8\'");
}

void drawCompleteBoard()
{
	drawBoard();
	drawHalfPoints();
	drawBoxNames();
	//if()
}
	 
	*/
}
