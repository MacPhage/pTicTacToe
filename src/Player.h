//
//  Player.h
//  Potent TicTacToe
//
//  C++ Class Header File
//
//  Created by Austin Jackson,
//  Last modified on November 14, 2013.
//
//  http://www.ruthlessphysics.com/potent/
//

#include <string>

using namespace std;

class Player
{
	public:
	string name;
	int score;
	int nextDraw;
	
	void setName(string newName)
	{
		name = newName;
	}
	string getName()
	{
		return name;
	}
	int getScore()
	{
		return score;
	}
	void setScore(int newScore)
	{
		score = newScore;
	}
	int getNextDraw()
	{
		return nextDraw;
	}
	void setNextDraw(int newDraw)
	{
		nextDraw = newDraw;
	}

};
