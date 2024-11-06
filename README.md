# Practica

Desarrollos en Java de la practica de TP de Diego y Pablo

-Revisar los comandos (reset en particular)✔️

-Actualizar los comandos con el de escoger el role 

-Poner el rol paracuhute

-Funciones sobre la posicion de las cosas ✔️ (posiblemente hagamos alguna mas)

-Implementacion de gameobjectcontainer privada

-Interfaces ameiem ✔️

-double-dispatch

-Poder saber si un lemming esta en la puerta✔️

He tocado los comandos, el initLevel


DUDAS PARA AMBAR: la funcion de commandHelp de CommandGenerator y su relacion con la constante de AvailableCommands, la implementacion de las interacciones entre objetos, esta duda: 
    //Aqui estaba puesto static en lugar de abstract pero hemos tenido 
    //que cambiarlo para hacerlo similar a CommandGenerator, esta bien?
    abstract public LemmingRole parse(String input); en la clase LemmingRole

Cómo de similar tienen que ser las implementaciones de lemmingRoleFactory y CommandGenerator y si está bien hecho como está ahora, como ponerle un rol a un lemming si la funcion setRole se implementa en gameObject sin hacer la "chapuza" de cambiarla segun que clase hija la está usando