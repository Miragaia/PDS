package mvc.thermoMVC.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mvc.thermoMVC.model.Thermometer;
import mvc.thermoMVC.model.ThermometerListener;

/**
 * A thermometer that displays as a digital thermometer.
 */
public class DigitalCelciusDisplay extends JPanel implements ThermometerListener {
	
	// The label displaying the temperature
	private JLabel tempLabelCelcius;
	
	// The Unicode symbol for degrees
	private static final char DEGREE_SYMBOL = '\u00B0';
	
	/** The thermometer whose temperature is being displayed */
	protected Thermometer thermometer;
	
	/**
	 * Creates a digital thermometer
	 * @param t the thermometer whose temperature is displayed
	 */
	public DigitalCelciusDisplay(Thermometer t) {
		thermometer = t;

		JPanel tempPanelCelcius = new JPanel();
		tempLabelCelcius = new JLabel(getDisplayString());
		tempLabelCelcius.setFont(tempLabelCelcius.getFont().deriveFont(20.0f));
		tempPanelCelcius.setBorder(BorderFactory.createLineBorder(Color.red));
		tempPanelCelcius.add(tempLabelCelcius);
		add(tempPanelCelcius);
	}

	/**
	 * Create the string to display in the thermometer
	 * @return the string to display in the thermometer
	 */
	private String getDisplayString() {
        int celcius = (thermometer.getTemperature() - 32) * 5 / 9;
		return "" + celcius + DEGREE_SYMBOL + "C";
	}
	
	/**
	 * Change the temperature displayed
	 */
	@Override
	public void temperatureChanged() {
		tempLabelCelcius.setText(getDisplayString());
		repaint();
	}
}
