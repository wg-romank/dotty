package dotty.tools.scaladoc.mdoc

import org.junit.Test
import org.junit.Assert._

class BasicMdocTest:
  @Test
  def testSectionInput() = {
      val input = Input(
        "test",
        "1+1"
      )
      val sectionInput = SectionInput(input, Modifier.Default())
      val instrumenter = Instrumenter.instrument(input, List(sectionInput))
      val built = MarkdownBuilder.buildDocument(MarkdownBuilder.default(), List(sectionInput), instrumenter, "test")
      val rendered = Renderer.render(
        input,
        List(input),
        MarkdownBuilder.default(),
        "test",
        ReplVariablePrinter
      )
      // println(sectionInput.text)
      // println(instrumenter.source)
      println(rendered)

  }