package $package$
import com.rmet.$base$.$base;format="Camel"$.{given, *}

object $name;format="Camel"$ {
  opaque type $name;format="Camel"$Type = Object
  given $name;format="Camel"$Type = Object()
  def validate$name;format="Camel"$Imports(using $name;format="Camel"$Type) = ()

}

@main def _unsafe$name;format="Camel"$Main: Unit =
  throw RuntimeException(s"$name;format="Camel"$ \${Source.filePath} CANNOT BE RUN.")