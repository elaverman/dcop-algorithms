package com.signalcollect.dcop.modules

trait ConfigurationModule[AgentId, Action, NeighbourParams] extends Serializable {
  this: OptimizerModule[AgentId, Action, NeighbourParams] =>

  type Config <: Configuration
  type Factory <: ConfigFactory

  val factory: Factory

  trait ConfigFactory extends Serializable {
    /**
     * Implementations need to offer a function to create
     * a configuration. In order to be able to create configurations with different
     * constructors, this function is unfortunately not typesafe and accepts
     * whatever is passed. It crashes at runtime if the parameters are wrong. :(
     */
    def createNewConfig(params: Any*): Config
  }

  trait Configuration extends Serializable {
    def neighborhood: Map[AgentId, (Action, NeighbourParams)]
    def domain: Set[Action]
    def withCentralVariableAssignment(value: Action): Config
    def centralVariableAssignment: (AgentId, Action)
    def centralVariableValue = centralVariableAssignment._2
    def computeExpectedNumberOfConflicts: Int
  }
}
