package watermelon.potato.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.Nullable;
import watermelon.potato.registry.ModItems;
import watermelon.potato.registry.ModSoundEvents;

import java.util.Optional;

public class WatermelonPotatoBlock extends Block {
    public WatermelonPotatoBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        world.playSoundAtBlockCenter(pos, ModSoundEvents.POTATO_INTRODUCTION, SoundCategory.BLOCKS, 1f, 1f, true);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        world.playSoundAtBlockCenter(pos, ModSoundEvents.POTATO_INTRODUCTION_REVERSAL, SoundCategory.BLOCKS, 1f, 1f, true);
        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
        return state;
    }

    @Override
    public void onDestroyedByExplosion(ServerWorld world, BlockPos pos, Explosion explosion) {
        explode(world, pos);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.getMainHandStack().getItem().equals(ModItems.POTATO_SWORD) && !world.isClient()) {
            world.playSoundAtBlockCenter(pos, ModSoundEvents.POTATO_INTRODUCTION, SoundCategory.BLOCKS, 1f, 1f, true);
            player.sendMessage(Text.translatable("message.wap.use_on_potato_sword"), false);
            explode(world, pos);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION;
    }

    private void explode(World world, BlockPos explodedPos) {
        world.removeBlock(explodedPos, false);
        ExplosionBehavior explosionBehavior = new ExplosionBehavior() {
            @Override
            public Optional<Float> getBlastResistance(Explosion explosion, BlockView world, BlockPos pos, BlockState blockState, FluidState fluidState) {
                return super.getBlastResistance(explosion, world, pos, blockState, fluidState);
            }
        };
        Vec3d vec3d = explodedPos.toCenterPos();
        world.createExplosion(null, Explosion.createDamageSource(world, null), explosionBehavior, vec3d, 10.0F, true, World.ExplosionSourceType.BLOCK);
    }
}
