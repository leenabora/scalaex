
//Algebraic Data Type
object ADT extends App {
  val exp = Add(Number(10), Subtract(Number(20), Add(Number(5), Number(1))))

  println(exp.evaluate())

  println(depthOfAddition(exp))

  def depthOfAddition(exp: Expression): Int = {
    exp match {
      case n: Number => 0
      case Add(ex1, ex2) => 1 + depthOfAddition(ex1) + depthOfAddition(ex2)
      case Subtract(ex1, ex2) => depthOfAddition(ex1) + depthOfAddition(ex2)
    }
  }
}

trait Expression {
  def evaluate(): Int
}

case class Number(n: Int) extends Expression {
  override def evaluate(): Int = n
}

case class Add(arg1: Expression, arg2: Expression) extends Expression {
  override def evaluate(): Int = arg1.evaluate() + arg2.evaluate()
}

case class Subtract(arg1: Expression, arg2: Expression) extends Expression {
  override def evaluate(): Int = arg1.evaluate() - arg2.evaluate()
}


