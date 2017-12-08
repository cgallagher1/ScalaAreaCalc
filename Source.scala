import scala.io.StdIn
import scala.math._
import scala.collection.mutable.ArrayBuffer

object Source {
    def main(args: Array[String]) {
        //Basic data types 
        var answer = "y"
        var counter = 1
        var lowerbound = 0.0f
        var upperbound = 0.0f

        //Declaring an ArrayBuffer with our new class
        val terms = new ArrayBuffer[CoAndEx]()

        //Beginging while statement
        while (answer == "y"){
     
        }

        
    } //End of Main
    //Creates a new Class called CoAndEx which takes two float parameters
    class CoAndEx(var coefficient: Float, var exponent: Float){
        //Getters just return the floats
        def getCoefficient() : Float = coefficient
        def getExponent() : Float = exponent

        //Setters set the passed in floats
        def setCoefficient(coefficient : Float){
            this.coefficient = coefficient
        }

        def setExponent(exponent: Float){
            this.exponent = exponent
        }
    }


}//End of Source
