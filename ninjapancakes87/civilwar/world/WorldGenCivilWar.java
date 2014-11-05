package ninjapancakes87.civilwar.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenCivilWar implements IWorldGenerator 
{
 public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
 {
  switch (world.provider.dimensionId)
  {
  case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
  default: generateSurface(world, random, chunkX*16, chunkZ*16);
  }
 }

  

  private void generateSurface(World world, Random random, int blockX, int blockZ) 
 { 
  int Xcoord1 = blockX + random.nextInt(16);
  int Ycoord1 = random.nextInt(80);
  int Zcoord1 = blockZ + random.nextInt(16);
   
  (new WorldGenSpawn()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
 }

}