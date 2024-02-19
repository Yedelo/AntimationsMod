package at.yedel.antimations;



import static at.yedel.antimations.Antimations.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



public class AntimationsCheck {
    // This class is for the Antimations CT module to check if this mod is active. This would return JavaClass instead of JavaPackage
    // Module makes this boolean true if it loads
    public static boolean module = false;
    public static boolean alreadyWarned = false;

    private final ChatStyle uninstallAntimations = new ChatStyle().setChatClickEvent(
            new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ct delete Antimations")
    );
    private final ChatComponentText warnMessage = (ChatComponentText) new ChatComponentText(
            logo +
            " §cAntimations module detected, it's likely that it will completely break this mod. If you are not seeing a similar message from the module, ignore this message. "
    ).appendSibling(new ChatComponentText("§c§n§lUninstall Antimations module").setChatStyle(uninstallAntimations));

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        ScheduledExecutorService wait;
        if (module && !alreadyWarned) {
            if (config.get(Configuration.CATEGORY_GENERAL, "debug", false).getBoolean()) return;
            wait = Executors.newScheduledThreadPool(1);
            wait.schedule(() -> {
                mc.thePlayer.addChatMessage(warnMessage);
                alreadyWarned = true;
            }, 2, TimeUnit.SECONDS);
        }

        if (firstTime) {
            wait = Executors.newScheduledThreadPool(1);
            wait.schedule(() -> {
                mc.thePlayer.addChatMessage(new ChatComponentText(logo + " §dWelcome to AntimationsMod! Use /antimations for configuration."));
                mc.thePlayer.addChatMessage(new ChatComponentText("§dIf you have any old animations mods, it's recommended that you disable \"Punching During Usage\" or similar features."));
                config.get(Configuration.CATEGORY_GENERAL, "firstTime", "true").set(false);
            }, 2, TimeUnit.SECONDS);
        }
    }
}
