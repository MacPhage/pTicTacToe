//
//  main.cpp
//  Potent TicTacToe
//
//  C++ Source File
//
//  Created by Austin Jackson,
//  Last modified on November 14, 2013.
//
//  http://www.ruthlessphysics.com/potent/
//


#include "CoreGraphics.h"
#include "TicTacToe_private.h"

using namespace std;

int main()
{
    //Fl_Window *window = new Fl_Window(340,180);
  	//Fl_Box *box = new Fl_Box(20,40,300,100,"Hello, World!");

	cout<<"Version: "<<VER_STRING<<endl;
	cout<<"Window resolution set to "<<windowX<<"x"<<windowY<<"."<<endl;
	gameWelcome();
	gameSetup();
	
	initwindow(windowX,windowY,"Potent TicTacToe");
	
	if(debugMode == true)
	{
        outtextxy(windowX/2,windowY/2,"i'm supposed to do something important...");
    }
	
	while(gameDone == false)
	{
		drawCompleteBoard();
		outtextxy(0,0,"Player #1 (X's): ");
		//outtextxy(75,0,player1.getName());
		outtextxy(0,20,"Player #2 (O's): ");
		//outtextxy(75,20,player2.getName());
        do
        {
    		cout<<player1.getName()<<", where should your \'X\' go?"<<endl;
    		cout<<"Box #: ";
    		cin>>intA;
    		if(intA >= 0 && intA <= 8 && game[intA] == 0)
    		{
                game[intA] = 1;
                drawX(boxDirectorX(intA),boxDirectorY(intA));
                canContinue = true;
            }
            else
            {
                cout<<"\nThat was not a valid Box number, or the space was already taken.\nTry checking the graphic window.\n"<<endl;
                canContinue = false;
            }
        }
        while(canContinue == false);
        numberOfTurns++;
        if(checkForWinX() == true)
        {
            cout<<"\n\n"<<player1.getName()<<" has won!"<<endl;
            cout<<"The game lasted "<<numberOfTurns<<" individual turns."<<endl;
            gameDone = true;
            pause();
            break;
        }
        else if(checkForTie() == true)
        {
            cout<<"\n\nThe game between "<<player1.getName()<<" and "<<player2.getName()<<" has resulted in a tie!"<<endl;
            cout<<"The game lasted "<<numberOfTurns<<" individual turns."<<endl;
            gameDone = true;
            pause();
            break;
        }
        clearIns();
        do
        {
    		cout<<player2.getName()<<", where should your \'O\' go?"<<endl;
    		cout<<"Box #: ";
    		cin>>intB;
    		if(intB >= 0 && intB <= 8 && game[intB] == 0)
    		{
                game[intB] = 2;
                drawO(boxDirectorX(intB),boxDirectorY(intB));
                canContinue = true;
            }
            else
            {
                cout<<"\nThat was not a valid Box number, or the space was already taken.\nTry checking the graphic window.\n"<<endl;
                canContinue = false;
            }
        }
        while(canContinue == false);
        numberOfTurns++;
        if(checkForWinO() == true)
        {
            cout<<"\n\n"<<player2.getName()<<" has won!"<<endl;
            cout<<"The game lasted "<<numberOfTurns<<" individual turns."<<endl;
            gameDone = true;
            pause();
            break;
        }
        else if(checkForTie() == true)
        {
            cout<<"\n\nThe game between "<<player1.getName()<<" and "<<player2.getName()<<" has resulted in a tie!"<<endl;
            cout<<"The game lasted "<<numberOfTurns<<" individual turns."<<endl;
            gameDone = true;
            pause();
            break;
        }
	}
    cout<<"\nGame over. Ending program."<<endl;
    pause();
}
