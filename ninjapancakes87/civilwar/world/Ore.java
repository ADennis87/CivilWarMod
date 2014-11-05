package ninjapancakes87.civilwar.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import ninjapancakes87.civilwar.Registry;
import cpw.mods.fml.common.IWorldGenerator;

public class Ore implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId)
		 {
		 case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		 }
		
	}
	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	 {
	 	// will generate the ore 12 times per chunk
	 	int GenRate = 12;
		 for (int i = 0; i < GenRate; ++i) {
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(70);
		 	int Zcoord = blockZ + random.nextInt(16);

		 	(new WorldGenMinable(Registry.leadOre, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);}		 
	 }

}
