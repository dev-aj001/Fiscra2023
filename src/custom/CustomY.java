/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import com.toedter.calendar.*;

import com.toedter.components.JSpinField;
import java.awt.Component;
import java.util.Calendar;
import javax.swing.JFrame;

public class CustomY extends JSpinField {
  private static final long serialVersionUID = 2648810220491090064L;
  
  protected CustomDay dayChooser;
  
  protected int oldYear;
  
  protected int startYear;
  
  protected int endYear;
  
  public CustomY() {
    setName("JYearChooser");
    Calendar calendar = Calendar.getInstance();
    this.dayChooser = null;
    setMinimum(calendar.getMinimum(1));
    setMaximum(calendar.getMaximum(1));
    setValue(calendar.get(1));
  }
  
  public void setYear(int paramInt) {
    setValue(paramInt, true, false);
    if (this.dayChooser != null)
      this.dayChooser.setYear(this.value); 
    this.spinner.setValue(new Integer(this.value));
    firePropertyChange("year", this.oldYear, this.value);
    this.oldYear = this.value;
  }
  
  public void setValue(int paramInt) {
    setYear(paramInt);
  }
  
  public int getYear() {
    return getValue();
  }
  
  public void setDayChooser(CustomDay paramJDayChooser) {
    this.dayChooser = paramJDayChooser;
  }
  
  public int getEndYear() {
    return getMaximum();
  }
  
  public void setEndYear(int paramInt) {
    setMaximum(paramInt);
  }
  
  public int getStartYear() {
    return getMinimum();
  }
  
  public void setStartYear(int paramInt) {
    setMinimum(paramInt);
  }
  
  public static void main(String[] paramArrayOfString) {
    JFrame jFrame = new JFrame("JYearChooser");
    jFrame.getContentPane().add((Component)new JYearChooser());
    jFrame.pack();
    jFrame.setVisible(true);
  }
}
