package com.balajisivaraman.bc

object Types {
  sealed trait Expr
  case class ENum(num: Double) extends Expr
  case class EAdd(num1: ENum, num2: ENum) extends Expr
  case class ESub(num1: ENum, num2: ENum) extends Expr
  case class EMul(num1: ENum, num2: ENum) extends Expr
  case class EDiv(num1: ENum, num2: ENum) extends Expr
}
