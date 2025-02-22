package subaraki.pga.mixin;

import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import subaraki.pga.event.ContainerEventHandler;

@Mixin(ServerPlayer.class)
public class ContainerCloseMixin {
    
    @Inject(method = "doCloseContainer", at = @At("TAIL"))
    public void doCloseContainer(CallbackInfo ci) {
        
        ServerPlayer player = (ServerPlayer) (Object) this;
        ContainerEventHandler.closeContainerEvent(player, player.containerMenu);
    }
    
}
