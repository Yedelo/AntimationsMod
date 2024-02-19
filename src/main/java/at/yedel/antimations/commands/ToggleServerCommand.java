package at.yedel.antimations.commands;



import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;

import static at.yedel.antimations.Antimations.*;



public class ToggleServerCommand extends CommandBase {
    private final ChatComponentText enabledServer = new ChatComponentText(logo + " §dEnabled cancelling of other players' animations!");
    private final ChatComponentText disabledServer = new ChatComponentText(logo + " §dDisabled cancelling of other players' animations!");

    @Override
    public String getCommandName() {
        return "toggleserverantimations";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        cancelServerAnimations = !cancelServerAnimations;
        mc.thePlayer.addChatMessage(cancelServerAnimations ? enabledServer : disabledServer);
        config.get(Configuration.CATEGORY_GENERAL, "cancelServerAnimations", true).set(cancelServerAnimations);
        config.save();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
