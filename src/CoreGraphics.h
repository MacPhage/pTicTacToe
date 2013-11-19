//
//  CoreGraphics.h
//  Potent TicTacToe
//
//  C++ Header File
//
//  Created by Austin Jackson,
//  Last modified on November 14, 2013.
//
//  http://www.ruthlessphysics.com/potent/
//

#include <graphics.h>
#include "CoreGUI.h"

using namespace std;



bool enabled = true;

void drawBoard();
void welcomeScreen();
void DrawHalfPoints();
void drawX();
void drawO();
int boxDirectorX(int box);
int boxDirectorY(int box);
void drawBoxNames();
void drawCompleteBoard();
void circleTest();
void playDemo();

/*
0 1 2
3 4 5
6 7 8

*/
//TOP

int posTopLeftX = (int)(windowX*0.25);
int posTopLeftY = (int)(windowY*0.25);

int posTopMiddleX = (int)(windowX*0.50);
int posTopMiddleY = (int)(windowY*0.25);

int posTopRightX = (int)(windowX*0.75);
int posTopRightY = (int)(windowY*0.25);

//MIDDLE
int posMiddleLeftX = (int)(windowX*0.25);
int posMiddleLeftY = (int)(windowY*0.50);

int posMiddleMiddleX = (int)(windowX*0.50);
int posMiddleMiddleY = (int)(windowY*0.50);

int posMiddleRightX = (int)(windowX*0.75);
int posMiddleRightY = (int)(windowY*0.50);

//BOTTOM
int posBottomLeftX = (int)(windowX*0.25);
int posBottomLeftY = (int)(windowY*0.75);

int posBottomMiddleX = (int)(windowX*0.50);
int posBottomMiddleY = (int)(windowY*0.75);

int posBottomRightX = (int)(windowX*0.75);
int posBottomRightY = (int)(windowY*0.75);

void sustain()
{
	while(enabled == true)
	{
		delay(200);
	}
}

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

void showWin()
{
    //
}

void circleTest()
{
    int radius = 1;
    for(;;)
    {
        if(radius < windowX/2)
        {
            int a = windowX/2;
            while(a > 0)
            {
                circle(windowX/2,windowY/2,radius);
                cout<<"radius: "<<radius<<endl;
                delay(20);
                radius++;
                a--;
                cleardevice();
            }
        }
        else if(radius > windowX/2)
        {
            int b = windowX/2;
            while(b > 0)
            {
                circle(windowX/2,windowY/2,radius);
                cout<<"radius: "<<radius<<endl;
                delay(20);
                radius--;
                b--;
                cleardevice();
            }
        }
        radius++;
        cleardevice();
    }
}

void playDemo()
{
    while(true)
	{
		drawBoard();
		delay(1000);
		drawHalfPoints();
        delay(1000);
        drawBoxNames();
        delay(1000);
		drawX(posTopLeftX,posTopLeftY);
		drawO(posTopRightX,posTopRightY);
		delay(1000);
		cleardevice();
	}
}
