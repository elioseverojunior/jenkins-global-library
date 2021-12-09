import br.eti.elio.build.MsBuild
import br.eti.elio.ioc.ContextRegistry

/**
 * Example custom step for easy use of MsBuild inside Jenkinsfiles
 * @param solutionPath Path to .sln file
 * @return
 */
def call(String solutionPath) {
  ContextRegistry.registerDefaultContext(this)
  
  def msBuilder = new MsBuild(solutionPath)
  msBuilder.build()
}