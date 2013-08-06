This mod requires forge.  Make sure you install it before installing this mod.

READ THE KNOWN BUGS OF WHAT VERSION YOU ARE USING BEFORE WHINING AND/OR NOTIFYING ME.  You probably will not be answered and/or recognized if you tell me about a bug I already know about.

Changelog:
	Build 1:
		First Build.
	Build 2:
		Total reorganization of code.  
		Fix for armor crash.
		Fix for Soldier AI and not attacking what you attack.
		Nerfed Soldier attack speed.
		Soldiers now spawn in a variety of biomes: Deserts, Desert Hills, Forest, Jungle, Hills, Plains, Extreme Hills.
	Build 3:
		Increased Soldier attack speed.  Still working on getting that perfect ;D
		Simplified texture names for armor and armor item.
		Fix for Union Spawn egg overriding Confederate spawn egg (this is the same fix as the Union Soldier having the same Entity ID as the Confederate Soldier).
		New spawn egg colors.
		Removed some unused imports and code cleanup (in my opinion, anyway :P)
		Fixed Confederate Cloth texture, it is now gray like it should have been, and uses light gray wool in its crafting recipe.
		All armor now is universal: helmet is called "cap" and is worn by both sides.  Same with "pants" and "boots".  The only thing that differs is the chestplate, or "uniform".  Please don't complain about this, look up some pictures on google images or better yet go to social studies, and you will see both sides wore the same everything except chestplate, or "uniform"
		Added crafting for armor.  All armor is crafted with white wool except for the chestplate, which is crafted with the colored cloth.
		New confederate uniform.  
		Armor now renders upon a soldiers spawn
		You can now tell what class a soldier is by his held item.
			Soldier: Musket
			Captain: Revolver
			Commander: Coin (corresponding to which side he is: E.G, Union Coin for Union Commander)
			Doctor: Apple
			Barracks Master: Musket Ball
		Added in Confederate soldiers and their spawns.
		Changed where soldiers spawn.  Which soldier you will find now varies by biome.
			Union Soldier: Plains, Extreme Hills, Taiga
			Confederate Soldier: Desert, Desert Hills, Swamp
			Both: Forest
		Soldiers spawn much less commonly.
		Soldiers are no longer a "ambient" creature, they are a "creature" creature.
		Creative Tab now properly displays a musket as its symbol.
		A bunch of renaming, have fun figuring it all out =D
		cloth_1.png now only holds the Union uniform. All other pictures are in rebel_1.png, and the pants are in cloth_2.png
		Added death message.  If you are killed by a bullet, it will print "Was Shot" in your chat.
		Added mcmod.info
		KNOWN BUGS:
			Only part of the armor renders on newly spawned soldiers.  Uh-whuuuuut.
			Everybody holds a musket, regardless of class.  Needs to be fixed PRONTO.
	Build 3A:
		mcmod.info no longer has build name in the title
		updated readme.txt for build 3 changelog, it was missing a couple of things under armor crafting.
		Armor crafting now is color-specific, blue wool for the hat, colored cloth for chestplate, pants are cyan wool, and boots are black wool.
	Build 3B:
		Added the saber!  It lasts slightly longer than a gold sword (not very long) but deals massive damage, even greater than a diamond sword.
		Ammo is now craftable! two iron on top of each other gives you 16 musket balls.
		Cannonballs are now craftable! Iron surrounding a musket ball gives you 8 cannonballs.
		The cannon.  Boom.  No control yet besides the direction you have placed it.  And it doesn't fire.
		Soldiers now have skins and don't spawn with armor.  No more wierd bugs, yay! To counterbalance the soldiers loss of armor, all soldiers except doctors have 5 more hearts, or 10 damage points.
		Change to the soldier AI.  Soldiers no longer follow you when fighting, this is so that they are more accurate.
		Soldiers now display their rank on their right shoulder!  To you it will seem like their left shoulder, but it is their right.
		Started some work on the nametag system.  The visible changed include Soldiers being named Soldier (Private) and Commanders being renamed to General of the Army.
	Build 4:
		New: Updated to 1.6.2
		New: SMP Compatible!  That's right, now you can go attack each other on your favorite server!
		New: Added Lead Ore and lead!  Lead Ore is pretty common, and smelting lead ore gives you lead. If you replace iron with lead in the cannonball and musketball recipes, it doubles the output!
		New: Soldiers can be healed by red apples.  Restores 4 hit points, or 2 hearts.
		Fix: Musketballs are now called Minie Balls, to be historically accurate.
		Fix: New texture system for resource packs means we now have an assets folder.  Deleted the png's from my other mod that were being stored in there and the useless model folder with the techne file and the extra cannon.java so that should reduce file size too.
		Fix: Added pack.mcmeta
		Fix: Boots are now black like they should have been.
		Removed: Cannons have unfortuatenly been removed, and will be added back in once they are properly finished.
		Removed: Barrel and stock have been removed, crafting for musket is now like so:
			xxx
			 yz
			xxx
			where x is wood planks, y is a stick, and z is a flint and steel
		Removed: Removed two unused sounds: thud.wav and marching.wav.  Maybe find a replacement?  Probably not.
		Removed: Removed some unused classes and folders, should reduce size of file signifigantly.
	Build 4A:
		Fix: Fixed the fatal crash where the mod tried to put a texture that didn't exist onto an item that didn't exist.  derp on my part.
		Fix: Should have fixed mcmod.info not reading
		Fix: As long as a soldier has been injured, it can be healed.  It no longer requires you to have <20 Health
		Fix: Soldiers now go regular speed
	Build 5:
		New: Cannon has been readded.  It now has it's own custom sounds and shoots out cannonballs when right clicked.
		New/Fix: The musket and revolver death message have been redone, to include player names and whatnot, and cannonballs have one too.
		
Credits:
	Idea:EZI0SREVALATION
	Coding:ninjapancakes87
	Textures:ninjapancakes87... for now.  If you know anybody capable of texturing who is willing, contact me.  Two people have said they could do this but have shirked their jobs and never contacted back... :( BR0B0T2000 is working on them now, I believe