package ninjapancakes87.civilwar;

import net.minecraft.stats.AchievementList;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements {
	static final Achievement lead = new Achievement("lead", "lead", -1, -2, Registry.lead, AchievementList.acquireIron);
	static final Achievement war = new Achievement("war", "war", -1, 0, Registry.cannonball, lead);
	static final Achievement killer = new Achievement("killer", "killer", -1, 2, Registry.musket, war).setSpecial();
	static final Achievement coinage = new Achievement ("coinage", "coinage", 1, -2, Registry.coin, AchievementList.acquireIron);
	public static final Achievement merc = new Achievement("merc", "merc", 1, 0, Registry.unionuniform, coinage);
	static final Achievement mongol = new Achievement("mongol", "mongol", 1, 2, Registry.rebeluniform, merc).setSpecial();
	static final Achievement shot = new Achievement("shot", "shot", 3, -2, Registry.musketball, war);
	static final Achievement wither = new Achievement ("wither", "wither", 3, 0, Registry.saber, AchievementList.portal).setSpecial();
	static final Achievement end = new Achievement("dragon", "dragon", 3, 2, Registry.revolver, AchievementList.blazeRod).setSpecial();
	public static AchievementPage page = new AchievementPage("Civil War", lead, war, killer, coinage, merc, mongol, shot, wither, end);
}