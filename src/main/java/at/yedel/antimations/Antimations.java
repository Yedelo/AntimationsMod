package at.yedel.antimations;



import at.yedel.antimations.commands.AntimationsCommand;
import at.yedel.antimations.commands.DisableWarnCommand;
import at.yedel.antimations.commands.ToggleClientCommand;
import at.yedel.antimations.commands.ToggleServerCommand;

import java.io.File;

import net.minecraft.client.Minecraft;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(
        name = "AntimationsMod",
        modid = "antimations",
        version = Antimations.version,
        clientSideOnly = true
)
public class Antimations {
    public static final String version = "1.0.0";
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static final String logo = "§5§l< AntimationsMod >";

    public static Configuration config;
    public static boolean firstTime;
    public static boolean cancelClientAnimations; // Local config-separate values
    public static boolean cancelServerAnimations;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(new File(event.getModConfigurationDirectory().getPath(), "antimations.cfg"));
        config.load();
        firstTime = config.get(Configuration.CATEGORY_GENERAL, "firstTime", true).getBoolean();
        cancelClientAnimations = config.get(Configuration.CATEGORY_GENERAL, "cancelClientAnimations", true).getBoolean();
        cancelServerAnimations = config.get(Configuration.CATEGORY_GENERAL, "cancelServerAnimations", false).getBoolean();
        if (config.hasChanged()) config.save();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new AntimationsCheck());
        ClientCommandHandler.instance.registerCommand(new AntimationsCommand());
        ClientCommandHandler.instance.registerCommand(new ToggleClientCommand());
        ClientCommandHandler.instance.registerCommand(new ToggleServerCommand());
        ClientCommandHandler.instance.registerCommand(new DisableWarnCommand());
    }
}
