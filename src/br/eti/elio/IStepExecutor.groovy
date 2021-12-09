package br.eti.elio

/**
* Interface for calling any necessary Jenkins steps. This will be mocked in unit tests.
*/
interface IStepExecutor {
  int sh(String command)
  void error(String message)
}