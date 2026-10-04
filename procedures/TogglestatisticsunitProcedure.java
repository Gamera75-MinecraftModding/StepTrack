package net.mcreator.steptrack.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.steptrack.network.SteptrakModVariables;

public class TogglestatisticsunitProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Unite_Stats == 0) {
			{
				SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
				_vars.Unite_Stats = 1;
				_vars.markSyncDirty();
			}
		} else {
			{
				SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
				_vars.Unite_Stats = 0;
				_vars.markSyncDirty();
			}
		}
	}
}