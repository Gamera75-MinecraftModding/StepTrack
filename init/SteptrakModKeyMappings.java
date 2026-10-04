/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.steptrack.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.steptrack.network.StatsdisplaykeyMessage;
import net.mcreator.steptrack.network.StatisticsunitconversionkeyMessage;

@EventBusSubscriber(Dist.CLIENT)
public class SteptrakModKeyMappings {
	public static final KeyMapping STATSDISPLAYKEY = new KeyMapping("key.steptrak.statsdisplaykey", GLFW.GLFW_KEY_I, KeyMapping.Category.GAMEPLAY) {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new StatsdisplaykeyMessage(0, 0));
				StatsdisplaykeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping STATISTICSUNITCONVERSIONKEY = new KeyMapping("key.steptrak.statisticsunitconversionkey", GLFW.GLFW_KEY_U, KeyMapping.Category.GAMEPLAY) {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new StatisticsunitconversionkeyMessage(0, 0));
				StatisticsunitconversionkeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(STATSDISPLAYKEY);
		event.register(STATISTICSUNITCONVERSIONKEY);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				STATSDISPLAYKEY.consumeClick();
				STATISTICSUNITCONVERSIONKEY.consumeClick();
			}
		}
	}
}