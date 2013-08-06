package ninjapancakes87.civilwar.block.cannon;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.item.EntityCannonBall;

public final class DispenserBehaviorCannon extends BehaviorProjectileDispense
{
    /**
     * Return the projectile entity spawned by this dispense behavior.
     */
    protected IProjectile getProjectileEntity(World par1World, IPosition par2IPosition)
    {
        EntityCannonBall entityarrow = new EntityCannonBall(par1World, par2IPosition.getX() + 1, par2IPosition.getY() + 1, par2IPosition.getZ());
        entityarrow.canBePickedUp = 0;
        return entityarrow;
    }
}
