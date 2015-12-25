## What is this repository about?

This is a stupid Java app that I used to "cheat" Cat Clicker MLG flash game. It is in a **very early alpha stage**, so **don't expect this to run safely**!

The mentioned game is simillat to Cookie Clicker. Anyway, it consists of collecting items (in this case, coins and gems) by clicking a cat a lot of times. When you have a lot of coins, you can purchase some elements (one is John Cena, lol) that give you coins in a automatic way, so you earn more coins in each second the more you have of these staff. You can also buy upgrades too.
Anyway, this game is somewhat addictive, and it becomes annoying when you have to wait lots of time to get lots of stuff, so I though a way to automatize it. The first thing I discovered is that, while you are offline and then reload the game, you gain the 10% of the earnings you would have won if you were online that time. The game does that comparing the date of your device when you saved and your current date. So, setting 2099 as your year date when reloading the game is a easy way to gain lots of coins. However, you have to do it a lot of times when advanced in the game, and it becomes annoying.

The main flow of the app is the following:

* Initializes stuff
* Simulates clicks withing the game, trying to fulfill the following events in order:
    * Entering the game
	* Gaining interesting boosts to improve the income obtained in the next iteration
	* Trying to buy John Cena upgrades, which are the most interesting because they boost the coin income the most
	* Saving the game
	* Reloading the game
* Toggles year date to 1980 or 2079

When you init the app, it gets your current date so it changes it back to the original one when you exit the application.

## Which problems does it present?
Clicks simulation are done with raw x/y positions. This means that its correct behaviour relies heavily on how the flash game is distributed in your monitor. In the next image I will show you my distribution if you want to emulate it. I have a 1366x768 resolution, with the game maximized in a Firefox window, with menu bar included:
![Distribution](https://raw.githubusercontent.com/miguellopezbecona/Cat-Clicker-Cheater/master/distribution.png)

## I executed it and I can't close it!
Oh no... Well, if you have the app focused in, try with Alt+E (shortcut for the "Exit" button). If you can't close it by doing Alt+F4s, you may have to hard-turn off your computer, sorry, the app is very bad by now.
I suggest you playing with the source code before executing it.
