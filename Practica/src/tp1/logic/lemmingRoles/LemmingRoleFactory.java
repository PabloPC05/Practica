package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;


public class LemmingRoleFactory {

	// Lista de roles disponibles
    private static final List<LemmingRole> availableRoles = Arrays.asList(
    	new DownCaverRole(),
        new ParachuterRole(), 
		new WalkerRole()
	);

	// Funcion para parsear el rol y saber si es correcto
    public static LemmingRole parse(String input){
        for (LemmingRole role: availableRoles) {
			LemmingRole parsedRole = role.parse(input);
			// Si el rol es correcto, se devuelve
			if (parsedRole != null) {
				return role;
			}
		}
		// Si no es correcto, se devuelve null
		return null;
    }

	// Funcion para obtener la ayuda de los roles
	public static String lemmingRolesHelp() {
		StringBuilder roles = new StringBuilder();
		// Se obtiene la ayuda de cada rol
		for (LemmingRole role: availableRoles) {
			roles.append(role.helpText());
		}
		// Se devuelve la ayuda
		return roles.toString();
	}
}
