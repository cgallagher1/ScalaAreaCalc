object Source {
    def main(args: Array[String]) {
        printf("hello world")
    }
    Class CoAndEx(var coefficient: Int, var exponential: Int){
        def getCoefficient(): Int = coefficient
        def getExponential(): Int = exponential

        def setCoefficient(co: Int){
            this.coefficient = co
        }

        def setExponential(ex: Int){
            this.exponential = ex
        }

        def this(co: Int, ex: Int)
        {
            this.setCoefficient(co)
            this.setExponential(ex)
        }
    }
}