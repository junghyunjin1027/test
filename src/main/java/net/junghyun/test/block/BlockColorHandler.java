package net.junghyun.test.block;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BlockColorHandler {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void registerBlockColourHandlers(final RegisterColorHandlersEvent.Block event)
    {
        // Use the colour of the biome or the default colour
        final BlockColor grassColourHandler = (state, blockAccess, pos, tintIndex) -> {

            if (blockAccess != null && pos != null)
            {
                return BiomeColors.getAverageFoliageColor(blockAccess, pos);
            }

            return GrassColor.get(0.5D, 1.0D);
        };
        event.getBlockColors().register(grassColourHandler, BlockRegistry.LEMON_LEAVES.get());
    }
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void registerItemColourHandlers(final RegisterColorHandlersEvent.Item event)
    {
        // Use the Block's colour handler for an ItemBlock
        final ItemColor itemBlockColourHandler = (stack, tintIndex) -> {
            BlockState iblockstate = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(iblockstate, null, null, tintIndex);
        };

        event.getItemColors().register(itemBlockColourHandler, BlockRegistry.LEMON_LEAVES.get());
    }
}
