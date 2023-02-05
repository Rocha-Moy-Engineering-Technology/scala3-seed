import org.scalatest.funsuite.AnyFunSuite
import $package$.*

class MainTest extends AnyFunSuite {
  test("Automated MainTest") {
    assert(msg == "Hello World!")
  }
}
