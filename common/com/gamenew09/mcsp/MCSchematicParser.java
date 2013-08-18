package com.gamenew09.mcsp;

import java.io.*;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class MCSchematicParser {
	
	private static DataInput load(ResourceLocation res) throws FileNotFoundException{
		File dataDir = Minecraft.getMinecraft().mcDataDir;
		File schDir = new File(dataDir, "/schematics/");
		String name = schDir.getAbsolutePath().replace(".", "") + "/";
		DataInputStream s = new DataInputStream(new BufferedInputStream(new FileInputStream(name + res.func_110624_b()+"/"+res.func_110623_a())));
		DataInput sa = s;
		return sa;
	}
	
	public static Schematic loadSchematic(ResourceLocation location) throws Exception, IOException, IllegalArgumentException{
		DataInput da = load(location);
		if(da == null){
			throw new Exception("Something went wrong with the load function.");
		}
		NBTTagCompound nbt = CompressedStreamTools.read((DataInput) da);
		if(nbt.getString("Materials") == "Classic"){
			throw new IllegalArgumentException(location.toString() + " is a Classic Schematic, this can not be used.");
		}
		Schematic schematic = new Schematic(nbt);
		return schematic;
	}
	
}
