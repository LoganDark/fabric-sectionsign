package net.logandark.sectionsign.mixin;

import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Function;
import java.util.stream.Stream;

@Mixin(ServerPlayNetworkHandler.class)
public abstract class MixinServerPlayNetworkHandler {
	@ModifyArg(
		method = "onSignUpdate",
		at = @At(
			value = "INVOKE",
			target = "Ljava/util/stream/Stream;map(Ljava/util/function/Function;)Ljava/util/stream/Stream;",
			ordinal = 0
		),
		index = 0
	)
	private <T> Function<? super T, ? extends T> sectionsigns$onSignUpdateStrip(Function<? super T, ? extends T> mapper) {
		return (unused) -> unused; // identity
	}
}
