package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

import tp1.control.commands.Command;
import tp1.control.commands.ExitCommand;
import tp1.control.commands.HelpCommand;
import tp1.control.commands.ResetCommand;
import tp1.control.commands.UpdateCommand;

public class LemmingRoleFactory {
    private static final List<LemmingRole> availableRoles = Arrays.asList(
		new WalkerRole(),
        new ParachuterRole()
	);
    public static LemmingRole parse(String input){
        for (LemmingRole rol: availableRoles) {
			LemmingRole role = role.parse(input);
			if (role != null) {
				return role;
			}
		}
		return null;
    }
}
