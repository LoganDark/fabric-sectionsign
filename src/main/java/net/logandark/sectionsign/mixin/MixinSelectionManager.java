package net.logandark.sectionsign.mixin;

import net.minecraft.client.util.SelectionManager;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SelectionManager.class)
public abstract class MixinSelectionManager {
	@Redirect(
		method = "getClipboard",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/util/Formatting;strip(Ljava/lang/String;)Ljava/lang/String;"
		)
	)
	private static String sectionsigns$onGetClipboardStrip(@Nullable String string) {
		return string;
	}
}
