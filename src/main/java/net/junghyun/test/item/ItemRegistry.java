package net.junghyun.test.item;

import net.junghyun.test.Test;
import net.junghyun.test.block.BlockRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public final static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Test.MOD_ID);

    public static final RegistryObject<Item> LEMON =
            ITEMS.register("lemon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(2.4F).effect(() -> new MobEffectInstance(MobEffects.LUCK, 400), 100).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 2), 100).build())));
    public static final RegistryObject<Item> SQUID_LEGS =
            ITEMS.register("squid_legs", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(6F).effect(() -> new MobEffectInstance(MobEffects.POISON, 400, 2), 100).effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 400), 100).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 400, 2), 100).build())));

    public static final RegistryObject<Item> LEMON_LEAVES = ITEMS.register("lemon_leaves", () -> new BlockItem(BlockRegistry.LEMON_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> LEMON_SAPLING = ITEMS.register("lemon_sapling", () -> new BlockItem(BlockRegistry.LEMON_SAPLING.get(), new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
