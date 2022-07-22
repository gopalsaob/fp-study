package exercises.shapeless.tlevel

sealed trait BoolVal {
  def not: BoolVal
  def or(that: BoolVal): BoolVal
}

case object TrueVal extends BoolVal {
  override def not: BoolVal = FalseVal
  override def or(that: BoolVal): BoolVal = TrueVal
}

case object FalseVal extends BoolVal {
  override def not: BoolVal = TrueVal
  override def or(that: BoolVal): BoolVal = that
}


