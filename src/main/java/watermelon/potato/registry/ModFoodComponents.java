package watermelon.potato.registry;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent POTATO_BLOCK = new FoodComponent.Builder()
            .nutrition(10)
            .saturationModifier(6F)
            .build();
    public static final FoodComponent COOKED_POTATO_BLOCK = new FoodComponent.Builder()
            .nutrition(20)
            .saturationModifier(20F)
            .build();
}
