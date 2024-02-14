package src

import kotlin.random.Random
/**
 * La clase Coche hereda de la clase abstracta ArmaDeFuego y cuenta con sus propiedades propias:
 * @property municion -> Entero que representa la munción máxima que puede llevar el arma.
 * @property tipoDeMunicion -> Cadena que indica el tipo de calibre de las balas de arma.
 * Y las propiedades heredadas de ArmaDeFuego:
 * @property nombre -> Cadena que representa el nombre del arma. (Coche)
 * @property municionArestar -> Entero que indica la munición que se gasta al disparar. (10)
 * @property danio -> Entero aleatorio que representa el daño del arma.
 * @property radio -> Representa el radio de impacto de las balas del arma.
 */
class Coche(municion: Int, tipoDeMunicion: String) : ArmaDeFuego(municion, tipoDeMunicion){

    override val nombre: String = "Coche"
    override val danio: Int = Random.nextInt(1000,9999)
    override val municionArestar: Int = 10
    override val radio: String = decidirRadio()
    init {
        require(danio in 1000..9999) {"El daño debe estar entre 10 y 30"}
    }

    /**
     * La funcion decidirRadio() ha sido modificada para que el radio se ajuste al arma
     * @return El valor del radio
     */
    override fun decidirRadio():String{
        val random = Random.nextInt(1,2)
        return if (random == 1){
            TipoRadio.AMPLIO.desc
        } else{
            TipoRadio.ENORME.desc
        }
    }
}