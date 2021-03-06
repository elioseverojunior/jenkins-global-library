package br.eti.elio

import br.eti.elio.build.MsBuild
import br.eti.elio.ioc.ContextRegistry
import br.eti.elio.ioc.IContext
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*

/**
 * Example test class
 */
class MsBuildTest {
  private IContext _context;
  private IStepExecutor _steps;
  
  @Before
  void setup() {
    _context = mock(IContext.class);
    _steps = mock(IStepExecutor.class);
    
    when(_context.getStepExecutor()).thenReturn(_steps);
  
    ContextRegistry.registerContext(_context);
  }
  
  @Test
  void build_callsShStep() {
    // prepare
    String solutionPath = "some/path/to.sln";
    MsBuild builder = new MsBuild(solutionPath);
    
    // execute
    builder.build();
    
    // verify
    verify(_steps).sh(anyString());
  }
  
  @Test
  void build_shStepReturnsStatusNotEqualsZero_callsErrorStep() {
    // prepare
    String solutionPath = "some/path/to.sln";
    MsBuild builder = new MsBuild(solutionPath);
    
    when(_steps.sh(anyString())).thenReturn(-1);
    
    // execute
    builder.build();
    
    // verify
    verify(_steps).error(anyString());
  }
}
