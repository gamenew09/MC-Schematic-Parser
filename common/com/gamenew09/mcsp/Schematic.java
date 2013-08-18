package com.gamenew09.mcsp;

import net.minecraft.block.Block;
import net.minecraft.nbt.*;

public class Schematic {
	
	private NBTTagCompound comp;
	
	public Schematic(NBTTagCompound compound){
		this.comp = compound;
	}
	
	public Block[] getSchematicBlocks() throws Exception{
		byte[] bBlocks = comp.getByteArray("Blocks");
		if(bBlocks.length == 0){
			return null;
		}
		throw new Exception(CompressedStreamTools.decompress(bBlocks).toString());
		//return null;
	}
	
}
