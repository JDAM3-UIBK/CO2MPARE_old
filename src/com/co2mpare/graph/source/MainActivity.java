
package com.co2mpare.graph.source;

import java.util.ArrayList;
import java.util.Arrays;

import com.androidplot.ui.AnchorPosition;
import com.androidplot.ui.DynamicTableModel;
import com.androidplot.ui.SizeLayoutType;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.XLayoutStyle;
import com.androidplot.ui.YLayoutStyle;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import android.graphics.Paint;

/**
 * A example of using AndroidPlot to plot some data.
 * I didn't insert Number array from outside, but
 * included a method to change it. As example a array list
 * is converted to a number array.
 * 
 * @author Manuel Kapferer
 */
public class MainActivity extends Activity
{
    private MultitouchPlot multitouchPlot;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                                 WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.fragment_graph);

        // initialize our XYPlot reference:
        multitouchPlot = (MultitouchPlot) findViewById(R.id.multitouchPlot);
        
        // setup our xyplot, 
        multitouchPlot.getBackgroundPaint().setColor(Color.TRANSPARENT);						// set background transparent
        multitouchPlot.setBorderStyle(XYPlot.BorderStyle.NONE, null, null);
        multitouchPlot.getGraphWidget().getBackgroundPaint().setColor(Color.TRANSPARENT); 		// set graph background transparent
        multitouchPlot.getGraphWidget().getGridBackgroundPaint().setColor(Color.TRANSPARENT);   // set grid graph background transparent
        multitouchPlot.getGraphWidget().setDomainLabelWidth((float) 50);						// lifts the bottom 50 up
        multitouchPlot.getGraphWidget().getDomainLabelPaint().setTextSize(20);					// sets bottom text size 20
        multitouchPlot.getGraphWidget().getRangeLabelPaint().setTextSize(20);					// sets Left text size 20

        
        // ************************************* legend changes *****************************
        // use a 2x2 grid:
        multitouchPlot.getLegendWidget().setTableModel(new DynamicTableModel(2, 2));
 
        // adjust the legend size so there is enough room
        // to draw the new legend grid:
        multitouchPlot.getLegendWidget().setSize(new SizeMetrics(80, SizeLayoutType.ABSOLUTE, 150, SizeLayoutType.ABSOLUTE));
 
        // add a semi-transparent black background to the legend
        // so it's easier to see overlaid on top of our plot:
        Paint bgPaint = new Paint();
        bgPaint.setColor(Color.BLACK);
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setAlpha(140);
        multitouchPlot.getLegendWidget().setBackgroundPaint(bgPaint);
 
        // adjust the padding of the legend widget to look a little nicer:
        multitouchPlot.getLegendWidget().setPadding(10, 1, 1, 1);      
 
        // reposition the grid so that it rests above the bottom-left
        // edge of the graph widget:
        multitouchPlot.getLegendWidget().position(
                20,
                XLayoutStyle.ABSOLUTE_FROM_RIGHT,
                80,
                YLayoutStyle.ABSOLUTE_FROM_BOTTOM,
                AnchorPosition.RIGHT_BOTTOM);

        
        // Create a couple arrays of y-values to plot:
        // Here you can implement "fromArrayListToNumberArray" method instead
        // of fix numbers.
        Number[] series1Numbers = {1, 8, 5, 2, 7, 4};
        Number[] series2Numbers = {4, 6, 3, 8, 2, 10};
        Number[] series3Numbers = {2, 6, 8, 1, 3, 7};

        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "CO2");                             // Set the display title of the series

        // same as above
        XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Geld");

        // same as above
        XYSeries series3 = new SimpleXYSeries(Arrays.asList(series3Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Zeit");

        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_plf1);

        // add a new series' to the xyplot:
        multitouchPlot.addSeries(series1, series1Format);

     // same as above:
        LineAndPointFormatter series2Format = new LineAndPointFormatter();
        series2Format.setPointLabelFormatter(new PointLabelFormatter());
        series2Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_plf2);
        multitouchPlot.addSeries(series2, series2Format);
        
     // same as above:
        LineAndPointFormatter series3Format = new LineAndPointFormatter();
        series3Format.setPointLabelFormatter(new PointLabelFormatter());
        series3Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_plf3);
        multitouchPlot.addSeries(series3, series3Format);

        
        // reduce the number of range labels
        multitouchPlot.setTicksPerRangeLabel(3);
        multitouchPlot.getGraphWidget().setDomainLabelOrientation(-45);

    }
    
    /**
     * This method canges an array list into a number array.
     * @param list
     * 				List of values for change
     * @return
     * 				Array of numbers for graph
     */
    public Number[] fromArrayListToNumberArray(ArrayList<?> list){
    	Number[] numbers = new Number[list.size()];
    	
    	for(int i = 0; i < list.size(); i++){
    		numbers[i] = (Number) list.get(i);
    	}
    	
    	return null;
    }
}