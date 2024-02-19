package at.yedel.antimations.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;

import static at.yedel.antimations.Antimations.*;

public class DisableWarnCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "debugdisablewarnmessagesantimations";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        config.get(Configuration.CATEGORY_GENERAL, "debug", false).set(true);
        config.save();
        mc.thePlayer.addChatMessage(new ChatComponentText(logo + "§dDisabled warn messages (not recommended)"));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
