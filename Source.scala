import scala.io.StdIn._
import scala.math._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.BufferLike

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
            //Getting user input
            print("Please enter the coefficient for term " + counter.toString + ": ")
            var coefficient = readLine.toFloat
            print("Please enter the exponent for term " + counter.toString + ": ")
            var exponent = readLine.toFloat

            //Create an instance of CoAndEx and add it to our ArrayBuffer
            var temp = new CoAndEx(coefficient, exponent)
            terms.append(temp)

            counter = counter + 1
            
            print("Do you have more terms to enter (y or n): ")
            answer = readLine
        }

        println(" ")

        print("Please enter the lower bound: ")
        var lowerbound = readLine.toFloat

        println("Please enter the upper bound: ")
        var upperbound = readLine.toFloat
        
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

    def functionCreator(terms: ArrayBuffer[CoAndEx]) : String = {
        var retval = "f(x) = "
        for( i <- 0 until (terms.size()-1)){
            if(terms(i).coefficient == 0){
                retval = retval + "0 + "
            }
        }
    }

}//End of Source
