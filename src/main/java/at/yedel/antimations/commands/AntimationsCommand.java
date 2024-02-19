package at.yedel.antimations.commands;



import static at.yedel.antimations.Antimations.version;
import static at.yedel.antimations.Antimations.cancelClientAnimations;
import static at.yedel.antimations.Antimations.cancelServerAnimations;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;

import static at.yedel.antimations.Antimations.mc;



public class AntimationsCommand extends CommandBase {
    private final ChatComponentText antimations = new ChatComponentText("§5§l< AntimationsMod " + version + " >");

    private final ChatComponentText disableCancelClientAnimations =
            (ChatComponentText) new ChatComponentText("§d- Cancel your animations: Currently §aenabled - ").appendSibling(
                    (new ChatComponentText("§c§n§lDISABLE"))
                    .setChatStyle(
                            new ChatStyle().setChatClickEvent
                                    (
                                            new ClickEvent(
                                                    ClickEvent.Action.RUN_COMMAND, "/toggleclientantimations"
                                            )
                                    )
                     )
    );
    private final ChatComponentText enableCancelClientAnimations =
            (ChatComponentText) new ChatComponentText("§d- Cancel your animations: Currently §cdisabled - ").appendSibling(
                    (new ChatComponentText("§a§n§lENABLE"))
                    .setChatStyle(
                            new ChatStyle().setChatClickEvent
                                    (
                                            new ClickEvent(
                                                    ClickEvent.Action.RUN_COMMAND, "/toggleclientantimations"
                                            )
                                    )
                    )
    );
    private final ChatComponentText disableCancelServerAnimations =
            (ChatComponentText) new ChatComponentText("§d- Cancel other players' animations: Currently §aenabled - ").appendSibling(
                    (new ChatComponentText("§c§n§lDISABLE"))
                    .setChatStyle(
                            new ChatStyle().setChatClickEvent
                                    (
                                            new ClickEvent(
                                                    ClickEvent.Action.RUN_COMMAND, "/toggleserverantimations"
                                            )
                                    )
                    )
    );
    private final ChatComponentText enableCancelServerAnimations =
            (ChatComponentText) new ChatComponentText("§d- Cancel other players' animations: Currently §cdisabled - ").appendSibling(
                    (new ChatComponentText("§a§n§lENABLE"))
                    .setChatStyle(
                            new ChatStyle().setChatClickEvent
                                    (
                                            new ClickEvent(
                                                    ClickEvent.Action.RUN_COMMAND, "/toggleserverantimations"
                                            )
                                    )
                    )
    );

    @Override
    public String getCommandName() {
        return "antimations";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        ChatComponentText clientMessage = cancelClientAnimations ? disableCancelClientAnimations : enableCancelClientAnimations;
        ChatComponentText serverMessage = cancelServerAnimations ? disableCancelServerAnimations : enableCancelServerAnimations;
        mc.thePlayer.addChatMessage(antimations);
        mc.thePlayer.addChatMessage(clientMessage);
        mc.thePlayer.addChatMessage(serverMessage);
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
