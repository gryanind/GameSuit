import kotlin.system.exitProcess

class App {
    private lateinit var p2 : Player
    private lateinit var p1 : Player
    private var draw = 0

    fun run(){
        printHeader()
        inputMenuHeader()

    }

    private fun printHeader(){
        println("===========================")
        println("GAME SUIT TERMINAL VERSION")
        println("===========================")
        println("1. P1 vs P2")
        println("2. P1 vs Com")
        println("3. EXIT")
        println("===========================")
        println("     Choose 1 / 2 / 3      ")
        println("===========================")

    }

    private fun inputMenuHeader(){
        readLine()?.let {
            openMenu(it)
        }
    }

    private fun processResult(){
        val p1T = p1.chooseGame()
        val p2T = p2.chooseGame()

        when (p1T){
            "1" -> {
                println("Player 1: Gunting")
            }
            "2" -> {
                println("Player 1: Batu")
            }
            "3" -> {
                println("Player 1: Kertas")
            }
        }
        when (p2T){
            "1" -> {
                println("Player 2: Gunting")
            }
            "2" -> {
                println("Player 2: Batu")
            }
            "3" -> {
                println("Player 2: Kertas")
            }
        }
        when{
            (p1T == "1" && p2T == "2") -> p2.win()
            (p1T == "1" && p2T == "3") -> p1.win()
            (p1T == "2" && p2T == "1") -> p1.win()
            (p1T == "2" && p2T == "3") -> p2.win()
            (p1T == "3" && p2T == "1") -> p2.win()
            (p1T == "3" && p2T == "2") -> p2.win()
            else -> {
                println("DRAW!!!")
                draw++
            }
        }
    }

    private fun openMenu(menu: String) {
        when (menu){
            "1" -> {
                openMenu1()
            }
            "2" -> {
                openMenu2()
            }
            "3" -> {
                exitProcess(0)
            }
            else -> {
                println("No matches")
                run()
            }
        }


    }
    private fun playAgain() {
        println("Play Again? (Y/N)")
        when (readLine()?.uppercase()){
            "Y" -> {
                run()
            }
            "N" -> {
                println("Game Over")
                exitProcess(0)
            }
            else -> {
                println("No menu matches!")
            }
        }
    }

    private fun openMenu2() {
        p1 = Player()
        p2 = ComBot("COM")
        processResult()
        playAgain()
    }
    private fun openMenu1() {
        p1 = Player()
        p2 = Player("Player 2")
        processResult()
        playAgain()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}