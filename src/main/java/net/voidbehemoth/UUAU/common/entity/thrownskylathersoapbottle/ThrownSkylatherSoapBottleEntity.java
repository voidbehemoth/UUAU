package net.voidbehemoth.UUAU.common.entity.thrownskylathersoapbottle;

import net.minecraft.class_3857;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.voidbehemoth.UUAU.common.items.SkylatherSoapBottleItem;

import static net.voidbehemoth.UUAU.UpUpAndUpdate.SKYLATHER_SOAP;
import static net.voidbehemoth.UUAU.UpUpAndUpdate.THROWN_SKYLATHER_SOAP;

public class ThrownSkylatherSoapBottleEntity extends class_3857 {
    public ThrownSkylatherSoapBottleEntity(EntityType<? extends ThrownSkylatherSoapBottleEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    public ThrownSkylatherSoapBottleEntity(World world_1, LivingEntity livingEntity_1) {
        super(THROWN_SKYLATHER_SOAP, livingEntity_1, world_1);
    }

    public ThrownSkylatherSoapBottleEntity(World world_1, double double_1, double double_2, double double_3) {
        super(THROWN_SKYLATHER_SOAP, double_1, double_2, double_3, world_1);
    }

    @Override
    protected Item method_16942() {
        return SKYLATHER_SOAP;
    }
    @Override
    protected float getGravity() {
        return 0.07F;
    }
    @Override
    protected void onCollision(HitResult hitResult_1) {
        if (!this.world.isClient) {
            this.world.playEvent(2002, new BlockPos(this), PotionUtil.getColor(Potions.WATER));
            int int_1 = 3 + this.world.random.nextInt(5) + this.world.random.nextInt(5);

            while(int_1 > 0) {
                int int_2 = ExperienceOrbEntity.roundToOrbSize(int_1);
                int_1 -= int_2;
                this.world.spawnEntity(new ExperienceOrbEntity(this.world, this.x, this.y, this.z, int_2));
            }

            this.invalidate();
        }

    }
}
