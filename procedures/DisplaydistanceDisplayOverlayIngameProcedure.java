package net.mcreator.steptrack.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.steptrack.network.SteptrakModVariables;

public class DisplaydistanceDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).OnOff_stats == 0) {
			return true;
		}
		return false;
	}
}