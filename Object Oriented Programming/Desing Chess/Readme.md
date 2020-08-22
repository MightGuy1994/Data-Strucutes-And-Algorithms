# Design Chess

## System Requirements

	1. The Application should take two players and assign colors (black, white)
	2. A 8*8 grid should be created with white pieces and black pieces on both sides of the board.
	3. All the pieces on the board. A player is assigned the color and he can move only his assigned color pieces
	4. A random toss should assign which player goes first.
	5. player one select the piece position and destination
	6. check if piece can move in that position (empty bin, not same color)
	7. 


## Actors:
	1. Player
	2. System

## Functionalities
	1. player
		- start the game
		- move the piece on the board.
		- Check
		- Checkmate
	2. system
		- intialize the board.
		- Check if the move is vaid
		- Declare Winner

## Core Objects
	1. Piece
		-isValidMove()
	2. Deck
	3. Board
		- intializeBoard();
		- refreshBoard();
		- movePawns();
	4. Game
	5. Player



 
