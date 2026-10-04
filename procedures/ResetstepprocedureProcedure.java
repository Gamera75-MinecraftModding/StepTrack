package net.mcreator.steptrack.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.steptrack.network.SteptrakModVariables;

public class ResetstepprocedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
			_vars.Reset = true;
			_vars.markSyncDirty();
		}
		for (int index5 = 0; index5 < 10; index5++) {
			{
				SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
				_vars.Initialized_position = false;
				_vars.markSyncDirty();
			}
			SteptrakModVariables.WorldVariables.get(world).initialized_world = false;
			SteptrakModVariables.WorldVariables.get(world).markSyncDirty();
			{
				SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
				_vars.Former_x = entity.getX();
				_vars.former_z = entity.getZ();
				_vars.traveled_distance = 0;
				_vars.Ten_m = false;
				_vars.One_hundred_m = false;
				_vars.One_thousand_km = false;
				_vars.ten_km = false;
				_vars.One_hundred_km = false;
				_vars.fifty_km = false;
				_vars.five_km = false;
				_vars.markSyncDirty();
			}
		}
		{
			SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
			_vars.Former_x = entity.getX();
			_vars.traveled_distance = 0;
			_vars.former_z = entity.getZ();
			_vars.Reset = false;
			_vars.markSyncDirty();
		}
	}
}