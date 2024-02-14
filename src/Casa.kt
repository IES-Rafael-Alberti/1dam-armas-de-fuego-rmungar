package src

import kotlin.random.Random
/**
 * La clase Casa hereda de la clase abstracta ArmaDeFuego y cuenta con sus propiedades propias:
 * @property municion -> Entero que representa la munción máxima que puede llevar el arma.
 * @property tipoDeMunicion -> Cadena que indica el tipo de calibre de las balas de arma.
 * Y las propiedades heredadas de ArmaDeFuego:
 * @property nombre -> Cadena que representa el nombre del arma. (CASA)
 * @property municionArestar -> Entero que indica la munición que se gasta al disparar. (1)
 * @property danio -> Entero aleatorio que representa el daño del arma.
 * @property radio -> Representa el radio de impacto de las balas del arma.
 */
class Casa(municion:Int, tipoDeMunicion:String): ArmaDeFuego(municion, tipoDeMunicion){

    override val nombre:String = "Casa"
    override val danio: Int = Random.nextInt(0,1)
    override val municionArestar: Int = 1
    override val radio: String = decidirRadio()
    init {
        require(danio in 0..1) {"El daño debe estar entre 0 y 1"}
    }
}