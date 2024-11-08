package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;


public class LemmingRoleFactory {
    private static final List<LemmingRole> availableRoles = Arrays.asList(
		new WalkerRole(),
        new ParachuterRole()
	);

    public static LemmingRole parse(String input){
        for (LemmingRole role: availableRoles) {
			LemmingRole parsedRole = role.parse(input);
			if (parsedRole != null) {
				return role;
			}
		}
		return null;
    }

	public static String lemmingRolesHelp() {
		StringBuilder roles = new StringBuilder();
		for (LemmingRole role: availableRoles) {
			roles.append(role.helpText());
		}
		return roles.toString();
	}
}
