package net.voidbehemoth.UUAU.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.entity.thrown.ThrownExperienceBottleEntity;
import net.voidbehemoth.UUAU.common.entity.thrownskylathersoapbottle.ThrownSkylatherSoapBottleEntity;
import net.voidbehemoth.UUAU.common.items.SkylatherSoapBottleItem;

import static net.voidbehemoth.UUAU.UpUpAndUpdate.SKYLATHER_SOAP;

public class UUAUClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(ThrownSkylatherSoapBottleEntity.class, ((entityRenderDispatcher, context) -> new FlyingItemEntityRenderer<ThrownSkylatherSoapBottleEntity>(entityRenderDispatcher, MinecraftClient.getInstance().getItemRenderer())));
        System.out.println("It happened!!!");
    }
}
