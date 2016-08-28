package com.balajisivaraman.bc

import fastparse.WhitespaceApi
import fastparse.noApi._
import com.balajisivaraman.bc.Types._

object Parsers {
  private val whitespace =
    WhitespaceApi.Wrapper {
      import fastparse.all._
      NoTrace(" ".rep)
    }

  import whitespace._
  private val num = P( CharIn('0' to '9').rep.! )
  private val double = P( num ~ ("." ~ num).? ).map(s => s._2.map(s._1 + "." + _).getOrElse(s._1))

  private val eNum = P( double ).map(d => ENum(d.toDouble))
  private val eAdd = P(eNum ~ "+" ~ eNum).map(a => EAdd(a._1, a._2))
  private val eSub = P(eNum ~ "-" ~ eNum).map(a => ESub(a._1, a._2))
  private val eMul = P(eNum ~ "*" ~ eNum).map(a => EMul(a._1, a._2))
  private val eDiv = P(eNum ~ "/" ~ eNum).map(a => EDiv(a._1, a._2))
  val expr: Parser[Expr] = P ( (eAdd | eSub | eMul | eDiv) ~ End)
}
