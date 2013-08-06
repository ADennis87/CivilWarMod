package ninjapancakes87.civilwar;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.StatCollector;
import ninjapancakes87.civilwar.item.EntityCannonBall;
import ninjapancakes87.civilwar.item.EntityMusketBall;

public class DamageSources extends DamageSource{

	protected DamageSources(String par1Str) {
		super(par1Str);
	}
	public static DamageSource causeShotDamage(EntityMusketBall par0EntityMusketBall, Entity par1Entity) {
        return (new EntityDamageSourceIndirect("mb", par0EntityMusketBall, par1Entity)).setProjectile();
    }
    public static DamageSource causeBallDamage(EntityCannonBall par0EntityMusketBall, Entity par1Entity) {
        return (new EntityDamageSourceIndirect("cb", par0EntityMusketBall, par1Entity)).setProjectile();
    }
	
	@Override
	public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase)
    {
        EntityLivingBase entitylivingbase1 = par1EntityLivingBase.func_94060_bK();
        String s = "death.attack." + this.damageType + ".player";
        String s1 = s;
        return entitylivingbase1 != null && StatCollector.func_94522_b(s1) ? ChatMessageComponent.func_111082_b(s1, new Object[] {par1EntityLivingBase.getTranslatedEntityName(), entitylivingbase1.getTranslatedEntityName()}): ChatMessageComponent.func_111082_b(s, new Object[] {par1EntityLivingBase.getTranslatedEntityName()});
    }
}
