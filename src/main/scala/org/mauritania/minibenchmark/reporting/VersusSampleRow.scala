package org.mauritania.minibenchmark.reporting

case class VersusSampleRow(
  durationA: Long,
  durationB: Long
) {
  override def toString(): String = {
    this.productIterator.mkString(",")
  }
}

