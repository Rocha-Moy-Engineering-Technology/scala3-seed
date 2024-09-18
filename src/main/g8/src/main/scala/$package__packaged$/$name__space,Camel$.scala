package $package$
import com.rmet.$base$.$base;format="space,Camel"$.{given, *}

object $name;format="space,Camel"$ {
  opaque type $name;format="space,Camel"$Type = Object
  given $name;format="space,Camel"$Type = Object()
  def validate$name;format="space,Camel"$Imports(using $name;format="space,Camel"$Type) = ()

}

@main def _unsafe$name;format="space,Camel"$Main: Unit =
  throw RuntimeException(s"$name;format="space,Camel"$ \${Source().filePath} CANNOT BE RUN.")