package normaljobs.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		
		addSliderWL ("numWorkers", "Number of Workers", 1 , 1 , 1000 , 11)
	}
}