package watermelon.potato.registry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModMaterials {
    public static final ToolMaterial POTATO_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            131, 4.0F, 1.0F, 32,
            TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("potato")));
}
