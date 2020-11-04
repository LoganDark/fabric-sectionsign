package net.logandark.sectionsign.mixin;

import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Function;
import java.util.stream.Stream;

@Mixin(ServerPlayNetworkHandler.class)
public abstract class MixinServerPlayNetworkHandler {
	// in 1.16.3 and earlier, onSignUpdate uses Formatting.strip explicitly
	@Redirect(
		method = "onSignUpdate",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/util/Formatting;strip(Ljava/lang/String;)Ljava/lang/String;"
		),
		require = 0
	)
	private String sectionsigns$onSignUpdateStrip(@Nullable String string) {
		return string;
	}

	// in 1.16.4 and later, onSignUpdate uses map(Formatting::strip) on a Stream
	@Redirect(
		method = "onSignUpdate",
		at = @At(
			value = "INVOKE",
			target = "Ljava/util/stream/Stream;map(Ljava/util/function/Function;)Ljava/util/stream/Stream;"
		),
		require = 0
	)
	private Stream sectionsigns$onSignUpdateStripMap(Stream stream, Function<String, String> mapper) {
		return stream;
	}
}
