package net.mcreator.steptrack.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.steptrack.network.SteptrakModVariables;

public class ToggledisplaystatisticsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).OnOff_stats == 0) {
			{
				SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
				_vars.OnOff_stats = 1;
				_vars.markSyncDirty();
			}
		} else {
			{
				SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
				_vars.OnOff_stats = 0;
				_vars.markSyncDirty();
			}
		}
	}
}