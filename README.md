## What is this repository about?

This is a Java app that I used to "cheat" in Cat Clicker MLG flash game. The mentioned game is similar to Cookie Clicker. Anyway, it consists in collecting items (in this case, coins and gems) by clicking a cat a lot of times. When you have a lot of coins, you can purchase some elements (one of them is John Cena, lmao) that give you coins in an automatic way, so you earn more coins in each second the more you have of these stuff. You can also buy upgrades too.

This game can become somewhat addictive, and it becomes annoying when you have to wait lots of time to get lots of stuff, so I though6 a way to try to automatize it. The first thing I discovered is that, while you are offline and then you reload the game, you gain the 10% of the earnings you would have won if you were online that time. The game does that comparing the date of your device when you saved and your current date. So, setting 2099 as your year date when reloading the game is a easy way to gain lots of coins/gems. However, you have to do it a lot of times when advanced in the game, and it becomes more boring.

Automatic clicks are done having into account where your "Reload" browser button and the flash frame are. However, the app isn't magic and you have to specify these locations by selecting two rectangles in your screen (you confirm then with a ugly lower button, or just pressing Enter). Still, it works decently fine, or at least, much much better than the very early version from a couple of years ago. You also specify the number of iterations it takes, so you don't get stuck eternally. I suggest you trying setting the two rectangles with a couple of iterations, and then setting a higher number if things went okay (that implies you leaving the PC alone for a while :) )

The main flow of the app is the following:

* Initializes stuff
* Simulates clicks withing the game, trying to fulfill the following events in order:
    * Entering the game
	* Gaining interesting boosts to improve the income obtained in the next iteration
	* Trying to buy John Cena upgrades, which are the most interesting because they boost the coin income the most
	* Saving the game
	* Reloading the game
* Toggles year date to 1980 or 2079

When you init the app, it gets your current date so it changes it back to the original one when it finishes the number of iterations you specified. Strange temporal things might happen to you computer because of those date changes, sorry.

## Possible future work
* Dates are changed using a Windows command. It would  be interesting to detect the OS automatically and implement the date change in the Linux equivalent way, to be more versatile.
* Maybe loading/saving your selected rectangles so you don't have to specify then every time you run the application.
* Add some magic so it detects the desired rectangles automatically (feasible?)
