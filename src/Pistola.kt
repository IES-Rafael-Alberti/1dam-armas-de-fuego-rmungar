package src
import kotlin.random.Random
/**
 * La clase Pistola hereda de la clase abstracta ArmaDeFuego y cuenta con sus propiedades propias:
 * @property municion -> Entero que representa la munción máxima que puede llevar el arma.
 * @property tipoDeMunicion -> Cadena que indica el tipo de calibre de las balas de arma.
 * Y las propiedades heredadas de ArmaDeFuego:
 * @property nombre -> Cadena que representa el nombre del arma. (PISTOLA)
 * @property municionArestar -> Entero que indica la munición que se gasta al disparar. (1)
 * @property danio -> Entero aleatorio que representa el daño del arma.
 * @property radio -> Representa el radio de impacto de las balas del arma.
 */
class Pistola(municion: Int, tipoDeMunicion: String): ArmaDeFuego(municion, tipoDeMunicion) {
    override val nombre:String = "Pistola"
    override val danio: Int = Random.nextInt(1,5)
    override val municionArestar: Int = 1
    override val radio: String = decidirRadio()
    init {
        require(danio in 1..5) {"El daño debe estar entre 1 y 5"}
    }
}