package net.mcreator.steptrack.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.steptrack.network.SteptrakModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TextspeedProcedure {
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
			return "Current speed : " + Math.floor(entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Current_speed * 10) / 10 + " m/s";
		}
		if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Unite_Stats == 1) {
			return "Current speed : " + Math.floor(entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Current_speed * 10) / 10 + " bps";
		}
		return "Current speed : " + " ?";
	}
}