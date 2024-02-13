package src
import kotlin.random.Random
import kotlin.random.nextInt
abstract class ArmaDeFuego (
    private var municion: Int,

    private val tipoDeMunicion: String,
    ){
    companion object{
        var cajaMunicionExtra: Int = Random.nextInt(5,15)
    }
    abstract val nombre: String
    abstract val municionArestar: Int
    abstract val danio: Int
    abstract val radio: TipoRadio

    private val max: Int = municion
   open fun disparar() {
        if (municion > municionArestar) {
            municion -= municionArestar
            println("$nombre dispara, Municion restante: $municion")
        }
        else{
            if (comprobarRecarga()) {
                recargar()
                println("$nombre dispara, Municion restante: $municion")
            }
            else{
                println("No quedan recargas disponibles")
            }
        }
   }
    open fun comprobarRecarga():Boolean{
        if (cajaMunicionExtra > 0) {
            return true
        } else {
            return false
        }
    }
   open fun recargar(){
        if (cajaMunicionExtra > 0){
            municion += municionArestar*2
            cajaMunicionExtra -= 1
            println("$nombre recargada, recargas restantes: $cajaMunicionExtra")
        }
        else{
            println("No quedan recargas disponibles")
        }
   }
    open fun decidirRadio():TipoRadio{
        val random = Random.nextInt(1,2)
        if (random == 1){
            return TipoRadio.REDUCIDO
        }
        else{
            return TipoRadio.CORTO
        }
    }
    fun mostrarRecargas(){
        println("Recargas restantes para todas las armas: $cajaMunicionExtra")
    }

    override fun toString(): String {
        return "Nombre: $nombre, Munición: $municion, Tipo de munición: $tipoDeMunicion, Daño: $danio, Radio:$radio"
    }
}