package watermelon.potato.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import watermelon.potato.registry.ModSoundEvents;

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
}
