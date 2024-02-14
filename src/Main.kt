package src

fun main() {
    try {
        val listaArmas = mutableListOf<ArmaDeFuego>()
        val listaArmas2= mutableListOf<ArmaDeFuego>()

        val pistola1 = Pistola( 6, "9mm")
        listaArmas.add(pistola1)
        listaArmas2.add(pistola1)

        val rifle1 = Rifle(8, "7.62mm")
        listaArmas.add(rifle1)
        listaArmas2.add(rifle1)

        val bazooka1 = Bazooka(3, "RPG")
        listaArmas.add(bazooka1)
        listaArmas2.add(bazooka1)

        val casa1 = Casa(2, "Confetti")
        listaArmas2.add(casa1)

        val coche1 =Coche(10, "Ráfagas de luz larga")
        listaArmas2.add(coche1)

        val bocadillo1 = Bocadillo(9, "Olor a jamón")
        listaArmas2.add(bocadillo1)

        val disparos = (1..12).map { listaArmas.random() to (1..3).random() }

        val disparos2 = (1..9).map { listaArmas2.random() to (1..3).random() }

        var cont = 1
        println("Munición Extra = ${ArmaDeFuego.cajaMunicionExtra} ... para todas las armas de fuego.")
        println()
        for (disparo in disparos) {
            println("*** Disparo: $cont")
            for (i in 1..disparo.second) {
                disparo.first.disparar()
                println(disparo.first.toString())
            }
            cont++
        }
        for (i in 1..10){
            if (i == 5) println("---------------SEGUNDO SET DE DISPAROS---------------")
            else println()
        }
        cont = 1
        ArmaDeFuego.reiniciarMunicion()
        for (disparo in disparos2) {
            println("*** Disparo: $cont")
            for (i in 1..disparo.second) {
                disparo.first.disparar()
                println(disparo.first.toString())
            }
            cont++
        }
    }
    catch (e:Exception){
        println(e.message)
    }
}