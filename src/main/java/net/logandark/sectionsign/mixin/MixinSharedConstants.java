package net.logandark.sectionsign.mixin;

import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SharedConstants.class)
public abstract class MixinSharedConstants {
	@Inject(
		method = "isValidChar",
		at = @At("HEAD"),
		cancellable = true
	)
	private static void sectionsign$onIsValidChar(char chr, CallbackInfoReturnable<Boolean> cir) {
		if (chr == '§') {
			cir.setReturnValue(true);
		}
	}
}
