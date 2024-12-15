package watermelon.potato.common.Item;

import net.minecraft.item.PickaxeItem;
import watermelon.potato.registry.ModMaterials;

public class PotatoPickaxe extends PickaxeItem {
    public PotatoPickaxe(Settings settings) {
        super(ModMaterials.POTATO_TOOL_MATERIAL, 2.5f, 1, settings);
    }
}
