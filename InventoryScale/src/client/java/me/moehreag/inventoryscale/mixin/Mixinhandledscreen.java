import com.mojang.blaze3d.vertex.PoseStack;

@Inject(method = "render", at = @At("HEAD"))
private void inventoryscale$applyScaleHead(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
    float scale = InventoryScaleClient.getScale();
    if (scale == 1.0f) return;
    
    // 1.21.1: context.getMatrices().push();
    // 1.21: 
    PoseStack pose = context.pose();
    pose.pushPose();
    pose.scale(scale, scale, 1.0F);
}

@Inject(method = "render", at = @At("RETURN"))
private void inventoryscale$applyScaleReturn(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
    float scale = InventoryScaleClient.getScale();
    if (scale == 1.0f) return;
    
    // 1.21.1: context.getMatrices().pop();
    // 1.21:
    context.pose().popPose();
}
