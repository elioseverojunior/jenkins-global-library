package br.eti.elio.ioc

import br.eti.elio.IStepExecutor
import br.eti.elio.StepExecutor

class DefaultContext implements IContext, Serializable {
  private _steps
  
  DefaultContext(steps) {
    this._steps = steps
  }
  
  @Override
  IStepExecutor getStepExecutor() {
    return new StepExecutor(this._steps)
  }
}
