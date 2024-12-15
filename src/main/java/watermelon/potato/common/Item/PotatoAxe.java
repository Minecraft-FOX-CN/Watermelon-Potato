package watermelon.potato.common.Item;

import net.minecraft.item.AxeItem;
import watermelon.potato.registry.ModMaterials;

public class PotatoAxe extends AxeItem {
    public PotatoAxe(Settings settings) {
        super(ModMaterials.POTATO_TOOL_MATERIAL, 15.5f, 2, settings);
    }
}
