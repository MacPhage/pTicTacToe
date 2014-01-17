//
//  main.cpp
//  Potent TicTacToe
//
//  C++ Source File
//
//  Created by Austin Jackson,
//  Last modified on December 25, 2013.
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

    //potentIntro(800,800);

	cout<<"Version: "<<VER_STRING<<endl;
	cout<<"Window resolution set to "<<windowX<<"x"<<windowY<<"."<<endl;
	gameWelcome();
	gameSetup();
	
	initwindow(windowX,windowY,"Potent TicTacToe");
	//guiStart();
	
	if(debugMode == 1)
	{
        drawCompleteBoard();
        outtextxy(0,40,"Debug mode ACTIVE!");
        cout<<"debugger, where should your \'X\' go?"<<endl;
    	cout<<"Box # combo: ";
    	cin>>intA;
    	game[intA] = 1;
    	drawX(boxDirectorX(intA),boxDirectorY(intA));
    	
    	cin>>intA;
    	game[intA] = 1;
    	drawX(boxDirectorX(intA),boxDirectorY(intA));
    	
    	cin>>intA;
    	game[intA] = 1;
    	drawX(boxDirectorX(intA),boxDirectorY(intA));

        if(checkForWinX() == true)
        {
            winType = checkForWinTypeX();
            if(winType == 0)
                drawWinningMove(0,2);
            else if(winType == 1)
                drawWinningMove(0,8);
            else if(winType == 2)
                drawWinningMove(0,6);
            else if(winType == 3)
                drawWinningMove(1,7);
            else if(winType == 4)
                drawWinningMove(2,8);
            else if(winType == 5)
                drawWinningMove(3,5);
            else if(winType == 6)
                drawWinningMove(6,8);
            else if(winType == 7)
                drawWinningMove(6,2);
            cout<<"\n\nA bloody debugger has won!"<<endl;
            cout<<"The game lasted "<<numberOfTurns<<" individual turns."<<endl;
            cout<<"The game-winning move is shown in yellow."<<endl;
            cout<<"By the way, that didn't count, you debuggin' cheater."<<endl;
            gameDone = true;
            pause();
        }
        else
        {
            cleardevice();
            closegraph();
            cout<<"\nWell then, idiot. Typically, the purpose of the debugging mode is to test WINNING CONDITIONS, and do you think NOT WINNING will help that at all? Huh? DO YOU?"<<endl;
            cout<<"I give up on you, dunce."<<endl;
            delay(20000);
            return 1;
        }

    }
    if(debugMode == 2)
        circleTest();
    while(debugMode == 3)
        potentIntro(1024,1024);
	
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
            winType = checkForWinTypeX();
            if(winType == 0)
                drawWinningMove(0,2);
            else if(winType == 1)
                drawWinningMove(0,8);
            else if(winType == 2)
                drawWinningMove(0,6);
            else if(winType == 3)
                drawWinningMove(1,7);
            else if(winType == 4)
                drawWinningMove(2,8);
            else if(winType == 5)
                drawWinningMove(3,5);
            else if(winType == 6)
                drawWinningMove(6,8);
            else if(winType == 7)
                drawWinningMove(6,2);
            cout<<"\n\n"<<player1.getName()<<" has won!"<<endl;
            cout<<"The game lasted "<<numberOfTurns<<" individual turns."<<endl;
            cout<<"The game-winning move is shown in yellow."<<endl;
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
            winType = checkForWinTypeO();
            if(winType == 0)
                drawWinningMove(0,2);
            else if(winType == 1)
                drawWinningMove(0,8);
            else if(winType == 2)
                drawWinningMove(0,6);
            else if(winType == 3)
                drawWinningMove(1,7);
            else if(winType == 4)
                drawWinningMove(2,8);
            else if(winType == 5)
                drawWinningMove(3,5);
            else if(winType == 6)
                drawWinningMove(6,8);
            else if(winType == 7)
                drawWinningMove(6,2);
            cout<<"\n\n"<<player2.getName()<<" has won!"<<endl;
            cout<<"The game lasted "<<numberOfTurns<<" individual turns."<<endl;
            cout<<"The game-winning move is shown in yellow."<<endl;
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
