# Bise-Joseph-Team

##Too Quiet on the Pacific Theater
###Robbie Bise and Travis Joseph

###Description (Robbie)
This is a text-based RPG. You play the part of a young man newly enlisted in the American army in 1944. After intense assessments you are put on a special team and sent to an uncharted island in the south pacific for a top secret mission. Your briefing is vague and unspecific but you deduct that the Nazis have been conducting experiments and developing a weapon of some sorts on this island.  

The game map will be 6x6 squares and each square will be a 5x5 “room” or area that contains either enemies items or animals. As you go through this room you will explore unidentified tiles that, as you walk over them, will reveal what is in that tile and an interaction will take place. These interactions can include a battle or initiate end user stories such as pick up item.

You will slowly discover clues as you go throughout the map, as well as discover a key and a bomb. These clues will inform you that the Nazi’s have been performing experiments to reanimate the dead and militarize them. The key will be used to open the zombie fortress and the bomb to destroy the oil barrels stored at its heart.
 
###End User Stories(Both)
 * Start the program
 * Main menu
 * Getting help
 * Start a game
 * Game menu
 * Move to a new location
 * Moving around a room
 * Look around a “room”
 * View the map
 * View list of inventory items
 * Pick up item
 * Use an Item
 * Equip Item
Attack
Unlock the  base
Plant the bomb

###Description of the end user Stories:

####Start the program (Robbie)
The program is started by the user and the computer displays a title screen, the player is asked to press enter to continue and is prompted for a name. A main menu is then displayed.

####Main menu (Both)
Enter - Start game
H - Help
S - Save Game
E - Exit

####Getting help
Will display a short description of the game and how it is played. Will also show the commands displayed in the game menu. 

####Start a game
This will be an option that allows the user to start a new game. It will initiate the original story and set up the game for the user.

####Game menu (Both)
The game menu is basically just a key of the input the user can put in:
 * H-get help / display this menu
 * N - travel north (E-east, S-south, w-west)
 * L-Look around a room
 * M-view map
 * V-view inventory
 * Each item will have unique letter-code to use or discard ex. “key - use key”

####View the map (Robbie)
Your character will start at the far right bottom corner of the map. The map will be a 6x6 box each unvisited square will have a ‘?’ at the top showing that you have not yet visited it. You will have to make your way through the different locations or “rooms” on the map and search for different items

 

####Look around a “room”(Robbie)
Rooms will contain various items, enemies or animals, denoted by an “i” for  investigatable object.  Your player will be shown as an ‘x’ on the screen. When you choose to look around a “room”, the description from when you first entered the room will appear on the bottom of the screen along with the map of the room. Investigated objects will be denoted by a letter showing what kind of object identified unless it was picked up or killed. (a for animal, w for weapon, m for miscellaneous item and e for enemy.)

 

####Moving around a “room”(Robbie)
Using the N, E, S and W commands you can move your character around the board. When a character moves on top of an investigatable object the nature of the object will be revealed and the user will be prompted to pickup an item, attack an enemy or flee an enemy.  

####Move to a new location(Robbie)
You will move your character around the map looking for weapons/clues etc. Whenever you enter a new room by exiting out of one of the 4 exit locations (denoted by “^ v < >”), a description of the room will appear along with the map of the new room you have entered.

####View list of inventory items - Travis
You will have a list of items contained in your inventory, which you can view, and then use or equip said items. These items affect combat and have various uses. Each item will have a unique key binded to it that you will press to equip it.


####Pick up an item
Each room will contain various things to interact with, one or more of which will be an item. When you move onto the space with the item, you will be prompted whether or not you want to pick that item up and place it in your inventory or leave it there.

####Use an item
Throughout the game there will be various useable items and events that require the use of a specific item, you will be prompted if you have the item if you want to use it, and if you don’t have it you will be prompted to go find it.

####Equip item
This option allows the user to equip an item that is in his inventory that is also equippable. These will be items that modify attack or defense

####Attack
This is a scene in which the user will battle some sort of enemy. You will have an attack and defense modifier and some health. The items you have equipped will effect these attributes, and the enemy will have similar attributes.

####Unlock the base
This is a special event in which the user will be able to unlock the Zombie base and enter and get close to the end of the game. The user will only be able to do it if they have a special item (a key) that they need to find somewhere on the map before entering the base. If they do not have the key, it will display a message that will tell the user to go find the key. If they do have the key it will ask them if they wish to open the base or not.

####Plant the bomb
This is the end condition for the game. You need to find a bomb somewhere on the map before entering the base. You will find some sort of object such as oil barrels where you can plant a bomb and destroy the base and all the zombies. When you approach the barrels you will receive a message telling you to go find the bomb if you don’t have it yet, or asking you whether or not you will plant the bomb.

####End Game
This happens once the bomb is planted. The rest of the story will be displayed to the user and the game will end.
