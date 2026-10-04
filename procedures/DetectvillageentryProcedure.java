package net.mcreator.steptrack.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DetectvillageentryProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static boolean execute(LevelAccessor world, Entity entity) {
		return execute(null, world, entity);
	}

	private static boolean execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if ((world instanceof ServerLevel _level3 && _level3.isVillage(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) == true) {
			if (entity instanceof ServerPlayer _player)
				_player.sendSystemMessage(Component.literal("Village"), true);
			return true;
		} else if ((world instanceof ServerLevel _level8 && _level8.isVillage(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) == false) {
			return false;
		}
		return true;
	}
}