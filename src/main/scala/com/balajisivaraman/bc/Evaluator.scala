package com.balajisivaraman.bc

import com.balajisivaraman.bc.Types._

object Evaluator {

  def eval(expr: Expr): Double = expr match {
      case ENum(num)          => num
      case EAdd(enum1, enum2) => eval(enum1) + eval(enum2)
      case ESub(enum1, enum2) => eval(enum1) - eval(enum2)
      case EMul(enum1, enum2) => eval(enum1) * eval(enum2)
      case EDiv(enum1, enum2) => eval(enum1) / eval(enum2)
    }

}
