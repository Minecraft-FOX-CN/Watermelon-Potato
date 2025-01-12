package watermelon.potato.common.Item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import watermelon.potato.registry.ModItems;
import watermelon.potato.registry.ModMaterials;

public class PotatoSword extends SwordItem {
    public PotatoSword(Settings settings) {
        super(ModMaterials.POTATO_TOOL_MATERIAL, 3.5f, 0.5f, settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(user.getItemCooldownManager().isCoolingDown(new ItemStack(ModItems.POTATO_SWORD))) return ActionResult.FAIL;
        if(!user.getWorld().isClient) {
            entity.damage((ServerWorld) user.getWorld(), entity.getDamageSources().playerAttack(user), Float.MAX_VALUE);
        }
        user.getItemCooldownManager().set(new ItemStack(ModItems.POTATO_SWORD), 20);
        user.addVelocity(2.5 * Math.cos(Math.PI/2 + user.getYaw() / 180 * Math.PI),
                -(user.getPitch() / 45),
                2.5 * Math.sin(Math.PI/2 + user.getYaw() / 180 * Math.PI));
        return ActionResult.SUCCESS;
    }
}
