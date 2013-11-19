//
//  CoreGame.h
//  Potent TicTacToe
//
//  C++ Header File
//
//  Created by Austin Jackson,
//  Last modified on November 14, 2013.
//
//  http://www.ruthlessphysics.com/potent/
//

#include "Player.h"
#include <iostream>
#include <stdio.h>

using namespace std;

int windowX = 600;
int windowY = 600;
int intA, intB, intC, intD;
int game[9] = {0,0,0,0,0,0,0,0,0};
int numberOfTurns = 0;
Player player1, player2;
string temp;
bool isWindows = false;
bool canContinue;
bool gameDone = false;
bool debugMode = false;
char pauseChar = '0';

/*
0 1 2
3 4 5
6 7 8

 null = 0, X = 1, O = 2
*/

void pause();
bool checkForWinX();
bool checkForWinO();
bool checkForTie();
void graphicSetup();
void gameWelcome();
void gameSetup();
void gameLoop();
void clearIns();

void pause()
{
    if(isWindows == true)
    {
        system("PAUSE");
    }
    else if(isWindows == false)
    {
		cout<<"Press any key to continue . . ."<<endl;
		getchar();
    }
    else
    {
        cout<<"[A problem happened while trying to pause();"<<endl;
    }
}

bool checkForWinX()
{
	if(game[0] == 1 && game[1] == 1 && game[2] == 1)
	{
		return true;
	}
	else if(game[0] == 1 && game[4] == 1 && game[8] == 1)
	{
		return true;
	}
	else if(game[0] == 1 && game[3] == 1 && game[6] == 1)
	{
		return true;
	}
	else if(game[1] == 1 && game[4] == 1 && game[7] == 1)
	{
		return true;
	}
	else if(game[2] == 1 && game[5] == 1 && game[8] == 1)
	{
		return true;
	}
	else if(game[3] == 1 && game[4] == 1 && game[5] == 1)
	{
		return true;
	}
	else if(game[6] == 1 && game[7] == 1 && game[8] == 1)
	{
		return true;
	}
	else if(game[2] == 1 && game[4] == 1 && game[6] == 1)
	{
		return true;
	}
	else
	{
		return false;
	}
}
bool checkForWinO()
{
	if(game[0] == 2 && game[1] == 2 && game[2] == 2)
	{
		return true;
	}
	else if(game[0] == 2 && game[4] == 2 && game[8] == 2)
	{
		return true;
	}
	else if(game[0] == 2 && game[3] == 2 && game[6] == 2)
	{
		return true;
	}
	else if(game[1] == 2 && game[4] == 2 && game[7] == 2)
	{
		return true;
	}
	else if(game[2] == 2 && game[5] == 2 && game[8] == 2)
	{
		return true;
	}
	else if(game[3] == 2 && game[4] == 2 && game[5] == 2)
	{
		return true;
	}
	else if(game[6] == 2 && game[7] == 2 && game[8] == 2)
	{
		return true;
	}
	else if(game[2] == 2 && game[4] == 2 && game[6] == 2)
	{
		return true;
	}
	else
	{
		return false;
	}
}

bool checkForTie()
{
    if(game[0] != 0 && game[1] != 0 && game[2] != 0 && game[3] != 0 && game[4] != 0 && game[5] != 0 && game[6] != 0 && game[7] != 0 && game[8] != 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}

void graphicSetup()
{
	bool goodSize;
	do
	{
    	cout<<"RECOMMENDED SIZE = 400"<<endl;
		cout<<"Enter desired window resolution: ";
		cin>>intA;
		if(!(intA >= 100 && intA <= 800))
		{
			goodSize = false;
			cout<<"\nThe window size must be between 100 and 800."<<endl;
			cout<<"Please try again."<<endl;
		}
		else if(intA >= 100 && intA <= 800)
		{
			windowX = intA;
			windowY = intA;
			goodSize = true;
			cout<<"Window resolution set to "<<windowX<<"x"<<windowY<<". Initializing game window."<<endl;
		}
		else
		{
			cout<<"Please try again."<<endl;
		}
	}
	while(goodSize == false);
	
}

void gameWelcome()
{
	cout<<"Welcome to Potent TicTacToe."<<endl;
	cout<<"\nThis program works by asking which box you would\nlike to mark \'X\' or \'O\' while it's your turn."<<endl;
	cout<<"This is a two-player game. There is no AI (yet)."<<endl;
	cout<<"Player1 has \'X\' and Player2 has \'O\'."<<endl;
	cout<<"\nLet's begin.\n"<<endl;
	system("PAUSE");
}

void gameSetup()
{
	cout<<"Enter Player1 name: ";
	getline(cin,temp);
	player1.setName(temp);
	temp = "";
	cout<<"Enter Player2 name: ";
	getline(cin,temp);
	player2.setName(temp);
	temp = "";
	
	if(player1.getName() == "debug" && player2.getName() == "this shit")
	{
        debugMode = true;
    }
	
	cout<<"Player 1\'s name: "<<player1.getName()<<endl;
	cout<<"Player 2\'s name: "<<player2.getName()<<endl;
	system("PAUSE");
	
}

void clearIns()
{
    intA = 0;
    intB = 0;
    intC = 0;
    intD = 0;
}
