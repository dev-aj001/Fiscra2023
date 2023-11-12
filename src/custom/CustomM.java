/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import com.toedter.calendar.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CustomM extends JPanel implements ItemListener, ChangeListener {
  private static final long serialVersionUID = -2028361332231218527L;
  
  protected boolean hasSpinner;
  
  private Locale locale;
  
  private int month;
  
  private int oldSpinnerValue = 0;
  
  private CustomDay dayChooser;
  
  private CustomY yearChooser;
  
  private JComboBox comboBox;
  
  private JSpinner spinner;
  
  private boolean initialized;
  
  private boolean localInitialize;
  
  public CustomM() {
    this(true);
  }
  
  public CustomM(boolean paramBoolean) {
    setName("JMonthChooser");
    this.hasSpinner = paramBoolean;
    setLayout(new BorderLayout());
    this.comboBox = new JComboBox();
    this.comboBox.addItemListener(this);
    this.locale = Locale.getDefault();
    initNames();
    if (paramBoolean) {
      this.spinner = new JSpinner() {
          private static final long serialVersionUID = 1L;
          
          private JTextField textField = new JTextField();
          
          private final JMonthChooser this$0 = null;
          
          public Dimension getPreferredSize() {
            Dimension dimension = super.getPreferredSize();
            return new Dimension(dimension.width, (this.textField.getPreferredSize()).height);
          }
        };
      this.spinner.addChangeListener(this);
      this.spinner.setEditor(this.comboBox);
      this.comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
      updateUI();
      add(this.spinner, "West");
    } else {
      add(this.comboBox, "West");
    } 
    this.initialized = true;
    setMonth(Calendar.getInstance().get(2));
  }
  
  public void initNames() {
    this.localInitialize = true;
    DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.locale);
    String[] arrayOfString = dateFormatSymbols.getMonths();
    if (this.comboBox.getItemCount() == 12)
      this.comboBox.removeAllItems(); 
    for (byte b = 0; b < 12; b++)
      this.comboBox.addItem(arrayOfString[b]); 
    this.localInitialize = false;
    this.comboBox.setSelectedIndex(this.month);
  }
  
  public void stateChanged(ChangeEvent paramChangeEvent) {
    SpinnerNumberModel spinnerNumberModel = (SpinnerNumberModel)((JSpinner)paramChangeEvent.getSource()).getModel();
    int i = spinnerNumberModel.getNumber().intValue();
    boolean bool = (i > this.oldSpinnerValue) ? true : false;
    this.oldSpinnerValue = i;
    int j = getMonth();
    if (bool) {
      if (++j == 12) {
        j = 0;
        if (this.yearChooser != null) {
          int k = this.yearChooser.getYear();
          this.yearChooser.setYear(++k);
        } 
      } 
    } else if (--j == -1) {
      j = 11;
      if (this.yearChooser != null) {
        int k = this.yearChooser.getYear();
        this.yearChooser.setYear(--k);
      } 
    } 
    setMonth(j);
  }
  
  public void itemStateChanged(ItemEvent paramItemEvent) {
    if (paramItemEvent.getStateChange() == 1) {
      int i = this.comboBox.getSelectedIndex();
      if (i >= 0 && i != this.month)
        setMonth(i, false); 
    } 
  }
  
  private void setMonth(int paramInt, boolean paramBoolean) {
    if (!this.initialized || this.localInitialize)
      return; 
    int i = this.month;
    this.month = paramInt;
    if (paramBoolean)
      this.comboBox.setSelectedIndex(this.month); 
    if (this.dayChooser != null)
      this.dayChooser.setMonth(this.month); 
    firePropertyChange("month", i, this.month);
  }
  
  public void setMonth(int paramInt) {
    if (paramInt < 0 || paramInt == Integer.MIN_VALUE) {
      setMonth(0, true);
    } else if (paramInt > 11) {
      setMonth(11, true);
    } else {
      setMonth(paramInt, true);
    } 
  }
  
  public int getMonth() {
    return this.month;
  }
  
  public void setDayChooser(CustomDay paramJDayChooser) {
    this.dayChooser = paramJDayChooser;
  }
  
  public void setYearChooser(CustomY paramJYearChooser) {
    this.yearChooser = paramJYearChooser;
  }
  
  public Locale getLocale() {
    return this.locale;
  }
  
  public void setLocale(Locale paramLocale) {
    if (!this.initialized) {
      super.setLocale(paramLocale);
    } else {
      this.locale = paramLocale;
      initNames();
    } 
  }
  
  public void setEnabled(boolean paramBoolean) {
    super.setEnabled(paramBoolean);
    this.comboBox.setEnabled(paramBoolean);
    if (this.spinner != null)
      this.spinner.setEnabled(paramBoolean); 
  }
  
  public Component getComboBox() {
    return this.comboBox;
  }
  
  public Component getSpinner() {
    return this.spinner;
  }
  
  public boolean hasSpinner() {
    return this.hasSpinner;
  }
  
  public void setFont(Font paramFont) {
    if (this.comboBox != null)
      this.comboBox.setFont(paramFont); 
    super.setFont(paramFont);
  }
  
  public void updateUI() {
    JSpinner jSpinner = new JSpinner();
    if (this.spinner != null)
      if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
        this.spinner.setBorder(jSpinner.getBorder());
      } else {
        this.spinner.setBorder(new EmptyBorder(0, 0, 0, 0));
      }  
  }
  
  public static void main(String[] paramArrayOfString) {
    JFrame jFrame = new JFrame("MonthChooser");
    jFrame.getContentPane().add(new JMonthChooser());
    jFrame.pack();
    jFrame.setVisible(true);
  }
}
