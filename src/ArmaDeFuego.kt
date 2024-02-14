package src
import kotlin.random.Random

/**
 * La clase abstracta ArmaDeFuego cuenta con las propiedades:
 * @property municion -> Entero que representa la munción máxima que puede llevar el arma.
 * @property tipoDeMunicion -> Cadena que indica el tipo de calibre de las balas de arma.
 * @property nombre -> Cadena que representa el nombre del arma.
 * @property municionArestar -> Entero que indica la munición que se gasta al disparar.
 * @property danio -> Entero aleatorio que representa el daño del arma.
 * @property radio -> Representa el radio de impacto de las balas del arma.
 * @property cajaMunicionExtra -> Entero que representa el nº de recargas que hay disponibles.
 */
abstract class ArmaDeFuego (
    private var municion: Int,
    private val tipoDeMunicion: String,
    ){
    companion object{
        var cajaMunicionExtra: Int = Random.nextInt(5,15)

        fun reiniciarMunicion(){
            cajaMunicionExtra = Random.nextInt(5,15)
        }
    }

    abstract val nombre: String
    abstract val municionArestar: Int
    abstract val danio: Int
    abstract val radio: String

    /**
     * La funcion abierta disparar() se encarga de primero comprobar la munición restante dentro del cargador y actúa en funcion de esta.
     */
   open fun disparar() {
        if (municion > municionArestar) {
            municion -= municionArestar
            println("$nombre dispara, Municion restante: $municion")
        }
        else{
            if (comprobarRecarga()) {
                recargar()
                municion -= municionArestar
                println("$nombre dispara, Municion restante: $municion")
            }
            else{
                println("No quedan recargas disponibles")
            }
        }
   }

    /**
     * La función abierta comprobarRecarga() se encarga de devolver un booleano en función de si quedan recargas disponibles o no para todas las armas
     * @return Boolean
     */
    private fun comprobarRecarga():Boolean{
        return cajaMunicionExtra > 0
    }

    /**
     * La función abierta recargar() se encarga de modificar todos los valorese necesarios a la hora de recargar un arma, teniendo en cuenta la existencia de cajas de recarga
     */
   private fun recargar(){
        if (cajaMunicionExtra > 0){
            municion += municionArestar*2
            cajaMunicionExtra -= 1
            println("$nombre recargada, recargas restantes: $cajaMunicionExtra")
        }
        else{
            println("No quedan recargas disponibles")
        }
   }

    /**
     * La función abierta decidirRadio() asigna un valor al radio en función de un numero aleatorio
     * @return El valor del radio
     */
    open fun decidirRadio():String{
        val random = Random.nextInt(1,2)
        return if (random == 1){
            TipoRadio.REDUCIDO.desc
        } else{
            TipoRadio.CORTO.desc
        }
    }

    override fun toString(): String {
        return "Nombre: $nombre, Munición: $municion, Tipo de munición: $tipoDeMunicion, Daño: $danio, Radio:$radio"
    }
}