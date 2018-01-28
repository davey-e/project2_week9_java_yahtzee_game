# Project Brief - Yahtzee Game

Goal - Practice OO modelling and logic implementation in Java

Build the logic for a Yahtzee game that could be applied to a UI front-end

## MVP
Create the classes and logic required to implement a simple version of a Yahtzee game with only the upper section of the scoresheet. Implement the logic such that only human players would be playing. i.e. the player has to make decisions about which dice to hold and which line of the scoresheet to assign the points to at the end of each turn.

* Players will roll 5 dice 3 times each turn
* On each roll they can hold any of the 5 dice and re-roll the rest
* Once they have completed 3 rolls they then decide which line of the scoresheet to assign the score to (following normal Yahtzee scoring rules for the upper section)
* Make sure that they cannot assign the score to a line that already has a score
* Allow any number of players to play (including just 1 player)
* Each player will get exactly 6 turns (the number of lines on the upper section of the scoresheet)
* Add up the scores for each player once they have completed all the turns that they are allowed
* Determine which player has the highest score


## Extensions
* Create a runner so that the game can be played as a console app or implement an android front-end
* Implement the lower section of the normal Yahtzee scoresheet so that players can choose to assign their score to either the upper section or lower section. Make sure that players cannot assign the score to a line that would not match the dice they have at the end of the turn
* Implement Yahtzee bonus rules (allowing more than one Yahtzee to be scored)
