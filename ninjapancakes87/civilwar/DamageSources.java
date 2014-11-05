package ninjapancakes87.civilwar;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import ninjapancakes87.civilwar.entity.EntityMusketBall;

public class DamageSources extends DamageSource{

	protected DamageSources(String par1Str) {
		super(par1Str);
	}
	public static DamageSource causeShotDamage(EntityMusketBall par0EntityMusketBall, Entity par1Entity) {
		return (new EntityDamageSourceIndirect("mb", par0EntityMusketBall, par1Entity)).setProjectile();
    }
}
