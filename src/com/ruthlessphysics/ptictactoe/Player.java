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

import javax.swing.JOptionPane;

import org.lwjgl.opengl.Display;

import com.ruthlessphysics.util.Debug;
import com.ruthlessphysics.util.stringmanipulation.Purify;

public class Player
{
	public String name;
	public int score;
	public int nextDraw;
	public int id;

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
	public void setID(int newID)
	{
		id = newID;
	}
	public int getID()
	{
		return id;
	}


	public void doNextTurn()
	{
		int box;
		do
		{
			try
			{
				box = Integer.parseInt(JOptionPane.showInputDialog(getName()+", what box number should your next move be in?"));
				if(box == -1)
				{
					Debug.alert("Intentionally quitting.");
					Display.destroy();
					System.exit(0);
				}
				if(box >= 0 && box <= 8 && Game.progress[box] == 0)
				{
					Game.progress[box] = id;
					if(id == 1)
					{
						Visuals.drawX(box);
					}
					else if(id == 2)
					{
						Visuals.drawO(box);
					}
					Game.canContinue = true;
				}
				else
				{
					Debug.alert("\nThat was not a valid Box number, or the space was already taken.\nTry checking the graphic window.\n");
					Game.canContinue = false;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Debug.displayError(e);
				JOptionPane.showMessageDialog(null, "That wasn\'t a proper number.", "pTicTacToe", JOptionPane.WARNING_MESSAGE);
			}
		}
		while(Game.canContinue == false);

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