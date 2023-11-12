package custom;

import com.toedter.calendar.*;

import com.toedter.components.UTF8ResourceBundle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomCalen extends JPanel implements PropertyChangeListener {
  private static final long serialVersionUID = 8913369762644440133L;
  
  private Calendar calendar;
  
  private boolean initialized = false;
  
  private final JPanel monthYearPanel;
  
  private final JPanel specialButtonPanel;
  
  private boolean isTodayButtonVisible;
  
  private boolean isNullDateButtonVisible;
  
  private final String defaultTodayButtonText = "Today";
  
  private final String defaultNullDateButtonText = "No Date";
  
  private String todayButtonText;
  
  private String nullDateButtonText;
  
  protected CustomDay dayChooser;
  
  protected boolean weekOfYearVisible = true;
  
  protected Locale locale;
  
  protected CustomM monthChooser;
  
  protected CustomY yearChooser;
  
  private final JButton todayButton;
  
  private final JButton nullDateButton;
  
  public CustomCalen() {
    this((Date)null, (Locale)null, true, true);
  }
  
  public CustomCalen(Date paramDate) {
    this(paramDate, (Locale)null, true, true);
  }
  
  public CustomCalen(Calendar paramCalendar) {
    this((Date)null, (Locale)null, true, true);
    setCalendar(paramCalendar);
  }
  
  public CustomCalen(Locale paramLocale) {
    this((Date)null, paramLocale, true, true);
  }
  
  public CustomCalen(Date paramDate, Locale paramLocale) {
    this(paramDate, paramLocale, true, true);
  }
  
  public CustomCalen(Date paramDate, boolean paramBoolean) {
    this(paramDate, (Locale)null, paramBoolean, true);
  }
  
  public CustomCalen(Locale paramLocale, boolean paramBoolean) {
    this((Date)null, paramLocale, paramBoolean, true);
  }
  
  public CustomCalen(boolean paramBoolean) {
    this((Date)null, (Locale)null, paramBoolean, true);
  }
  
  public CustomCalen(Date paramDate, Locale paramLocale, boolean paramBoolean1, boolean paramBoolean2) {
    setName("JCalendar");
    this.dayChooser = null;
    this.monthChooser = null;
    this.yearChooser = null;
    this.weekOfYearVisible = paramBoolean2;
    if (paramLocale == null) {
      this.locale = Locale.getDefault();
    } else {
      this.locale = paramLocale;
    } 
    this.calendar = Calendar.getInstance(this.locale);
    setLayout(new BorderLayout());
    this.monthYearPanel = new JPanel();
    this.monthYearPanel.setLayout(new BorderLayout());
    this.monthChooser = new CustomM(paramBoolean1);
    this.yearChooser = new CustomY();
    this.monthChooser.setYearChooser(this.yearChooser);
    this.monthChooser.setLocale(this.locale);
    this.monthYearPanel.add(this.monthChooser, "West");
    this.monthYearPanel.add((Component)this.yearChooser, "Center");
    this.monthYearPanel.setBorder(BorderFactory.createEmptyBorder());
    this.dayChooser = new CustomDay(paramBoolean2);
    this.dayChooser.addPropertyChangeListener(this);
    this.dayChooser.setLocale(this.locale);
    this.monthChooser.setDayChooser(this.dayChooser);
    this.monthChooser.addPropertyChangeListener(this);
    this.yearChooser.setDayChooser(this.dayChooser);
    this.yearChooser.addPropertyChangeListener(this);
    add(this.monthYearPanel, "North");
    add(this.dayChooser, "Center");
    this.specialButtonPanel = new JPanel();
    this.todayButton = new JButton();
    this.todayButton.addActionListener(new ActionListener() {
          private final CustomCalen this$0 = null;
          
          public void actionPerformed(ActionEvent param1ActionEvent) {
            CustomCalen.this.setDate(new Date());
          }
        });
    this.nullDateButton = new JButton();
    this.nullDateButton.addActionListener(new ActionListener() {
          private final CustomCalen this$0 = null;
          
          public void actionPerformed(ActionEvent param1ActionEvent) {
            CustomCalen.this.dayChooser.firePropertyChange("day", 0, -1);
          }
        });
    this.specialButtonPanel.setVisible(false);
    add(this.specialButtonPanel, "South");
    if (paramDate != null)
      this.calendar.setTime(paramDate); 
    this.initialized = true;
    setCalendar(this.calendar);
  }
  
  public static void main(String[] paramArrayOfString) {
    JFrame jFrame = new JFrame("JCalendar");
    JCalendar jCalendar = new JCalendar();
    jFrame.getContentPane().add(jCalendar);
    jFrame.pack();
    jFrame.setVisible(true);
  }
  
  public Calendar getCalendar() {
    return this.calendar;
  }
  
  public CustomDay getDayChooser() {
    return this.dayChooser;
  }
  
  public Locale getLocale() {
    return this.locale;
  }
  
  public CustomM getMonthChooser() {
    return this.monthChooser;
  }
  
  public CustomY getYearChooser() {
    return this.yearChooser;
  }
  
  public void addActivityDate(Date date) {
    this.dayChooser.addActivityDate(date);
  }
  
  public boolean isWeekOfYearVisible() {
    return this.dayChooser.isWeekOfYearVisible();
  }
  
  public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent) {
    if (this.calendar != null) {
      Calendar calendar = (Calendar)this.calendar.clone();
      if (paramPropertyChangeEvent.getPropertyName().equals("day")) {
        calendar.set(5, ((Integer)paramPropertyChangeEvent.getNewValue()).intValue());
        setCalendar(calendar, false);
      } else if (paramPropertyChangeEvent.getPropertyName().equals("month")) {
        calendar.set(2, ((Integer)paramPropertyChangeEvent.getNewValue()).intValue());
        setCalendar(calendar, false);
      } else if (paramPropertyChangeEvent.getPropertyName().equals("year")) {
        calendar.set(1, ((Integer)paramPropertyChangeEvent.getNewValue()).intValue());
        setCalendar(calendar, false);
      } else if (paramPropertyChangeEvent.getPropertyName().equals("date")) {
        calendar.setTime((Date)paramPropertyChangeEvent.getNewValue());
        setCalendar(calendar, true);
      } 
    } 
  }
  
  public void setBackground(Color paramColor) {
    super.setBackground(paramColor);
    if (this.dayChooser != null)
      this.dayChooser.setBackground(paramColor); 
  }
  
  public void setCalendar(Calendar paramCalendar) {
    setCalendar(paramCalendar, true);
  }
  
  private void setCalendar(Calendar paramCalendar, boolean paramBoolean) {
    if (paramCalendar == null)
      setDate((Date)null); 
    Calendar calendar = this.calendar;
    this.calendar = paramCalendar;
    if (paramBoolean) {
      this.yearChooser.setYear(paramCalendar.get(1));
      this.monthChooser.setMonth(paramCalendar.get(2));
      this.dayChooser.setDay(paramCalendar.get(5));
    } 
    firePropertyChange("calendar", calendar, this.calendar);
  }
  
  public void setEnabled(boolean paramBoolean) {
    super.setEnabled(paramBoolean);
    if (this.dayChooser != null) {
      this.dayChooser.setEnabled(paramBoolean);
      this.monthChooser.setEnabled(paramBoolean);
      this.yearChooser.setEnabled(paramBoolean);
    } 
  }
  
  public boolean isEnabled() {
    return super.isEnabled();
  }
  
  public void setFont(Font paramFont) {
    super.setFont(paramFont);
    if (this.dayChooser != null) {
      this.dayChooser.setFont(paramFont);
      this.monthChooser.setFont(paramFont);
      this.yearChooser.setFont(paramFont);
    } 
  }
  
  public void setForeground(Color paramColor) {
    super.setForeground(paramColor);
    if (this.dayChooser != null) {
      this.dayChooser.setForeground(paramColor);
      this.monthChooser.setForeground(paramColor);
      this.yearChooser.setForeground(paramColor);
    } 
  }
  
  public void setLocale(Locale paramLocale) {
    if (!this.initialized) {
      super.setLocale(paramLocale);
    } else {
      Locale locale = this.locale;
      this.locale = paramLocale;
      this.dayChooser.setLocale(this.locale);
      this.monthChooser.setLocale(this.locale);
      relayoutSpecialButtonPanel();
      firePropertyChange("locale", locale, this.locale);
    } 
  }
  
  public void setWeekOfYearVisible(boolean paramBoolean) {
    this.dayChooser.setWeekOfYearVisible(paramBoolean);
    setLocale(this.locale);
  }
  
  public boolean isDecorationBackgroundVisible() {
    return this.dayChooser.isDecorationBackgroundVisible();
  }
  
  public void setDecorationBackgroundVisible(boolean paramBoolean) {
    this.dayChooser.setDecorationBackgroundVisible(paramBoolean);
    setLocale(this.locale);
  }
  
  public boolean isDecorationBordersVisible() {
    return this.dayChooser.isDecorationBordersVisible();
  }
  
  public void setDecorationBordersVisible(boolean paramBoolean) {
    this.dayChooser.setDecorationBordersVisible(paramBoolean);
    setLocale(this.locale);
  }
  
  public Color getDecorationBackgroundColor() {
    return this.dayChooser.getDecorationBackgroundColor();
  }
  
  public void setDecorationBackgroundColor(Color paramColor) {
    this.dayChooser.setDecorationBackgroundColor(paramColor);
  }
  
  public Color getSundayForeground() {
    return this.dayChooser.getSundayForeground();
  }
  
  public Color getWeekdayForeground() {
    return this.dayChooser.getWeekdayForeground();
  }
  
  public void setSundayForeground(Color paramColor) {
    this.dayChooser.setSundayForeground(paramColor);
  }
  
  public void setWeekdayForeground(Color paramColor) {
    this.dayChooser.setWeekdayForeground(paramColor);
  }
  
  public Date getDate() {
    return new Date(this.calendar.getTimeInMillis());
  }
  
  public void setDate(Date paramDate) {
    Date date = this.calendar.getTime();
    this.calendar.setTime(paramDate);
    int i = this.calendar.get(1);
    int j = this.calendar.get(2);
    int k = this.calendar.get(5);
    this.yearChooser.setYear(i);
    this.monthChooser.setMonth(j);
    this.dayChooser.setCalendar(this.calendar);
    this.dayChooser.setDay(k);
    firePropertyChange("date", date, paramDate);
  }
  
  public void setSelectableDateRange(Date paramDate1, Date paramDate2) {
    this.dayChooser.setSelectableDateRange(paramDate1, paramDate2);
  }
  
  public Date getMaxSelectableDate() {
    return this.dayChooser.getMaxSelectableDate();
  }
  
  public Date getMinSelectableDate() {
    return this.dayChooser.getMinSelectableDate();
  }
  
  public void setMaxSelectableDate(Date paramDate) {
    this.dayChooser.setMaxSelectableDate(paramDate);
  }
  
  public void setMinSelectableDate(Date paramDate) {
    this.dayChooser.setMinSelectableDate(paramDate);
  }
  
  public int getMaxDayCharacters() {
    return this.dayChooser.getMaxDayCharacters();
  }
  
  public void setMaxDayCharacters(int paramInt) {
    this.dayChooser.setMaxDayCharacters(paramInt);
  }
  
  public void setTodayButtonVisible(boolean paramBoolean) {
    this.isTodayButtonVisible = paramBoolean;
    relayoutSpecialButtonPanel();
  }
  
  public boolean isTodayButtonVisible() {
    return this.isTodayButtonVisible;
  }
  
  public void setNullDateButtonVisible(boolean paramBoolean) {
    this.isNullDateButtonVisible = paramBoolean;
    relayoutSpecialButtonPanel();
  }
  
  public boolean isNullDateButtonVisible() {
    return this.isNullDateButtonVisible;
  }
  
  private void relayoutSpecialButtonPanel() {
    ResourceBundle resourceBundle = null;
    try {
      resourceBundle = UTF8ResourceBundle.getBundle("com.toedter.calendar.jcalendar", this.locale);
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    } 
    this.specialButtonPanel.removeAll();
    byte b = 0;
    if (this.isTodayButtonVisible) {
      String str = this.todayButtonText;
      if (str == null && resourceBundle != null)
        try {
          str = resourceBundle.getString("todayButton.text");
        } catch (Exception exception) {} 
      if (str == null)
        str = "Today"; 
      this.todayButton.setText(str);
      this.specialButtonPanel.add(this.todayButton);
      b++;
    } 
    if (this.isNullDateButtonVisible) {
      String str = this.nullDateButtonText;
      if (str == null && resourceBundle != null)
        try {
          str = resourceBundle.getString("nullDateButton.text");
        } catch (Exception exception) {} 
      if (str == null)
        str = "No Date"; 
      this.nullDateButton.setText(str);
      this.specialButtonPanel.add(this.nullDateButton);
      b++;
    } 
    this.specialButtonPanel.setLayout(new GridLayout(1, b));
    if (this.isTodayButtonVisible)
      this.specialButtonPanel.add(this.todayButton); 
    if (this.isNullDateButtonVisible)
      this.specialButtonPanel.add(this.nullDateButton); 
    this.specialButtonPanel.setVisible((this.isNullDateButtonVisible || this.isTodayButtonVisible));
    this.todayButton.invalidate();
    this.todayButton.repaint();
    this.nullDateButton.invalidate();
    this.nullDateButton.repaint();
    this.specialButtonPanel.invalidate();
    this.specialButtonPanel.doLayout();
    this.specialButtonPanel.repaint();
    invalidate();
    repaint();
  }
  
  public String getTodayButtonText() {
    return this.todayButtonText;
  }
  
  public void setTodayButtonText(String paramString) {
    if ((((paramString != null) ? 1 : 0) & ((paramString.trim().length() == 0) ? 1 : 0)) != 0) {
      this.todayButtonText = null;
    } else {
      this.todayButtonText = paramString;
    } 
    relayoutSpecialButtonPanel();
  }
  
  public String getNullDateButtonText() {
    return this.nullDateButtonText;
  }
  
  public void setNullDateButtonText(String paramString) {
    if ((((paramString != null) ? 1 : 0) & ((paramString.trim().length() == 0) ? 1 : 0)) != 0) {
      this.nullDateButtonText = null;
    } else {
      this.nullDateButtonText = paramString;
    } 
    relayoutSpecialButtonPanel();
  }
}
