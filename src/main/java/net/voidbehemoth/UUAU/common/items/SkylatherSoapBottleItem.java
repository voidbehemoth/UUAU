package net.voidbehemoth.UUAU.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ExperienceBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.voidbehemoth.UUAU.common.entity.thrownskylathersoapbottle.ThrownSkylatherSoapBottleEntity;

public class SkylatherSoapBottleItem extends ExperienceBottleItem {
    public SkylatherSoapBottleItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world_1, PlayerEntity playerEntity_1, Hand hand_1) {
        ItemStack itemStack_1 = playerEntity_1.getStackInHand(hand_1);
        if (!playerEntity_1.abilities.creativeMode) {
            itemStack_1.subtractAmount(1);
        }

        world_1.playSound((PlayerEntity)null, playerEntity_1.x, playerEntity_1.y, playerEntity_1.z, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!world_1.isClient) {
            ThrownSkylatherSoapBottleEntity thrownSkylatherSoapBottleEntity = new ThrownSkylatherSoapBottleEntity(world_1, playerEntity_1);
            thrownSkylatherSoapBottleEntity.method_16940(itemStack_1);
            thrownSkylatherSoapBottleEntity.calculateVelocity(playerEntity_1, playerEntity_1.pitch, playerEntity_1.yaw, -20.0F, 0.7F, 1.0F);
            thrownSkylatherSoapBottleEntity.setPosition(playerEntity_1.x, playerEntity_1.y, playerEntity_1.z);
            System.out.println("Setting position...");
            world_1.spawnEntity(thrownSkylatherSoapBottleEntity);
            System.out.println("spawned entity");
        }

        playerEntity_1.incrementStat(Stats.USED.getOrCreateStat(this));
        return new TypedActionResult(ActionResult.SUCCESS, itemStack_1);
    }
}

