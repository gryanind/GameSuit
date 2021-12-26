open class Player(private var name: String = "Player 1"){

    fun win(){
        println("WIn !!! ${name}")
    }
    open fun chooseGame(): String {
        while (true){
            println("Turn ${name}")
            println("1. Gunting")
            println("2. Batu")
            println("3. Kertas")
            println("Choose (1/2/3)")

            val input = readLine().toString()
            if (input.equals("1", true) ||
                input.equals("2", true) ||
                input.equals("3", true)){
                return input
            }
            println("Invalid Input, Try Again")
        }


    }

}