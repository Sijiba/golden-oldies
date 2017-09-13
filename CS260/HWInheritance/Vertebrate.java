public class Vertebrate 
{
	private double brainSize;
	
	public Vertebrate(double brainSize)
	{
		this.brainSize = brainSize; //in cubic centimeters
	}
	
	public String toString()
	{
		return "brain size: " + this.brainSize;
	}
}