//
//  LibVenom.h
//  Potent "Venom" Helpful Header
//
//  C++ Header File
//
//  Created by Austin Jackson,
//  Last modified on December 22, 2013.
//
//  http://www.ruthlessphysics.com/potent/
//

#include <string>
#include <stdio.h>
#include <cstdlib>
#include <stdlib.h>
#include <conio.h>

//WINBGIm COLORS
#define BLACK 0
#define BLUE 1
#define GREEN 2
#define CYAN 3
#define RED 4
#define MAGENTA 5
#define BROWN 6
#define LIGHTGRAY 7
#define DARKGRAY 8
#define LIGHTBLUE 9
#define LIGHTGREEN 10
#define LIGHTCYAN 11
#define LIGHTRED 12
#define LIGHTMAGENTA 13
#define YELLOW 14
#define WHITE 15

//KEYBOARD KEYS
#define KEY_UP 72
#define KEY_DOWN 80
#define KEY_LEFT 75
#define KEY_RIGHT 77
#define KEY_SPACEBAR 32
#define KEY_ESC 27

//MATH CONSTANTS
#define PI 3.14159265


using namespace std;

void pauseConsole()
{
    cout<<"Press any key to continue . . ."<<endl;
	getch();
}

string boolToString(bool A)
{
    if(A == true)
    {
        return "true";
    }
    else if(A == false)
    {
        return "false";
    }
    else
    {
        return "ERROR";
    }
}

bool charToBool(char A)
{
	if((A == 'Y' || A == 'y') || (A == 'T' || A == 't'))
	{
		return true;
	}
	else if((A == 'N' || A == 'n') || (A == 'F' || A == 'f'))
	{
		return false;
	}
	else
	{
		return false;
	}
}

int randIntBetween(int from, int to)
{
    return rand() % to + from;
}

string combineStrings(string A, string B)
{
    return A+B;
}
