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

import net.mcreator.steptrack.network.SteptrakModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CalculateplayerdistanceProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Reset == false) {
			if (SteptrakModVariables.WorldVariables.get(world).initialized_world == false) {
				{
					SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
					_vars.traveled_distance = 0;
					_vars.Current_speed = 0;
					_vars.One_thousand_km = false;
					_vars.Ten_m = false;
					_vars.One_hundred_m = false;
					_vars.Initialized_position = false;
					_vars.markSyncDirty();
				}
				SteptrakModVariables.WorldVariables.get(world).initialized_world = true;
				SteptrakModVariables.WorldVariables.get(world).markSyncDirty();
			} else {
				if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Initialized_position == false) {
					{
						SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
						_vars.Former_x = entity.getX();
						_vars.former_z = entity.getZ();
						_vars.Initialized_position = true;
						_vars.Current_speed = 0;
						_vars.markSyncDirty();
					}
				}
				if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Initialized_position == true) {
					{
						SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
						_vars.Current_speed = 0;
						_vars.traveled_distance = entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance
								+ Math.sqrt((entity.getZ() - entity.getData(SteptrakModVariables.PLAYER_VARIABLES).former_z) * (entity.getZ() - entity.getData(SteptrakModVariables.PLAYER_VARIABLES).former_z)
										+ (entity.getX() - entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Former_x) * (entity.getX() - entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Former_x));
						_vars.Current_speed = Math.sqrt((entity.getZ() - entity.getData(SteptrakModVariables.PLAYER_VARIABLES).former_z) * (entity.getZ() - entity.getData(SteptrakModVariables.PLAYER_VARIABLES).former_z)
								+ (entity.getX() - entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Former_x) * (entity.getX() - entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Former_x)) * 20;
						_vars.Former_x = entity.getX();
						_vars.former_z = entity.getZ();
						_vars.markSyncDirty();
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 10) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).Ten_m == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.Ten_m = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 10 m !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 10 m !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 100) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).One_hundred_m == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.One_hundred_m = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 100 m !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 100 m !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 1000) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).One_thousand_km == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.One_thousand_km = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 1 km !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 1 km !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 5000) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).five_km == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.five_km = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 5 km !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 5 km !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 10000) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).ten_km == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.ten_km = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 10 km !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 10 km !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 50000) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).One_hundred_km == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.One_hundred_km = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 50 km !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 50 km !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 100000) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).One_hundred_km == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.One_hundred_km = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 100 km !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 100 km !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 250000) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).two_hundred_fifty_km == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.two_hundred_fifty_km = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 250 km !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 250 km !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 500000) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).five_hundred_km == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.five_hundred_km = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 500 km !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 500 km !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 750000) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).seven_hundred_fifty_km == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.seven_hundred_fifty_km = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 750 km !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 750 km !")), false);
							}
						}
					}
					if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).traveled_distance >= 1000000) {
						if (entity.getData(SteptrakModVariables.PLAYER_VARIABLES).one_thousand_km == false) {
							{
								SteptrakModVariables.PlayerVariables _vars = entity.getData(SteptrakModVariables.PLAYER_VARIABLES);
								_vars.one_thousand_km = true;
								_vars.markSyncDirty();
							}
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal("You've traveled 1000 km !"), true);
							if (world instanceof ServerLevel _level) {
								_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " traveled 1000 km !")), false);
							}
						}
					}
				}
			}
		}
	}
}