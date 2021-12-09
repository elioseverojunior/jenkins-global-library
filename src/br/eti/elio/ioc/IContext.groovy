package br.eti.elio.ioc

import br.eti.elio.IStepExecutor

interface IContext {
  IStepExecutor getStepExecutor()
}
