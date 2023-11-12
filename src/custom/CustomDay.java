/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import com.toedter.calendar.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class CustomDay extends JPanel implements ActionListener, KeyListener, FocusListener {
  private static final long serialVersionUID = 5876398337018781820L;
  
  protected JButton[] days;
  
  protected JButton[] weeks;
  
  protected JButton selectedDay;
  
  protected JPanel weekPanel;
  
  protected JPanel dayPanel;
  
  protected int day;
  
  protected Color oldDayBackgroundColor;
  
  protected Color selectedColor;
  
  protected Color activityDay;
  
  protected Color sundayForeground;
  
  protected Color weekdayForeground;
  
  protected Color decorationBackgroundColor;
  
  protected String[] dayNames;
  
  protected Calendar calendar;
  
  protected Calendar today;
  
  protected Locale locale;
  
  protected boolean initialized;
  
  protected boolean weekOfYearVisible;
  
  protected boolean decorationBackgroundVisible = true;
  
  protected boolean decorationBordersVisible;
  
  protected boolean dayBordersVisible;
  
  private boolean alwaysFireDayProperty;
  
  protected int maxDayCharacters;
  
  protected List dateEvaluators;
  
  protected MinMaxDateEvaluator minMaxDateEvaluator;
  
  public CustomDay() {
    this(false);
  }
  
  public CustomDay(boolean paramBoolean) {
    setName("JDayChooser");
    setBackground(Color.blue);
    this.dateEvaluators = new ArrayList(1);
    this.minMaxDateEvaluator = new MinMaxDateEvaluator();
    addDateEvaluator(this.minMaxDateEvaluator);
    this.weekOfYearVisible = paramBoolean;
    this.locale = Locale.getDefault();
    this.days = new JButton[49];
    this.selectedDay = null;
    this.calendar = Calendar.getInstance(this.locale);
    this.today = (Calendar)this.calendar.clone();
    setLayout(new BorderLayout());
    this.dayPanel = new JPanel();
    this.dayPanel.setLayout(new GridLayout(7, 7));
    this.sundayForeground = new Color(164, 0, 0);
    this.weekdayForeground = new Color(0, 90, 164);
    this.decorationBackgroundColor = new Color(210, 228, 238);
    byte b;
    for (b = 0; b < 7; b++) {
      for (byte b1 = 0; b1 < 7; b1++) {
        int i = b1 + 7 * b;
        if (b == 0) {
          this.days[i] = new DecoratorButton();
        } else {
          this.days[i] = new JButton("x") {
              private static final long serialVersionUID = -7433645992591669725L;
              
              private final CustomDay this$0 = null;
              
              public void paint(Graphics param1Graphics) {
                if ("Windows".equals(UIManager.getLookAndFeel().getID()) && CustomDay.this.selectedDay == this) {
                  param1Graphics.setColor(CustomDay.this.selectedColor);
                  param1Graphics.fillRect(0, 0, getWidth(), getHeight());
                } 
                super.paint(param1Graphics);
              }
            };
          this.days[i].addActionListener(this);
          this.days[i].addKeyListener(this);
          this.days[i].addFocusListener(this);
        } 
        this.days[i].setMargin(new Insets(0, 0, 0, 0));
        this.days[i].setFocusPainted(false);
        this.dayPanel.add(this.days[i]);
      } 
    } 
    this.weekPanel = new JPanel();
    this.weekPanel.setLayout(new GridLayout(7, 1));
    this.weeks = new JButton[7];
    for (b = 0; b < 7; b++) {
      this.weeks[b] = new DecoratorButton();
      this.weeks[b].setMargin(new Insets(0, 0, 0, 0));
      this.weeks[b].setFocusPainted(false);
      this.weeks[b].setForeground(new Color(100, 100, 100));
      if (b != 0)
        this.weeks[b].setText("0" + (b + 1)); 
      this.weekPanel.add(this.weeks[b]);
    } 
    init();
    setDay(Calendar.getInstance().get(5));
    add(this.dayPanel, "Center");
    if (paramBoolean)
      add(this.weekPanel, "West"); 
    this.initialized = true;
    updateUI();
  }
  
  protected void init() {
    JButton jButton = new JButton();
    this.oldDayBackgroundColor = jButton.getBackground();
    this.selectedColor = new Color(255, 0, 0);
    this.activityDay = new Color(0,255,0);
    Date date = this.calendar.getTime();
    this.calendar = Calendar.getInstance(this.locale);
    this.calendar.setTime(date);
    drawDayNames();
    drawDays();
  }
  
  private void drawDayNames() {
    int i = this.calendar.getFirstDayOfWeek();
    DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.locale);
    this.dayNames = dateFormatSymbols.getShortWeekdays();
    int j = i;
    for (byte b = 0; b < 7; b++) {
      if (this.maxDayCharacters > 0 && this.maxDayCharacters < 5 && this.dayNames[j].length() >= this.maxDayCharacters)
        this.dayNames[j] = this.dayNames[j].substring(0, this.maxDayCharacters); 
      this.days[b].setText(this.dayNames[j]);
      if (j == 1) {
        this.days[b].setForeground(this.sundayForeground);
      } else {
        this.days[b].setForeground(this.weekdayForeground);
      } 
      if (j < 7) {
        j++;
      } else {
        j -= 6;
      } 
    } 
  }
  
  protected void initDecorations() {
    for (byte b = 0; b < 7; b++) {
      this.days[b].setContentAreaFilled(this.decorationBackgroundVisible);
      this.days[b].setBorderPainted(this.decorationBordersVisible);
      this.days[b].invalidate();
      this.days[b].repaint();
      this.weeks[b].setContentAreaFilled(this.decorationBackgroundVisible);
      this.weeks[b].setBorderPainted(this.decorationBordersVisible);
      this.weeks[b].invalidate();
      this.weeks[b].repaint();
    } 
  }
  
  protected void drawWeeks() {
    Calendar calendar = (Calendar)this.calendar.clone();
    for (byte b = 1; b < 7; b++) {
      calendar.set(5, b * 7 - 6);
      int i = calendar.get(3);
      String str = Integer.toString(i);
      if (i < 10)
        str = "0" + str; 
      this.weeks[b].setText(str);
      if (b == 5 || b == 6)
        this.weeks[b].setVisible(this.days[b * 7].isVisible()); 
    } 
  }
  
  protected void drawDays() {
    Calendar calendar = (Calendar)this.calendar.clone();
    calendar.set(11, 0);
    calendar.set(12, 0);
    calendar.set(13, 0);
    calendar.set(14, 0);
    int i = calendar.getFirstDayOfWeek();
    calendar.set(5, 1);
    int j = calendar.get(7) - i;
    if (j < 0)
      j += 7; 
    byte b1;
    for (b1 = 0; b1 < j; b1++) {
      this.days[b1 + 7].setVisible(false);
      this.days[b1 + 7].setText("");
    } 
    calendar.add(2, 1);
    Date date1 = calendar.getTime();
    calendar.add(2, -1);
    Date date2 = calendar.getTime();
    byte b2 = 0;
    Color color = getForeground();
    while (date2.before(date1)) {
      this.days[b1 + b2 + 7].setText(Integer.toString(b2 + 1));
      this.days[b1 + b2 + 7].setVisible(true);
      if (calendar.get(6) == this.today.get(6) && calendar.get(1) == this.today.get(1)) {
        this.days[b1 + b2 + 7].setForeground(this.sundayForeground);
      } else {
        this.days[b1 + b2 + 7].setForeground(color);
      } 
      if (b2 + 1 == this.day) {
        this.days[b1 + b2 + 7].setBackground(this.selectedColor);
        this.selectedDay = this.days[b1 + b2 + 7];
      } else {
        this.days[b1 + b2 + 7].setBackground(this.oldDayBackgroundColor);
      } 
      Iterator iterator = this.dateEvaluators.iterator();
      this.days[b1 + b2 + 7].setEnabled(true);
      while (iterator.hasNext()) {
        IDateEvaluator iDateEvaluator = (IDateEvaluator) iterator.next();
        if (iDateEvaluator.isSpecial(date2)) {
          this.days[b1 + b2 + 7].setForeground(iDateEvaluator.getSpecialForegroundColor());
          this.days[b1 + b2 + 7].setBackground(iDateEvaluator.getSpecialBackroundColor());
          this.days[b1 + b2 + 7].setToolTipText(iDateEvaluator.getSpecialTooltip());
          this.days[b1 + b2 + 7].setEnabled(true);
        } 
        if (iDateEvaluator.isInvalid(date2)) {
          this.days[b1 + b2 + 7].setForeground(iDateEvaluator.getInvalidForegroundColor());
          this.days[b1 + b2 + 7].setBackground(iDateEvaluator.getInvalidBackroundColor());
          this.days[b1 + b2 + 7].setToolTipText(iDateEvaluator.getInvalidTooltip());
          this.days[b1 + b2 + 7].setEnabled(false);
        } 
      } 
      b2++;
      calendar.add(5, 1);
      date2 = calendar.getTime();
    } 
    for (int k = b2 + b1 + 7; k < 49; k++) {
      this.days[k].setVisible(false);
      this.days[k].setText("");
    } 
    drawWeeks();
  }
  
  public Locale getLocale() {
    return this.locale;
  }
  
  public void setLocale(Locale paramLocale) {
    if (!this.initialized) {
      super.setLocale(paramLocale);
    } else {
      this.locale = paramLocale;
      super.setLocale(paramLocale);
      init();
    } 
  }
  
  public void setDay(int paramInt) {
    if (paramInt < 1)
      paramInt = 1; 
    Calendar calendar = (Calendar)this.calendar.clone();
    calendar.set(5, 1);
    calendar.add(2, 1);
    calendar.add(5, -1);
    int i = calendar.get(5);
    if (paramInt > i)
      paramInt = i; 
    int j = this.day;
    this.day = paramInt;
    if (this.selectedDay != null) {
      this.selectedDay.setBackground(this.oldDayBackgroundColor);
      this.selectedDay.repaint();
    } 
    for (byte b = 7; b < 49; b++) {
      if (this.days[b].getText().equals(Integer.toString(this.day))) {
        this.selectedDay = this.days[b];
        this.selectedDay.setBackground(this.selectedColor);
        break;
      } 
    } 
    if (this.alwaysFireDayProperty) {
      firePropertyChange("day", 0, this.day);
    } else {
      firePropertyChange("day", j, this.day);
    } 
  }
  
  public void setAlwaysFireDayProperty(boolean paramBoolean) {
    this.alwaysFireDayProperty = paramBoolean;
  }
  
  public int getDay() {
    return this.day;
  }
  
  public void setMonth(int paramInt) {
    this.calendar.set(2, paramInt);
    int i = this.calendar.getActualMaximum(5);
    if (this.day > i)
      this.day = i; 
    drawDays();
  }
  
  public void setYear(int paramInt) {
    this.calendar.set(1, paramInt);
    drawDays();
  }
  
  public void setCalendar(Calendar paramCalendar) {
    this.calendar = paramCalendar;
    drawDays();
  }
  
  public void setFont(Font paramFont) {
    if (this.days != null)
      for (byte b = 0; b < 49; b++)
        this.days[b].setFont(paramFont);  
    if (this.weeks != null)
      for (byte b = 0; b < 7; b++)
        this.weeks[b].setFont(paramFont);  
  }
  
  public void setForeground(Color paramColor) {
    super.setForeground(paramColor);
    if (this.days != null) {
      for (byte b = 7; b < 49; b++)
        this.days[b].setForeground(paramColor); 
      drawDays();
    } 
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    JButton jButton = (JButton)paramActionEvent.getSource();
    String str = jButton.getText();
    int i = (new Integer(str)).intValue();
    setDay(i);
  }
  
  public void focusGained(FocusEvent paramFocusEvent) {}
  
  public void focusLost(FocusEvent paramFocusEvent) {}
  
  public void keyPressed(KeyEvent paramKeyEvent) {
    byte b = (byte) ((paramKeyEvent.getKeyCode() == 38) ? -7 : ((paramKeyEvent.getKeyCode() == 40) ? 7 : ((paramKeyEvent.getKeyCode() == 37) ? -1 : ((paramKeyEvent.getKeyCode() == 39) ? 1 : 0))));
    int i = getDay() + b;
    if (i >= 1 && i <= this.calendar.getMaximum(5))
      setDay(i); 
  }
  
  public void keyTyped(KeyEvent paramKeyEvent) {}
  
  public void keyReleased(KeyEvent paramKeyEvent) {}
  
  public void setEnabled(boolean paramBoolean) {
    super.setEnabled(paramBoolean);
    short s;
    for (s = 0; s < this.days.length; s = (short)(s + 1)) {
      if (this.days[s] != null)
        this.days[s].setEnabled(paramBoolean); 
    } 
    for (s = 0; s < this.weeks.length; s = (short)(s + 1)) {
      if (this.weeks[s] != null)
        this.weeks[s].setEnabled(paramBoolean); 
    } 
  }
  
  public boolean isWeekOfYearVisible() {
    return this.weekOfYearVisible;
  }
  
  public void setWeekOfYearVisible(boolean paramBoolean) {
    if (paramBoolean == this.weekOfYearVisible)
      return; 
    if (paramBoolean) {
      add(this.weekPanel, "West");
    } else {
      remove(this.weekPanel);
    } 
    this.weekOfYearVisible = paramBoolean;
    validate();
    this.dayPanel.validate();
  }
  
  public JPanel getDayPanel() {
    return this.dayPanel;
  }
  
  public Color getDecorationBackgroundColor() {
    return this.decorationBackgroundColor;
  }
  
  public void setDecorationBackgroundColor(Color paramColor) {
    this.decorationBackgroundColor = paramColor;
    if (this.days != null)
      for (byte b = 0; b < 7; b++)
        this.days[b].setBackground(paramColor);  
    if (this.weeks != null)
      for (byte b = 0; b < 7; b++)
        this.weeks[b].setBackground(paramColor);  
  }
  
  public Color getSundayForeground() {
    return this.sundayForeground;
  }
  
  public Color getWeekdayForeground() {
    return this.weekdayForeground;
  }
  
  public void setSundayForeground(Color paramColor) {
    this.sundayForeground = paramColor;
    drawDayNames();
    drawDays();
  }
  
  public void setWeekdayForeground(Color paramColor) {
    this.weekdayForeground = paramColor;
    drawDayNames();
    drawDays();
  }
  
  public void setFocus() {
    if (this.selectedDay != null)
      this.selectedDay.requestFocus(); 
  }
  
  public boolean isDecorationBackgroundVisible() {
    return this.decorationBackgroundVisible;
  }
  
  public void addActivityDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

    for (int i = 7; i < 49; i++) {
  String buttonText = days[i].getText();
  if (!buttonText.isEmpty() && Integer.parseInt(buttonText) == dayOfMonth) {
    days[i].setBackground(activityDay);
    days[i].repaint();
    break;
  }
}
  }
  
  public void setDecorationBackgroundVisible(boolean paramBoolean) {
    this.decorationBackgroundVisible = paramBoolean;
    initDecorations();
  }
  
  public boolean isDecorationBordersVisible() {
    return this.decorationBordersVisible;
  }
  
  public boolean isDayBordersVisible() {
    return this.dayBordersVisible;
  }
  
  public void setDecorationBordersVisible(boolean paramBoolean) {
    this.decorationBordersVisible = paramBoolean;
    initDecorations();
  }
  
  public void setDayBordersVisible(boolean paramBoolean) {
    this.dayBordersVisible = paramBoolean;
    if (this.initialized)
      for (byte b = 7; b < 49; b++) {
        if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
          this.days[b].setContentAreaFilled(paramBoolean);
        } else {
          this.days[b].setContentAreaFilled(true);
        } 
        this.days[b].setBorderPainted(paramBoolean);
      }  
  }
  
  public void updateUI() {
    super.updateUI();
    setFont(Font.decode("Dialog Plain 11"));
    if (this.weekPanel != null)
      this.weekPanel.updateUI(); 
    if (this.initialized)
      if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
        setDayBordersVisible(false);
        setDecorationBackgroundVisible(true);
        setDecorationBordersVisible(false);
      } else {
        setDayBordersVisible(true);
        setDecorationBackgroundVisible(this.decorationBackgroundVisible);
        setDecorationBordersVisible(this.decorationBordersVisible);
      }  
  }
  
  public void setSelectableDateRange(Date paramDate1, Date paramDate2) {
    this.minMaxDateEvaluator.setMaxSelectableDate(paramDate2);
    this.minMaxDateEvaluator.setMinSelectableDate(paramDate1);
    drawDays();
  }
  
  public Date setMaxSelectableDate(Date paramDate) {
    Date date = this.minMaxDateEvaluator.setMaxSelectableDate(paramDate);
    drawDays();
    return date;
  }
  
  public Date setMinSelectableDate(Date paramDate) {
    Date date = this.minMaxDateEvaluator.setMinSelectableDate(paramDate);
    drawDays();
    return date;
  }
  
  public Date getMaxSelectableDate() {
    return this.minMaxDateEvaluator.getMaxSelectableDate();
  }
  
  public Date getMinSelectableDate() {
    return this.minMaxDateEvaluator.getMinSelectableDate();
  }
  
  public int getMaxDayCharacters() {
    return this.maxDayCharacters;
  }
  
  public void setMaxDayCharacters(int paramInt) {
    if (paramInt == this.maxDayCharacters)
      return; 
    if (paramInt < 0 || paramInt > 4) {
      this.maxDayCharacters = 0;
    } else {
      this.maxDayCharacters = paramInt;
    } 
    drawDayNames();
    drawDays();
    invalidate();
  }
  
  public static void main(String[] paramArrayOfString) {
    JFrame jFrame = new JFrame("JDayChooser");
    jFrame.getContentPane().add(new JDayChooser());
    jFrame.pack();
    jFrame.setVisible(true);
  }
  
  public void addDateEvaluator(IDateEvaluator paramIDateEvaluator) {
    this.dateEvaluators.add(paramIDateEvaluator);
  }
  
  public void removeDateEvaluator(IDateEvaluator paramIDateEvaluator) {
    this.dateEvaluators.remove(paramIDateEvaluator);
  }
  
  class DecoratorButton extends JButton {
    private static final long serialVersionUID = -5306477668406547496L;
    
    private final JDayChooser this$0 = null;
    
    public DecoratorButton() {
      setBackground(CustomDay.this.decorationBackgroundColor);
      setContentAreaFilled(CustomDay.this.decorationBackgroundVisible);
      setBorderPainted(CustomDay.this.decorationBordersVisible);
    }
    
    public void addMouseListener(MouseListener param1MouseListener) {}
    
    public boolean isFocusable() {
      return false;
    }
    
    
    
    public void paint(Graphics param1Graphics) {
      if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
        if (CustomDay.this.decorationBackgroundVisible) {
          param1Graphics.setColor(CustomDay.this.decorationBackgroundColor);
        } else {
          param1Graphics.setColor(CustomDay.this.days[7].getBackground());
        } 
        param1Graphics.fillRect(0, 0, getWidth(), getHeight());
        if (isBorderPainted()) {
          setContentAreaFilled(true);
        } else {
          setContentAreaFilled(false);
        } 
      } 
      super.paint(param1Graphics);
    }
  }
}
