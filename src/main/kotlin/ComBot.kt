class ComBot(name: String): Player(name) {

    override fun chooseGame() : String{
        val str = when ((1..3).random()){
            1 -> "1"
            2 -> "2"
            else -> "3"
        }
        println("Turn COM")
        println(str)
        return str
    }




}