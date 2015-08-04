package lesson7.lab7.prob2;

public interface ClosedCurve extends Polygon{

	@Override
	default double[] getSides(){ return null;}

}
