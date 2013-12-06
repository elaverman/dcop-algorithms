package com.signalcollect.dcop

import com.signalcollect.dcop.modules._
import com.signalcollect.dcop.impl._

trait DefaultDcopAlgorithm
  extends DcopAlgorithm[Int, Int] {
  type Config = DefaultConfig
}

trait DcopAlgorithm[AgentId, Action]
  extends OptimizerModule[AgentId, Action]
  with AdjustmentSchedules[AgentId, Action]
  with DecisionRulesWithTargetFunctions[AgentId, Action]
  with TargetFunctionsWithUtilityFunctions[AgentId, Action]
  with UtilityFunctions[AgentId, Action]
  with Configurations[AgentId, Action]
