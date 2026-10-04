package net.mcreator.steptrack.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.steptrack.network.SteptrakModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TextdistanceProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static String execute(Entity entity) {
		return execute(null, entity);
	}

	private static String execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Unite_Stats == 0) {
			if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance < 1000) {
				return "Distance traveled : " + Math.floor(entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance) + " m";
			}
			return "Distance traveled : " + Math.floor(entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance / 10) / 100 + " Km";
		}
		if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Unite_Stats == 1) {
			return "Distance traveled : " + Math.round(entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance) + " Blocks";
		}
		return "Distance traveled : " + "?";
	}
}