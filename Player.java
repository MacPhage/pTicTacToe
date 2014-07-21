//
//  Player.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.ptictactoe;

import com.ruthlessphysics.util.stringmanipulation.Purify;

public class Player
{
	public static String name;
	public static int score;
	public static int nextDraw;

	public Player()
	{
	}
	public Player(String newName)
	{
		name = Purify.alphanumeric(newName);
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	public String getName()
	{
		return name;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int newScore)
	{
		score = newScore;
	}
	public int getNextDraw()
	{
		return nextDraw;
	}
	public void setNextDraw(int newDraw)
	{
		nextDraw = newDraw;
	}
}

/* Original C++

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

*/