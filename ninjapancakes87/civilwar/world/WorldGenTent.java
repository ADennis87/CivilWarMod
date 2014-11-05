package ninjapancakes87.civilwar.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import ninjapancakes87.civilwar.entity.EntitySoldier_Union;

public class WorldGenTent {

    public boolean generate(World world, Random rand, int i, int j, int k)
    {
    	EntitySoldier_Union soldierunion = new EntitySoldier_Union(world);
    	world.setBlock(i, j, k, Blocks.diamond_ore);
    	world.setBlock(i, j + 1, k + 2, Blocks.fence);
    	world.setBlock(i, j + 2, k + 2, Blocks.fence);
    	world.setBlock(i, j + 3, k + 2, Blocks.fence);
    	world.setBlock(i + 3, j + 1, k + 2, Blocks.wool);
    	world.setBlock(i + 3, j + 1, k + 1, Blocks.wool);
    	world.setBlock(i + 3, j + 1, k, Blocks.wool);
    	world.setBlock(i + 3, j + 1, k - 1, Blocks.wool);
    	world.setBlock(i + 3, j + 1, k - 2, Blocks.wool);
    	world.setBlock(i - 3, j + 1, k + 2, Blocks.wool);
    	world.setBlock(i - 3, j + 1, k + 1, Blocks.wool);
    	world.setBlock(i - 3, j + 1, k, Blocks.wool);
    	world.setBlock(i - 3, j + 1, k - 1, Blocks.wool);
    	world.setBlock(i - 3, j + 1, k - 2, Blocks.wool);
    	world.setBlock(i + 2, j + 2, k + 2, Blocks.wool);
    	world.setBlock(i + 2, j + 2, k + 1, Blocks.wool);
    	world.setBlock(i + 2, j + 2, k, Blocks.wool);
    	world.setBlock(i + 2, j + 2, k - 1, Blocks.wool);
    	world.setBlock(i + 2, j + 2, k - 2, Blocks.wool);
    	world.setBlock(i - 2, j + 2, k + 2, Blocks.wool);
    	world.setBlock(i - 2, j + 2, k + 1, Blocks.wool);
    	world.setBlock(i - 2, j + 2, k, Blocks.wool);
    	world.setBlock(i - 2, j + 2, k - 1, Blocks.wool);
    	world.setBlock(i - 2, j + 2, k - 2, Blocks.wool);
    	world.setBlock(i - 1, j + 3, k + 2, Blocks.wool);
    	world.setBlock(i - 1, j + 3, k + 1, Blocks.wool);
    	world.setBlock(i - 1, j + 3, k, Blocks.wool);
    	world.setBlock(i - 1, j + 3, k -1, Blocks.wool);
    	world.setBlock(i - 1, j + 3, k - 2, Blocks.wool);
    	world.setBlock(i + 1, j + 3, k + 2, Blocks.wool);
    	world.setBlock(i + 1, j + 3, k + 1, Blocks.wool);
    	world.setBlock(i + 1, j + 3, k, Blocks.wool);
    	world.setBlock(i + 1, j + 3, k - 1, Blocks.wool);
    	world.setBlock(i + 1, j + 3, k - 2, Blocks.wool);
    	world.setBlock(i, j + 4, k + 2, Blocks.wool);
    	world.setBlock(i, j + 4, k + 1, Blocks.wool);
    	world.setBlock(i, j + 4, k, Blocks.wool);
    	world.setBlock(i, j + 4, k - 1, Blocks.wool);
    	world.setBlock(i, j + 4, k - 2, Blocks.wool);
    	//soldierunion.setHomeArea(i, j + 1, k, 3000);
    	soldierunion.setProfession(0);
    	soldierunion.setLocationAndAngles(i, j + 1, k, 0.0F, 0.0F);
        world.spawnEntityInWorld(soldierunion);
    	return true;
    }
}
