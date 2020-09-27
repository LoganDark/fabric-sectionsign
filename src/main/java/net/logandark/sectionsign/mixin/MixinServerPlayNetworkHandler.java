package net.logandark.sectionsign.mixin;

import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayNetworkHandler.class)
public abstract class MixinServerPlayNetworkHandler {
	@Redirect(
		method = "onSignUpdate",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/util/Formatting;strip(Ljava/lang/String;)Ljava/lang/String;"
		)
	)
	private String sectionsigns$onSignUpdateStrip(@Nullable String string) {
		return string;
	}
}
