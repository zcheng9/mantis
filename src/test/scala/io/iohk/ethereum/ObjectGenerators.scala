package io.iohk.ethereum

import java.math.BigInteger
import org.scalacheck.{Arbitrary, Gen}

trait ObjectGenerators {

  lazy val intGen = Gen.choose(Int.MinValue, Int.MaxValue)

  lazy val bigIntGen = byteArrayOfNItemsGen(32).map(b=>new BigInteger(1, b))

  lazy val anyArrayGen = Gen.nonEmptyListOf(Arbitrary.arbitrary[Byte]).map(_.toArray)

  def byteArrayOfNItemsGen(n: Int) = Gen.listOfN(n, Arbitrary.arbitrary[Byte]).map(_.toArray)

}