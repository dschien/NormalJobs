package normaljobs.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*
import normaljobs.ReLogoObserver
import repast.simphony.engine.environment.RunEnvironment
import repast.simphony.relogo.Stop
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class UserObserver extends ReLogoObserver{

	def openJobs = [] as Queue
	def doneJobs = [] as Queue

	@Setup
	def setup(){
		clearAll()
		this.openJobs = [] as Queue
		this.doneJobs = [] as Queue

		(0..<numJobs).each{
			this.openJobs << new Job(requirements:100)
		}

		createWorkers(numWorkers){
		}
	}

	@Go
	def go(){
		ask(workers()){ worker ->
			if (!worker.job) {
				if (this.openJobs){
					worker.job = this.openJobs.poll() 
				} 
			} 
			// let the worker work on it
			worker.step()
			
			if (worker.isJobDone()){
				this.doneJobs << worker.job
				worker.job = null
			}
		}		
	}
}
