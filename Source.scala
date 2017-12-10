import scala.io.StdIn._
import scala.math._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.BufferLike

object Source {
    def main(args: Array[String]) {
        //Basic data types 
        var answer = "y"
        var counter = 1

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

        print("Please enter the upper bound: ")
        var upperbound = readLine.toFloat

        println(" ")

        println("The area underneath the curve " + functionCreator(terms) + " from " + lowerbound.toString + " to " + upperbound.toString + " is about ")
        
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
        for( i <- 0 until (terms.size - 1)){
            if(terms(i).coefficient == 0){
                //0 * anything = 0
                retval = retval + "0 + "
            } else if(terms(i).coefficient == 1 && terms(i).exponent == 1){
                // 1 * x^1 = x
                retval = retval + "x + "
            } else if(terms(i).coefficient == -1 && terms(i).exponent == 1){
                //If the coefficient is -1 but exponent is still 1
                retval = retval + "-x + "
            } else if (terms(i).coefficient == 1){
                //If coefficient is 1
                retval = retval + "x^" + terms(i).exponent.toString +  " + "
            } else if (terms(i).coefficient == -1){
                //If coefficient is -1
                retval = retval + "-x^" + terms(i).exponent.toString +  " + "
            } else if (terms(i).exponent == 1){
                //x^1 = x
                retval = retval + terms(i).coefficient.toString + "x + "
            } else if (terms(i).exponent == 0){
                //x^0 = 1
                retval = retval + terms(i).coefficient.toString + " + "
            } else {
                retval = retval + terms(i).coefficient.toString + "x^" + terms(i).exponent.toString + " + "
            }
        }

        if(terms(terms.size -1).coefficient == 0){
            //0 * anything = 0
            retval = retval + "0"
        } else if(terms(terms.size -1).coefficient == 1 && terms(terms.size -1).exponent == 1){
            // 1 * x^1 = x
            retval = retval + "x"
        } else if(terms(terms.size -1).coefficient == -1 && terms(terms.size -1).exponent == 1){
            //If the coefficient is -1 but exponent is still 1
            retval = retval + "-x"
        } else if (terms(terms.size -1).coefficient == 1){
            //If coefficient is 1
            retval = retval + "x^" + terms(terms.size -1).exponent.toString
        } else if (terms(terms.size -1).coefficient == -1){
            //If coefficient is -1
            retval = retval + "-x^" + terms(terms.size -1).exponent.toString
        } else if (terms(terms.size -1).exponent == 1){
            //x^1 = x
            retval = retval + terms(terms.size -1).coefficient.toString
        } else if (terms(terms.size -1).exponent == 0){
            //x^0 = 1
            retval = retval + terms(terms.size -1).coefficient.toString
        } else {
            retval = retval + terms(terms.size -1).coefficient.toString + "x^" + terms(terms.size -1).exponent.toString
        }
        return retval
    }

    //Find the height based on the passed in width
    def findHeight(terms: ArrayBuffer[CoAndEx], x: Float) : Float = {
        var retval = 0.0f
        
        //Finds the height
        for(i <- 0 until terms.size){
            retval += (terms(i).coefficient) * scala.math.pow(x, terms(i).exponent)
        }

        //The negative case
        if(retval < 0){
            retval = retval * -1
        }

        return retval
    }



}//End of Source
