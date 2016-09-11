package am2.defs;

import static am2.api.compendium.CompendiumCategory.*;

import am2.LogHelper;
import am2.api.ArsMagicaAPI;
import am2.api.CraftingAltarMaterials;
import am2.api.SpellRegistry;
import am2.api.affinity.Affinity;
import am2.api.compendium.CompendiumCategory;
import am2.api.compendium.CompendiumEntry;
import am2.api.compendium.wrapper.StackMapWrapper;
import am2.api.skill.Skill;
import am2.api.spell.AbstractSpellPart;
import am2.blocks.tileentity.TileEntityCraftingAltar;
import am2.blocks.tileentity.TileEntityKeystoneRecepticle;
import am2.blocks.tileentity.TileEntityObelisk;
import am2.blocks.tileentity.flickers.FlickerOperatorButchery;
import am2.blocks.tileentity.flickers.FlickerOperatorContainment;
import am2.blocks.tileentity.flickers.FlickerOperatorFelledOak;
import am2.blocks.tileentity.flickers.FlickerOperatorFishing;
import am2.blocks.tileentity.flickers.FlickerOperatorFlatLands;
import am2.blocks.tileentity.flickers.FlickerOperatorGentleRains;
import am2.blocks.tileentity.flickers.FlickerOperatorInterdiction;
import am2.blocks.tileentity.flickers.FlickerOperatorItemTransport;
import am2.blocks.tileentity.flickers.FlickerOperatorLight;
import am2.blocks.tileentity.flickers.FlickerOperatorMoonstoneAttractor;
import am2.blocks.tileentity.flickers.FlickerOperatorNaturesBounty;
import am2.blocks.tileentity.flickers.FlickerOperatorPackedEarth;
import am2.blocks.tileentity.flickers.FlickerOperatorProgeny;
import am2.blocks.tileentity.flickers.FlickerOperatorRegistry;
import am2.items.ItemBindingCatalyst;
import am2.items.ItemCore;
import am2.items.ItemOre;
import am2.rituals.IRitualInteraction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LoreDefs {

	public static void postInit() {
		initGuides();
		initMechanics();
		initItems();
		initBlocks();
		initShapes();
		initModifiers();
		initComponents();
		initStructures();
		initMobs();
		initBosses();
		initTalents();
	}
	
	private static void initGuides() {
		createEntry(GUIDE, "your_first_spell", 5);
	}
	
	private static void initMechanics() {
		initAffinities();
		initEnchantments();
		createEntry(MECHANIC, "spell_creation", 3);
		createEntry(MECHANIC, "infusion", 1);		
		createEntry(MECHANIC, "mana", 1);		
		createEntry(MECHANIC, "magic_level", 1);		
		createEntry(MECHANIC, "burnout", 1);		
		createEntry(MECHANIC, "rituals", 1);		
		createEntry(MECHANIC, "moonstone_meteor", 1);		
		createEntry(MECHANIC, "armor_xp_infusion", 1);		
		createEntry(MECHANIC, "silver_skills", 3);		
	}
	
	private static void initEnchantments() {
		createEntry(MECHANIC_ENCHANTS, "magic_resistance", 1);
		createEntry(MECHANIC_ENCHANTS, "soulbound", 1);
	}
	
	private static void initAffinities() {
		createEntry(MECHANIC_AFFINITY, "affinities", 4);		
		createEntry(MECHANIC_AFFINITY, "earth_affinity", 1);		
		createEntry(MECHANIC_AFFINITY, "water_affinity", 1);		
		createEntry(MECHANIC_AFFINITY, "air_affinity", 1);		
		createEntry(MECHANIC_AFFINITY, "fire_affinity", 1);		
		createEntry(MECHANIC_AFFINITY, "nature_affinity", 1);		
		createEntry(MECHANIC_AFFINITY, "ice_affinity", 1);		
		createEntry(MECHANIC_AFFINITY, "lightning_affinity", 1);		
		createEntry(MECHANIC_AFFINITY, "life_affinity", 1);		
		createEntry(MECHANIC_AFFINITY, "arcane_affinity", 1);		
		createEntry(MECHANIC_AFFINITY, "ender_affinity", 1);		
	}
	
	private static void initItems() {
		createItemEntry("keystone", ItemDefs.keystone, 1);
		createItemEntry("mana_cake", ItemDefs.manaCake, 1);
		createItemEntry("crystal_wrench", ItemDefs.crystalWrench, 4);
		createItemEntry("spell_parchment", ItemDefs.spellParchment, 1);
		createItemEntry("crystal_phylactery", ItemDefs.crystalPhylactery, 1);
		createItemEntry("spell_staff_magitech", ItemDefs.spellStaffMagitech, 1);
		createItemEntry("spell_book", ItemDefs.spellBook, 1);
		createItemEntry("magic_broom", ItemDefs.magicBroom, 1);
		createItemEntry("nature_scythe", ItemDefs.natureScythe, 1);
		createItemEntry("arcane_spellbook", ItemDefs.arcaneSpellbook, 1);
		createItemEntry("winter_arm", ItemDefs.winterArm, 1);
		createItemEntry("air_sled", ItemDefs.airSled, 1);
		createItemEntry("earth_armor", ItemDefs.earthArmor, 1);
		createItemEntry("water_orbs", ItemDefs.waterOrbs, 1);
		createItemEntry("fire_ears", ItemDefs.fireEars, 1);
		createItemEntry("workbench_upgrade", ItemDefs.workbenchUpgrade, 1);
		createItemEntry("warding_candle", ItemDefs.wardingCandle, 1);
		createItemEntry("flicker_jar", ItemDefs.flickerJar, 1);
		createItemEntry("ender_boots", ItemDefs.enderBoots, 1);
		createItemEntry("lightning_charm", ItemDefs.lightningCharm, 1);
		createItemEntry("lifeward", ItemDefs.lifeWard, 1);
		createItemEntry("magitech_goggles", ItemDefs.magitechGoggles, 1);
		createItemEntry("chalk", ItemDefs.chalk, 1);
		createItemEntry("journal", ItemDefs.journal, 1);
		createItemEntry("deficit_crystal", ItemDefs.deficitCrystal, 1);
		
		createItemEntry(ITEM_ORE, "vinteum_dust", new ItemStack(ItemDefs.itemOre, 1, ItemOre.META_VINTEUM), 1);
		createItemEntry(ITEM_ORE, "arcane_compound", new ItemStack(ItemDefs.itemOre, 1, ItemOre.META_ARCANECOMPOUND), 1);
		createItemEntry(ITEM_ORE, "arcane_ash", new ItemStack(ItemDefs.itemOre, 1, ItemOre.META_ARCANEASH), 1);
		createItemEntry(ITEM_ORE, "purified_vinteum_dust", new ItemStack(ItemDefs.itemOre, 1, ItemOre.META_PURIFIED_VINTEUM), 1);
		createItemEntry(ITEM_ORE, "chimerite", new ItemStack(ItemDefs.itemOre, 1, ItemOre.META_CHIMERITE), 1);
		createItemEntry(ITEM_ORE, "blue_topaz", new ItemStack(ItemDefs.itemOre, 1, ItemOre.META_BLUE_TOPAZ), 1);
		createItemEntry(ITEM_ORE, "sunstone", new ItemStack(ItemDefs.itemOre, 1, ItemOre.META_SUNSTONE), 1);
		createItemEntry(ITEM_ORE, "moonstone", new ItemStack(ItemDefs.itemOre, 1, ItemOre.META_MOONSTONE), 1);

		createEntry(ITEM_ESSENCE, "essence", 1);
		createItemEntry(ITEM_ESSENCE, "essence_arcane", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.ARCANE)), 0);
		createItemEntry(ITEM_ESSENCE, "essence_earth", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.EARTH)), 0);
		createItemEntry(ITEM_ESSENCE, "essence_air", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.AIR)), 0);
		createItemEntry(ITEM_ESSENCE, "essence_fire", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.FIRE)), 0);
		createItemEntry(ITEM_ESSENCE, "essence_water", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.WATER)), 0);
		createItemEntry(ITEM_ESSENCE, "essence_nature", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.NATURE)), 0);
		createItemEntry(ITEM_ESSENCE, "essence_ice", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.ICE)), 0);
		createItemEntry(ITEM_ESSENCE, "essence_lightning", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.LIGHTNING)), 0);
		createItemEntry(ITEM_ESSENCE, "essence_life", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.LIFE)), 0);
		createItemEntry(ITEM_ESSENCE, "essence_ender", new ItemStack(ItemDefs.essence, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.ENDER)), 0);
		createItemEntry(ITEM_ESSENCE, "pure_essence", new ItemStack(ItemDefs.core, 1, ItemCore.PURE), 1);
		createItemEntry(ITEM_ESSENCE, "base_essence_core", new ItemStack(ItemDefs.core, 1, ItemCore.BASE_CORE), 1);
		createItemEntry(ITEM_ESSENCE, "high_essence_core", new ItemStack(ItemDefs.core, 1, ItemCore.HIGH_CORE), 1);
		createItemEntry(ITEM_ESSENCE, "essence_bag", new ItemStack(ItemDefs.essenceBag, 1, 0), 1);

		createEntry(ITEM_RUNE, "runes", 1);
		createItemEntry(ITEM_RUNE, "rune_blank", new ItemStack(ItemDefs.blankRune, 1, 0), 1);
		createItemEntry(ITEM_RUNE, "rune_black", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.BLACK.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_brown", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.BROWN.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_cyan", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.CYAN.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_gray", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.GRAY.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_green", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.GREEN.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_light_blue", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.LIGHT_BLUE.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_light_gray", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.SILVER.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_lime", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.LIME.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_magenta", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.MAGENTA.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_orange", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.ORANGE.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_pink", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.PINK.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_purple", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.PURPLE.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_red", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.RED.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_white", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.WHITE.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_yellow", new ItemStack(ItemDefs.rune, 1, EnumDyeColor.YELLOW.getDyeDamage()), 0);
		createItemEntry(ITEM_RUNE, "rune_bag", new ItemStack(ItemDefs.runeBag, 1, 0), 1);
	
		createEntry(ITEM_ARMOR_MAGE, "mage_armor", 1);
		createItemEntry(ITEM_ARMOR_MAGE, "helmet_mage", new ItemStack(ItemDefs.mageHood), 1);
		createItemEntry(ITEM_ARMOR_MAGE, "chest_mage", new ItemStack(ItemDefs.mageArmor), 1);
		createItemEntry(ITEM_ARMOR_MAGE, "legs_mage", new ItemStack(ItemDefs.mageLeggings), 1);
		createItemEntry(ITEM_ARMOR_MAGE, "boots_mage", new ItemStack(ItemDefs.mageBoots), 1);

		createEntry(ITEM_ARMOR_BATTLEMAGE, "battlemage_armor", 1);
		createItemEntry(ITEM_ARMOR_BATTLEMAGE, "helmet_battlemage", new ItemStack(ItemDefs.battlemageHood), 1);
		createItemEntry(ITEM_ARMOR_BATTLEMAGE, "chest_battlemage", new ItemStack(ItemDefs.battlemageArmor), 1);
		createItemEntry(ITEM_ARMOR_BATTLEMAGE, "legs_battlemage", new ItemStack(ItemDefs.battlemageLeggings), 1);
		createItemEntry(ITEM_ARMOR_BATTLEMAGE, "boots_battlemage", new ItemStack(ItemDefs.battlemageBoots), 1);
		
		createEntry(ITEM_AFFINITYTOME, "affinity_tome", 1);
		createItemEntry(ITEM_AFFINITYTOME, "tome_none", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.NONE)), 1);
		createItemEntry(ITEM_AFFINITYTOME, "tome_arcane", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.ARCANE)), 0);
		createItemEntry(ITEM_AFFINITYTOME, "tome_earth", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.EARTH)), 0);
		createItemEntry(ITEM_AFFINITYTOME, "tome_air", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.AIR)), 0);
		createItemEntry(ITEM_AFFINITYTOME, "tome_fire", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.FIRE)), 0);
		createItemEntry(ITEM_AFFINITYTOME, "tome_water", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.WATER)), 0);
		createItemEntry(ITEM_AFFINITYTOME, "tome_nature", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.NATURE)), 0);
		createItemEntry(ITEM_AFFINITYTOME, "tome_ice", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.ICE)), 0);
		createItemEntry(ITEM_AFFINITYTOME, "tome_lightning", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.LIGHTNING)), 0);
		createItemEntry(ITEM_AFFINITYTOME, "tome_life", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.LIFE)), 0);
		createItemEntry(ITEM_AFFINITYTOME, "tome_ender", new ItemStack(ItemDefs.affinityTome, 1, ArsMagicaAPI.getAffinityRegistry().getId(Affinity.ENDER)), 0);

		createEntry(ITEM_FOCI, "foci", 1);
		createItemEntry(ITEM_FOCI, "charge_focus", new ItemStack(ItemDefs.chargeFocus), 1);
		createItemEntry(ITEM_FOCI, "mana_focus", new ItemStack(ItemDefs.manaFocus), 1);
		createItemEntry(ITEM_FOCI, "lesser_focus", new ItemStack(ItemDefs.lesserFocus), 1);
		createItemEntry(ITEM_FOCI, "standard_focus", new ItemStack(ItemDefs.standardFocus), 1);
		createItemEntry(ITEM_FOCI, "greater_focus", new ItemStack(ItemDefs.greaterFocus), 1);
		createItemEntry(ITEM_FOCI, "item_focus", new ItemStack(ItemDefs.itemFocus), 1);
		createItemEntry(ITEM_FOCI, "player_focus", new ItemStack(ItemDefs.playerFocus), 1);
		createItemEntry(ITEM_FOCI, "monster_focus", new ItemStack(ItemDefs.mobFocus), 1);
		createItemEntry(ITEM_FOCI, "creature_focus", new ItemStack(ItemDefs.creatureFocus), 1);

		createEntry(ITEM_MANAPOTION, "mana_potion", 1);
		createItemEntry(ITEM_MANAPOTION, "mana_potion_lesser", new ItemStack(ItemDefs.lesserManaPotion), 1);
		createItemEntry(ITEM_MANAPOTION, "mana_potion_standard", new ItemStack(ItemDefs.standardManaPotion), 1);
		createItemEntry(ITEM_MANAPOTION, "mana_potion_greater", new ItemStack(ItemDefs.greaterManaPotion), 1);
		createItemEntry(ITEM_MANAPOTION, "mana_potion_epic", new ItemStack(ItemDefs.epicManaPotion), 1);
		createItemEntry(ITEM_MANAPOTION, "mana_potion_legendary", new ItemStack(ItemDefs.legendaryManaPotion), 1);
		createItemEntry(ITEM_MANAPOTION, "mana_boost_potion", new ItemStack(ItemDefs.liquidEssenceBottle), 1);
		createItemEntry(ITEM_MANAPOTION, "mana_martini", new ItemStack(ItemDefs.manaMartini), 1);

		createEntry(ITEM_BINDINGCATALYST, "binding_catalysts", 1);
		createItemEntry(ITEM_BINDINGCATALYST, "binding_catalyst_pickaxe", new ItemStack(ItemDefs.bindingCatalyst, 1, ItemBindingCatalyst.META_PICK), 0);
		createItemEntry(ITEM_BINDINGCATALYST, "binding_catalyst_axe", new ItemStack(ItemDefs.bindingCatalyst, 1, ItemBindingCatalyst.META_AXE), 0);
		createItemEntry(ITEM_BINDINGCATALYST, "binding_catalyst_sword", new ItemStack(ItemDefs.bindingCatalyst, 1, ItemBindingCatalyst.META_SWORD), 0);
		createItemEntry(ITEM_BINDINGCATALYST, "binding_catalyst_shovel", new ItemStack(ItemDefs.bindingCatalyst, 1, ItemBindingCatalyst.META_SHOVEL), 0);
		createItemEntry(ITEM_BINDINGCATALYST, "binding_catalyst_hoe", new ItemStack(ItemDefs.bindingCatalyst, 1, ItemBindingCatalyst.META_HOE), 0);
		createItemEntry(ITEM_BINDINGCATALYST, "binding_catalyst_bow", new ItemStack(ItemDefs.bindingCatalyst, 1, ItemBindingCatalyst.META_BOW), 0);
		createItemEntry(ITEM_BINDINGCATALYST, "binding_catalyst_shield", new ItemStack(ItemDefs.bindingCatalyst, 1, ItemBindingCatalyst.META_SHIELD), 0);

		createEntry(ITEM_FLICKERFOCUS, "flicker_focus", 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_itemtransport", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorItemTransport.instance)), 2);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_interdiction", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorInterdiction.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_containment", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorContainment.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_packed_earth", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorPackedEarth.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_flatlands", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorFlatLands.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_progeny", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorProgeny.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_butchery", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorButchery.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_lunartides", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorMoonstoneAttractor.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_light", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorLight.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_felled_oak", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorFelledOak.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_gentle_rains", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorGentleRains.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_natures_bounty", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorNaturesBounty.instance)), 1);
		createItemEntry(ITEM_FLICKERFOCUS, "flicker_focus_fishing", new ItemStack(ItemDefs.flickerFocus, 1, FlickerOperatorRegistry.instance.getMaskForOperator(FlickerOperatorFishing.instance)), 2);
	
		createEntry(ITEM_INSCRIPTIONUPGRADES, "inscription_upgrades", 1);	
		createItemEntry(ITEM_INSCRIPTIONUPGRADES, "inscription_tier_1_upgrade", new ItemStack(ItemDefs.inscriptionUpgrade, 1, 0), 0);
		createItemEntry(ITEM_INSCRIPTIONUPGRADES, "inscription_tier_2_upgrade", new ItemStack(ItemDefs.inscriptionUpgrade, 1, 1), 0);
		createItemEntry(ITEM_INSCRIPTIONUPGRADES, "inscription_tier_3_upgrade", new ItemStack(ItemDefs.inscriptionUpgrade, 1, 2), 0);
	}
	
	private static void initBlocks() {
		BLOCK.addEntry(new CompendiumEntry("obelisk")
				.addObject("compendium.obelisk.page1")
				.addObject(new ItemStack(BlockDefs.obelisk))
				.addObject("compendium.obelisk.page2")
				.addObject("compendium.obelisk.page3")
				.addObject(new TileEntityObelisk().getDefinition()));
	}
	
	private static void initShapes() {
		createShapeEntry("projectile", SpellRegistry.getShapeFromName("arsmagica2:projectile"), 1);
		createShapeEntry("channel", SpellRegistry.getShapeFromName("arsmagica2:channel"), 1);
		createShapeEntry("beam", SpellRegistry.getShapeFromName("arsmagica2:beam"), 1);
		createShapeEntry("self", SpellRegistry.getShapeFromName("arsmagica2:self"), 1);
		createShapeEntry("touch", SpellRegistry.getShapeFromName("arsmagica2:touch"), 1);
		createShapeEntry("zone", SpellRegistry.getShapeFromName("arsmagica2:zone"), 1);
		createShapeEntry("aoe", SpellRegistry.getShapeFromName("arsmagica2:aoe"), 1);
		createShapeEntry("chain", SpellRegistry.getShapeFromName("arsmagica2:chain"), 1);
		createShapeEntry("rune", SpellRegistry.getShapeFromName("arsmagica2:rune"), 1);
		createShapeEntry("contingency_fall", SpellRegistry.getShapeFromName("arsmagica2:contingency_fall"), 1);
		createShapeEntry("contingency_damage", SpellRegistry.getShapeFromName("arsmagica2:contingency_damage"), 1);
		createShapeEntry("contingency_fire", SpellRegistry.getShapeFromName("arsmagica2:contingency_fire"), 1);
		createShapeEntry("contingency_health", SpellRegistry.getShapeFromName("arsmagica2:contingency_health"), 1);
		createShapeEntry("contingency_death", SpellRegistry.getShapeFromName("arsmagica2:contingency_death"), 1);
		createShapeEntry("binding", SpellRegistry.getShapeFromName("arsmagica2:binding"), 1);
		createShapeEntry("wall", SpellRegistry.getShapeFromName("arsmagica2:wall"), 1);
		createShapeEntry("wave", SpellRegistry.getShapeFromName("arsmagica2:wave"), 1);
	}
	
	private static void initComponents() {
		createComponentEntry("accelerate", SpellRegistry.getComponentFromName("arsmagica2:accelerate"), 1);
		createComponentEntry("appropriation", SpellRegistry.getComponentFromName("arsmagica2:appropriation"), 1);
		createComponentEntry("astral_distortion", SpellRegistry.getComponentFromName("arsmagica2:astral_distortion"), 1);
		createComponentEntry("attract", SpellRegistry.getComponentFromName("arsmagica2:attract"), 1);
		createComponentEntry("banish_rain", SpellRegistry.getComponentFromName("arsmagica2:banish_rain"), 1);
		createComponentEntry("blind", SpellRegistry.getComponentFromName("arsmagica2:blind"), 1);
		createComponentEntry("blink", SpellRegistry.getComponentFromName("arsmagica2:blink"), 1);
		createComponentEntry("blizzard", SpellRegistry.getComponentFromName("arsmagica2:blizzard"), 1);
		createComponentEntry("charm", SpellRegistry.getComponentFromName("arsmagica2:charm"), 1);
		createComponentEntry("chrono_anchor", SpellRegistry.getComponentFromName("arsmagica2:chrono_anchor"), 1);
		createComponentEntry("create_water", SpellRegistry.getComponentFromName("arsmagica2:create_water"), 1);
		createComponentEntry("daylight", SpellRegistry.getComponentFromName("arsmagica2:daylight"), 1);
		createComponentEntry("dig", SpellRegistry.getComponentFromName("arsmagica2:dig"), 1);
		createComponentEntry("disarm", SpellRegistry.getComponentFromName("arsmagica2:disarm"), 1);
		createComponentEntry("dispel", SpellRegistry.getComponentFromName("arsmagica2:dispel"), 1);
		createComponentEntry("divine_intervention", SpellRegistry.getComponentFromName("arsmagica2:divine_intervention"), 1);
		createComponentEntry("drought", SpellRegistry.getComponentFromName("arsmagica2:drought"), 1);
		createComponentEntry("drown", SpellRegistry.getComponentFromName("arsmagica2:drown"), 1);
		createComponentEntry("ender_intervention", SpellRegistry.getComponentFromName("arsmagica2:ender_intervention"), 1);
		createComponentEntry("entangle", SpellRegistry.getComponentFromName("arsmagica2:entangle"), 1);
		createComponentEntry("falling_star", SpellRegistry.getComponentFromName("arsmagica2:falling_star"), 1);
		createComponentEntry("fire_damage", SpellRegistry.getComponentFromName("arsmagica2:fire_damage"), 1);
		createComponentEntry("fire_rain", SpellRegistry.getComponentFromName("arsmagica2:fire_rain"), 1);
		createComponentEntry("fling", SpellRegistry.getComponentFromName("arsmagica2:fling"), 1);
		createComponentEntry("flight", SpellRegistry.getComponentFromName("arsmagica2:flight"), 1);
		createComponentEntry("forge", SpellRegistry.getComponentFromName("arsmagica2:forge"), 1);
		createComponentEntry("freeze", SpellRegistry.getComponentFromName("arsmagica2:freeze"), 1);
		createComponentEntry("frost_damage", SpellRegistry.getComponentFromName("arsmagica2:frost_damage"), 1);
		createComponentEntry("fury", SpellRegistry.getComponentFromName("arsmagica2:fury"), 1);
		createComponentEntry("gravity_well", SpellRegistry.getComponentFromName("arsmagica2:gravity_well"), 1);
		createComponentEntry("grow", SpellRegistry.getComponentFromName("arsmagica2:grow"), 1);
		createComponentEntry("harvest_plants", SpellRegistry.getComponentFromName("arsmagica2:harvest_plants"), 1);
		createComponentEntry("haste", SpellRegistry.getComponentFromName("arsmagica2:haste"), 1);
		createComponentEntry("heal", SpellRegistry.getComponentFromName("arsmagica2:heal"), 1);
		createComponentEntry("ignition", SpellRegistry.getComponentFromName("arsmagica2:ignition"), 1);
		createComponentEntry("invisibility", SpellRegistry.getComponentFromName("arsmagica2:invisibility"), 1);
		createComponentEntry("knockback", SpellRegistry.getComponentFromName("arsmagica2:knockback"), 1);
		createComponentEntry("leap", SpellRegistry.getComponentFromName("arsmagica2:leap"), 1);
		createComponentEntry("levitate", SpellRegistry.getComponentFromName("arsmagica2:levitate"), 1);
		createComponentEntry("life_drain", SpellRegistry.getComponentFromName("arsmagica2:life_drain"), 1);
		createComponentEntry("life_tap", SpellRegistry.getComponentFromName("arsmagica2:life_tap"), 1);
		createComponentEntry("light", SpellRegistry.getComponentFromName("arsmagica2:light"), 1);
		createComponentEntry("lightning_damage", SpellRegistry.getComponentFromName("arsmagica2:lightning_damage"), 1);
		createComponentEntry("magic_damage", SpellRegistry.getComponentFromName("arsmagica2:magic_damage"), 1);
		createComponentEntry("mana_drain", SpellRegistry.getComponentFromName("arsmagica2:mana_drain"), 1);
		createComponentEntry("mana_link", SpellRegistry.getComponentFromName("arsmagica2:mana_link"), 2);
		createComponentEntry("mana_shield", SpellRegistry.getComponentFromName("arsmagica2:mana_shield"), 1);
		createComponentEntry("mark", SpellRegistry.getComponentFromName("arsmagica2:mark"), 1);
		createComponentEntry("moonrise", SpellRegistry.getComponentFromName("arsmagica2:moonrise"), 1);
		createComponentEntry("night_vision", SpellRegistry.getComponentFromName("arsmagica2:night_vision"), 1);
		createComponentEntry("physical_damage", SpellRegistry.getComponentFromName("arsmagica2:physical_damage"), 1);
		createComponentEntry("place_block", SpellRegistry.getComponentFromName("arsmagica2:place_block"), 2);
		createComponentEntry("plant", SpellRegistry.getComponentFromName("arsmagica2:plant"), 1);
		createComponentEntry("plow", SpellRegistry.getComponentFromName("arsmagica2:plow"), 1);
		createComponentEntry("random_teleport", SpellRegistry.getComponentFromName("arsmagica2:random_teleport"), 1);
		createComponentEntry("recall", SpellRegistry.getComponentFromName("arsmagica2:recall"), 1);
		createComponentEntry("reflect", SpellRegistry.getComponentFromName("arsmagica2:reflect"), 1);
		createComponentEntry("regeneration", SpellRegistry.getComponentFromName("arsmagica2:regeneration"), 1);
		createComponentEntry("repel", SpellRegistry.getComponentFromName("arsmagica2:repel"), 1);
		createComponentEntry("rift", SpellRegistry.getComponentFromName("arsmagica2:rift"), 1);
		createComponentEntry("shield", SpellRegistry.getComponentFromName("arsmagica2:shield"), 1);
		createComponentEntry("shrink", SpellRegistry.getComponentFromName("arsmagica2:shrink"), 1);
		createComponentEntry("silence", SpellRegistry.getComponentFromName("arsmagica2:silence"), 1);
		createComponentEntry("slow", SpellRegistry.getComponentFromName("arsmagica2:slow"), 1);
		createComponentEntry("slowfall", SpellRegistry.getComponentFromName("arsmagica2:slowfall"), 1);
		createComponentEntry("storm", SpellRegistry.getComponentFromName("arsmagica2:storm"), 1);
		createComponentEntry("summon", SpellRegistry.getComponentFromName("arsmagica2:summon"), 2);
		createComponentEntry("swift_swim", SpellRegistry.getComponentFromName("arsmagica2:swift_swim"), 1);
		createComponentEntry("telekinesis", SpellRegistry.getComponentFromName("arsmagica2:telekinesis"), 1);
		createComponentEntry("transplace", SpellRegistry.getComponentFromName("arsmagica2:transplace"), 1);
		createComponentEntry("true_sight", SpellRegistry.getComponentFromName("arsmagica2:true_sight"), 1);
		createComponentEntry("water_breathing", SpellRegistry.getComponentFromName("arsmagica2:water_breathing"), 1);
		createComponentEntry("watery_grave", SpellRegistry.getComponentFromName("arsmagica2:watery_grave"), 1);
		createComponentEntry("wizards_autumn", SpellRegistry.getComponentFromName("arsmagica2:wizards_autumn"), 1);
	}
	
	private static void initModifiers() {
		createModifierEntry("bounce", SpellRegistry.getModifierFromName("arsmagica2:bounce"), 1);
		createModifierEntry("buff_power", SpellRegistry.getModifierFromName("arsmagica2:buff_power"), 1);
		createModifierEntry("colour", SpellRegistry.getModifierFromName("arsmagica2:colour"), 1);
		createModifierEntry("damage", SpellRegistry.getModifierFromName("arsmagica2:damage"), 1);
		createModifierEntry("dismembering", SpellRegistry.getModifierFromName("arsmagica2:dismembering"), 1);
		createModifierEntry("duration", SpellRegistry.getModifierFromName("arsmagica2:duration"), 1);
		createModifierEntry("feather_touch", SpellRegistry.getModifierFromName("arsmagica2:feather_touch"), 1);
		createModifierEntry("gravity", SpellRegistry.getModifierFromName("arsmagica2:gravity"), 1);
		createModifierEntry("healing", SpellRegistry.getModifierFromName("arsmagica2:healing"), 1);
		createModifierEntry("lunar", SpellRegistry.getModifierFromName("arsmagica2:lunar"), 1);
		createModifierEntry("mining_power", SpellRegistry.getModifierFromName("arsmagica2:mining_power"), 1);
		createModifierEntry("piercing", SpellRegistry.getModifierFromName("arsmagica2:piercing"), 1);
		createModifierEntry("prosperity", SpellRegistry.getModifierFromName("arsmagica2:prosperity"), 1);
		createModifierEntry("radius", SpellRegistry.getModifierFromName("arsmagica2:radius"), 1);
		createModifierEntry("range", SpellRegistry.getModifierFromName("arsmagica2:range"), 1);
		createModifierEntry("rune_procs", SpellRegistry.getModifierFromName("arsmagica2:rune_procs"), 1);
		createModifierEntry("solar", SpellRegistry.getModifierFromName("arsmagica2:solar"), 1);
		createModifierEntry("speed", SpellRegistry.getModifierFromName("arsmagica2:speed"), 1);
		createModifierEntry("target_non_solid", SpellRegistry.getModifierFromName("arsmagica2:target_non_solid"), 1);
		createModifierEntry("velocity_added", SpellRegistry.getModifierFromName("arsmagica2:velocity_added"), 1);
	}
	
	private static void initTalents() {
		createTalentEntry("affinity_gains", SkillDefs.AFFINITY_GAINS, 1);
		createTalentEntry("augmented_casting", SkillDefs.AUGMENTED_CASTING, 1);
		createTalentEntry("extra_summon", SkillDefs.EXTRA_SUMMONS, 1);
		createTalentEntry("mage_posse_i", SkillDefs.MAGE_POSSE_1, 1);
		createTalentEntry("mage_posse_ii", SkillDefs.MAGE_POSSE_2, 1);
		createTalentEntry("mana_regen_i", SkillDefs.MANA_REGEN_1, 1);
		createTalentEntry("mana_regen_ii", SkillDefs.MANA_REGEN_2, 1);
		createTalentEntry("mana_regen_iii", SkillDefs.MANA_REGEN_3, 1);
		createTalentEntry("spell_motion", SkillDefs.SPELL_MOTION, 1);
	}
	private static void initMobs() {
		
	}
	
	private static void initStructures() {
		STRUCTURE.addEntry(new CompendiumEntry("crafting_altar")
				.addObject("compendium.crafting_altar.page1")
				.addObject("compendium.crafting_altar.page2")
				.addObject(new StackMapWrapper(CraftingAltarMaterials.getCapsMap(), "am2.gui.catalysts", false))
				.addObject(new StackMapWrapper(CraftingAltarMaterials.getSimpleMainMap(), "am2.gui.structuremat", false))
				.addObject(new TileEntityCraftingAltar().getDefinition()));
		STRUCTURE.addEntry(new CompendiumEntry("gateway")
				.addObject("compendium.gateway.page1")
				.addObject("compendium.gateway.page2")
				.addObject(new TileEntityKeystoneRecepticle().getDefinition()));
	}
	
	private static void initBosses() {
		
	}
	
	private static void createShapeEntry(String name, AbstractSpellPart shape, int textPages) {
		CompendiumEntry entry = new CompendiumEntry(name);
		for (int i = 1; i <= textPages; i++) {
			entry = entry.addObject("compendium." + name + ".page" + i);
		}
		if (shape == null)
			LogHelper.debug("Missing shape for : %s", name);
		entry.addObject(shape);
		SPELL_SHAPE.addEntry(entry);
	}
	
	private static void createTalentEntry(String name, Skill skill, int textPages) {
		CompendiumEntry entry = new CompendiumEntry(name);
		for (int i = 1; i <= textPages; i++) {
			entry = entry.addObject("compendium." + name + ".page" + i);
		}
		if (skill == null)
			LogHelper.debug("Missing skill for : %s", name);
		entry.addObject(skill);
		TALENT.addEntry(entry);
	}
	
	private static void createItemEntry(CompendiumCategory category, String name, ItemStack item, int textPages) {
		CompendiumEntry entry = new CompendiumEntry(name);
		for (int i = 1; i <= textPages; i++) {
			entry = entry.addObject("compendium." + name + ".page" + i);
		}
		if (item == null)
			LogHelper.debug("Missing item for : %s", name);
		entry.addObject(item);
		category.addEntry(entry);
	}
	
	private static void createItemEntry(String name, ItemStack item, int textPages) {
		CompendiumEntry entry = new CompendiumEntry(name);
		for (int i = 1; i <= textPages; i++) {
			entry = entry.addObject("compendium." + name + ".page" + i);
		}
		if (item == null)
			LogHelper.debug("Missing item for : %s", name);
		entry.addObject(item);
		ITEM.addEntry(entry);
	}
	
	private static void createItemEntry(String name, Item item, int textPages) {
		createItemEntry(name, new ItemStack(item), textPages);
	}
	
	private static void createComponentEntry(String name, AbstractSpellPart component, int textPages) {
		CompendiumEntry entry = new CompendiumEntry(name);
		for (int i = 1; i <= textPages; i++) {
			entry = entry.addObject("compendium." + name + ".page" + i);
		}
		if (component == null)
			LogHelper.debug("Missing component for : %s", name);
		entry.addObject(component);
		if (component instanceof IRitualInteraction)
			entry.addObject(new IRitualInteraction.Wrapper((IRitualInteraction) component));
		SPELL_COMPONENT.addEntry(entry);
	}
	
	private static void createModifierEntry(String name, AbstractSpellPart mod, int textPages) {
		CompendiumEntry entry = new CompendiumEntry(name);
		for (int i = 1; i <= textPages; i++) {
			entry = entry.addObject("compendium." + name + ".page" + i);
		}
		if (mod == null)
			LogHelper.debug("Missing modifier for : %s", name);
		entry.addObject(mod);
		SPELL_MODIFIER.addEntry(entry);
	}
	
	private static void createEntry(CompendiumCategory category, String name, int pages) {
		CompendiumEntry entry = new CompendiumEntry(name);
		for (int i = 1; i <= pages; i++) {
			entry = entry.addObject("compendium." + name + ".page" + i);
		}
		category.addEntry(entry);
	}

}
