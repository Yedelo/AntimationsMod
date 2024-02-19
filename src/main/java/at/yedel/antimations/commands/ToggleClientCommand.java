package at.yedel.antimations.commands;



import static at.yedel.antimations.Antimations.*;
import static at.yedel.antimations.Antimations.cancelClientAnimations;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;



public class ToggleClientCommand extends CommandBase {
    private final ChatComponentText enabledClient = new ChatComponentText(logo + " §dEnabled cancelling of your animations!");
    private final ChatComponentText disabledClient = new ChatComponentText(logo + " §dDisabled cancelling of your animations!");

    @Override
    public String getCommandName() {
        return "toggleclientantimations";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        cancelClientAnimations = !cancelClientAnimations;
        mc.thePlayer.addChatMessage(cancelClientAnimations ? enabledClient : disabledClient);
        config.get(Configuration.CATEGORY_GENERAL, "cancelClientAnimations", true).set(cancelClientAnimations);
        config.save();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
