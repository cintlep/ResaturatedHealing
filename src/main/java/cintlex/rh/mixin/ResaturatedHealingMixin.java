package cintlex.rh.mixin;

import net.minecraft.entity.player.HungerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(HungerManager.class)
public class ResaturatedHealingMixin {

    @Shadow
    private int foodLevel;

    @Shadow
    private float saturationLevel;

    @ModifyArg(method = "update",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/server/network/ServerPlayerEntity;heal(F)V"),
            index = 0)
    private float modifyHealAmount(float healAmount) {
        boolean isSaturationHealing = this.foodLevel >= 20 && this.saturationLevel > 0.0f;

        if (isSaturationHealing) {
            return 0.5f;
        }

        return healAmount;
    }
}