package techreborn.config;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import cpw.mods.fml.client.config.GuiConfigEntries.CategoryEntry;

public class TechRebornConfigGui extends GuiConfig{
	public TechRebornConfigGui(GuiScreen top)
	{
		super(top, getConfigCategories(), "TechReborn", false, false,
				GuiConfig.getAbridgedConfigPath(ConfigTechReborn.config
						.toString()));
	}
	
	private static List<IConfigElement> getConfigCategories()
	{
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new DummyConfigElement.DummyCategoryElement("General",
				"tr.configgui.category.trGeneral", TRGeneral.class));
		list.add(new DummyConfigElement.DummyCategoryElement("World Gen",
				"tr.configgui.category.trWorld", TRWORLD.class));
	
		return list;
	}
	
	public static class TRGeneral extends CategoryEntry {

		public TRGeneral(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement)
		{
			super(owningScreen, owningEntryList, configElement);
		}
		
		@Override
		protected GuiScreen buildChildScreen()
		{
			return new GuiConfig(this.owningScreen,
					(new ConfigElement(ConfigTechReborn.config
							.getCategory(Configuration.CATEGORY_GENERAL)))
							.getChildElements(), this.owningScreen.modID,
					Configuration.CATEGORY_GENERAL,
					this.configElement.requiresWorldRestart()|| this.owningScreen.allRequireWorldRestart,
					this.configElement.requiresMcRestart()|| this.owningScreen.allRequireMcRestart,
					GuiConfig.getAbridgedConfigPath(ConfigTechReborn.config.toString()));
		}
	}
	
	// World
	public static class TRWORLD extends CategoryEntry {
		public TRWORLD(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement)
		{
			super(owningScreen, owningEntryList, configElement);
		}
		
		@Override
		protected GuiScreen buildChildScreen()
		{
			return new GuiConfig(this.owningScreen,
					(new ConfigElement(ConfigTechReborn.config
							.getCategory(ConfigTechReborn.CATEGORY_WORLD)))
							.getChildElements(), this.owningScreen.modID,
					Configuration.CATEGORY_GENERAL,
					this.configElement.requiresWorldRestart()
							|| this.owningScreen.allRequireWorldRestart,
					this.configElement.requiresMcRestart()
							|| this.owningScreen.allRequireMcRestart,
					GuiConfig.getAbridgedConfigPath(ConfigTechReborn.config
							.toString()));
		}
	}
}