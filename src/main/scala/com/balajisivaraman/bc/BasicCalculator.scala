package com.balajisivaraman.bc

import com.balajisivaraman.bc.Parsers._
import com.balajisivaraman.bc.Evaluator._
import fastparse.core.Parsed.Success
import fastparse.core.Parsed.Failure

object BasicCalculator extends App {
  val parsed = expr.parse("20.8 / 2")
  val result = parsed match {
      case Success(expr, _) => println(expr); eval(expr)
      case f: Failure          => throw new RuntimeException
    }
  println(result)
}
