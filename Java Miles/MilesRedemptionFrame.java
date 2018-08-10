/********************************************************************* 
  *                                                                  *  
  *   MilesRedemptionFrame                                           *                                               
  *                                                                  *  
  *  Programmer: Jake Judisch                                        * 
  *              Franklin Adams                                      * 
  *              Edward Moon                                         * 
  *                                                                  *  
  *                                                                  *                            
  *                                                                  *  
  *  Purpose:   This is the workhorse of this assignment. It         *
  *             constructs a frames which contains many panes. But   *
  *             primarily the right and left panes, which operate    *
  *             more or less independently. The left pane uses       *
  *             gridlayout while the right one uses gridbag layout.  *
  *******************************************************************/  


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Container;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SpinnerListModel;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.lang.String;
import java.util.Arrays;

public class MilesRedemptionFrame extends JFrame
{
  private static final int FRAME_WIDTH = 900;
  private static final int FRAME_HEIGHT = 400;
  
  private JList jListCityNames;
  private MileRedeemer redeemer;
  
  
  //left panel Variables
  private JPanel framePanelFormatter;
  private JPanel leftPanel;
  private JPanel leftPanelTop;
  private JTextField textfieldNormalMiles;
  private JTextField textfieldSuperSaverMiles;
  private JTextField textfieldUpgradeCost;
  private JTextField textfieldSuperSaverDates;
  private JTextField textfieldFileName;
  private JScrollPane scrollPane;
  
  //right panel variables
  private JPanel rightPanel;
  private SpinnerModel rightSpinnerModel;
  private JSpinner rightSpinner;
  private JTextField textfieldEnterMiles;
  private JTextField textfieldRemainingMiles;
  private JButton redeemButton;
  private JTextArea textAreaTicketDisplay;
  private JSpinner spinnerMonthSelection ;
  private String textfieldEnterMilesSelection;
  
  
  // The constructor
  
  public MilesRedemptionFrame(MileRedeemer redeemer)
  {
    //Set the size of the frame using predefined variables
    setSize(FRAME_WIDTH, FRAME_HEIGHT);  
    this.redeemer = redeemer;
    
    
    //Create the TextArea for the city names to display
    //jListCityNames = new JList(arrStr);
    
    framePanelFormatter = new JPanel(new GridLayout(1,2));
    
    //Creates panel and components within
    leftPanel = makeLeftPanel(redeemer.getCityNames());
    framePanelFormatter.add(leftPanel);
    
    //Creates panel and components within
    rightPanel = makeRightPanel();
    framePanelFormatter.add(rightPanel);
    
    //
    add(framePanelFormatter);
    
  }
  
  private JPanel makeLeftPanel(String[] arrStr)
  {
    //Create the left panel background color
    Color leftPanelBackgroundColor = new Color(100,150,100); 
    
    //Create the panel to hold components
    leftPanelTop = new JPanel(new GridLayout(2,1));
    //JPanel panel = new JPanel();
    
    JPanel leftPanelBottom = new JPanel(new GridLayout(4,4));
    
    //Create the labesl for components
    JLabel labelNormalMiles = new JLabel    ("Normal Miles    ");
    JLabel labelSuperSaverMiles = new JLabel("SuperSaver Miles");
    JLabel labelUpgradeCost = new JLabel    ("Upgrade Cost    ");
    JLabel labelSuperSaverDates = new JLabel("SuperSaver Dates");
    JLabel labelFileName = new JLabel();
    
    //panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    //Create the Textfield for the left panel
    textfieldNormalMiles = new JTextField("");
    textfieldSuperSaverMiles = new JTextField("");
    textfieldUpgradeCost = new JTextField("");
    textfieldSuperSaverDates = new JTextField("");
    textfieldFileName= new JTextField("");
    
    //Create the Button
    //JButton buttonFileName = new JButton("Update");
    
    //Create the title for the panel/JFrame
    TitledBorder border = BorderFactory.createTitledBorder("Destinations"); //sets title
    border.setTitleJustification(TitledBorder.CENTER);  //Changes the justification to center
    leftPanelTop.setBackground(leftPanelBackgroundColor); //Changes the color of the background
    leftPanelBottom.setBackground(leftPanelBackgroundColor); //Changes the color of the background
    
    //Sets border with of panel with TitledBorder layout 
    leftPanelTop.setBorder(border);
    
    //Create the TextArea for the city names to display
    jListCityNames = new JList(arrStr);
    
    //jListCityNames.addListSelectionListener
    jListCityNames.addListSelectionListener(new ListSelectionListener()
                                              {
      @Override
      public void valueChanged(ListSelectionEvent e)
      {
        if(!e.getValueIsAdjusting())
        {
          updateDestinationInfo(redeemer.convertDestNameToDest(jListCityNames.getSelectedValue().toString()));
          //System.out.print(jListCityNames.getSelectedValue());
        }
      }
    });
    
    //Create the scrollPane with the textArea output
    scrollPane = new JScrollPane(jListCityNames);
    
    scrollPane.setPreferredSize(new Dimension(325,200));
    
    //Used to display the scrollPane on the panel
    //leftPanelTop.add(labelFileName);
    //leftPanelTop.add(textfieldFileName);
    //leftPanelTop.add(buttonFileName);
    leftPanelTop.add(scrollPane);
    
    //Adds the labels to the panel & textfields
    leftPanelBottom.add(labelNormalMiles);
    textfieldNormalMiles.setPreferredSize(new Dimension(20,20));
    textfieldNormalMiles.setEditable(false);
    leftPanelBottom.add(textfieldNormalMiles);
    
    leftPanelBottom.add(labelSuperSaverMiles);
    textfieldSuperSaverMiles.setPreferredSize(new Dimension(20,20));
    textfieldSuperSaverMiles.setEditable(false);
    leftPanelBottom.add(textfieldSuperSaverMiles);
    
    leftPanelBottom.add(labelUpgradeCost);
    textfieldUpgradeCost.setPreferredSize(new Dimension(20,20));
    textfieldUpgradeCost.setEditable(false);
    leftPanelBottom.add(textfieldUpgradeCost);
    
    leftPanelBottom.add(labelSuperSaverDates);
    textfieldSuperSaverDates.setPreferredSize(new Dimension(20,20));
    textfieldSuperSaverDates.setEditable(false);
    leftPanelBottom.add(textfieldSuperSaverDates);
    
    //Adds the panel to the frame
    
    add(leftPanelTop);
    leftPanelTop.add(leftPanelBottom);
    
    
    
    return leftPanelTop;
    
  }
  
  //Generates a array of months for the spinner
  protected String[] getMonthStrings()
  {
    String [] months = new java.text.DateFormatSymbols().getMonths();
    
    int lastIndex = months.length - 1; 
    
    if (months [lastIndex] == null || months[lastIndex].length() <= 0)
    {
      String[] monthStrings = new String[lastIndex];
      System.arraycopy(months, 0, monthStrings, 0, lastIndex);
      return monthStrings;
    }
    else
    {
      return months;
    }
  }
  
  //makes the right pane
  private JPanel makeRightPanel()
  {
    //Create background color for right side panel
    Color rightPanelBackgroundColor = new Color(100,100,150);
    rightSpinnerModel = new SpinnerListModel(getMonthStrings());
    
    //Create the panel to hold components
    rightPanel = new JPanel();
    
    //make labels for the panel
    JLabel labelEnterMiles  = new JLabel("Enter your miles ");
    JLabel labelSelectMonth = new JLabel("Select the month of departure ");
    JLabel labelRemainingMiles = new JLabel("Your remaining miles ");
    
    //declare the spinner
    rightSpinner = new JSpinner(rightSpinnerModel);
    spinnerMonthSelection = rightSpinner;
    
    
    //listen for the spinner to be used and save its results
    rightSpinner.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e)
      {
        spinnerMonthSelection = (JSpinner)e.getSource();
        //System.out.println("JSpinner " + spinnerMonthSelection.getValue());
        
      }
    });
    
    //textfield for miles entered
    textfieldEnterMiles = new JTextField(20);
    textfieldRemainingMiles = new JTextField(20);
    
    //Creating the button for redeeming miles
    redeemButton = new JButton("Redeem Miles");
    rightPanel.setLayout(new GridBagLayout());
    GridBagConstraints e = new GridBagConstraints();
    
    //TextArea
    textAreaTicketDisplay = new JTextArea(10,10);
    
    //Create the title for the panel/JFrame
    TitledBorder border = BorderFactory.createTitledBorder("Redeem Miles"); //sets title
    border.setTitleJustification(TitledBorder.CENTER);  //Changes the justification to center
    rightPanel.setBackground(rightPanelBackgroundColor); //Changes the color of the background
    
    //Sets border with of panel with TitledBorder layout 
    rightPanel.setBorder(border);
    
    //Adds the panel to the frame
    add(rightPanel);
    
    //textFieldEnteredMiles event listener
    textfieldEnterMiles.addActionListener(new ActionListener()
                                            {
      
      public void actionPerformed(ActionEvent e)
      {
        textfieldEnterMilesSelection = textfieldEnterMiles.getText();
        //System.out.println(textfieldEnterMilesSelection);
      }
    });
    
    
    //Add the textfield for Enter Miles
    e.fill = GridBagConstraints.BOTH;
    e.anchor = GridBagConstraints.CENTER;
    //c.gridwidth = 
    e.gridx = 0;
    e.gridy = 0;
    e.gridwidth = 1;
    rightPanel.add(labelEnterMiles);
    //textfieldEnterMiles.setPreferredSize(new Dimension(300,20));
    //c.fill = GridBagConstraints.BOTH;
    e.gridwidth = 1;
    e.gridx = 1;
    e.gridy = 0;
    rightPanel.add(textfieldEnterMiles , e);
    
    
    //Add the Spinner for months
    //c.anchor = GridBagConstraints.WEST;
    e.gridwidth = 1;
    e.gridx = 0;
    e.gridy = 1;
    rightPanel.add(labelSelectMonth , e);
    
    e.gridx = 1;
    e.gridy = 1;
    e.gridwidth = 1;
    rightPanel.add(rightSpinner,e);       
    
    //GridBag
    redeemButton = new JButton("Redeem Miles");
    
    //Button Listener
    redeemButton.addActionListener(new ActionListener()
                                     {
      public void actionPerformed(ActionEvent e)
      {
        //System.out.print("hello");
        
        viewRedeemedMiles(Integer.parseInt(textfieldEnterMiles.getText()), monthNameToInt((String)spinnerMonthSelection.getValue()));
      }});
    //c.anchor = GridBagConstraints.CENTER;
    e.gridwidth = 2;
    e.gridx = 0;
    e.gridy = 2;
    rightPanel.add(redeemButton, e);
    
    
    //Add the textarea 
    textAreaTicketDisplay.setEditable(false);
    //c.anchor = GridBagConstraints.CENTER;
    e.gridwidth = 2;
    e.gridx = 0;
    e.gridy = 3;
    rightPanel.add( textAreaTicketDisplay,e);
    
    //Add the remaing miles
    //c.anchor = GridBagConstraints.WEST;
    e.gridwidth = 1;
    e.gridx = 0;
    e.gridy = 4;
    rightPanel.add(labelRemainingMiles , e);
    //textfieldRemainingMiles.setPreferredSize(new Dimension(220,20));
    textfieldRemainingMiles.setEditable(false);
    e.gridx = 1;
    e.gridy = 4;
    e.gridwidth = 1;
    rightPanel.add(textfieldRemainingMiles,e);
    return rightPanel;
  }
  //returns a "month - month" based on a destination
  public String getMonthsAsWords(Destination dest)
  {
    String[] months = new String[]{"January" , "Febuary" , "March" , "April" , "May" , "June" , "July" , "August" , "September" , "October" , "Novemeber" , "December"};
    
    return months[dest.getStartMonth()-1] + " - " + months[dest.getEndMonth()-1];
  }
  
  //returns a "month - month" based on two month ints
  public String getMonthsAsWords(int startMonth, int endMonth)
  {
    String[] months = new String[]{"January" , "Febuary" , "March" , "April" , "May" , "June" , "July" , "August" , "September" , "October" , "Novemeber" , "December"};
    
    return months[startMonth-1] + " - " + months[endMonth-1];
  }
  
  //converts a the name of months to their integer representation
  private int monthNameToInt(String str)
  {
    String[] months = new String[]{"January" , "Febuary" , "March" , "April" , "May" , "June" , "July" , "August" , "September" , "October" , "Novemeber" , "December"};
    for(int i=0; i< 12; i++)
    {
      if(str == months[i])
      {
        return i + 1;
      }
    }
    return 0;
  }
  
  //updates the text fields below the left text area based on the user's selection
  private void updateDestinationInfo(Destination dest)
  {
    textfieldNormalMiles.setText(Integer.toString(dest.getMilesRequired()));
    textfieldSuperSaverMiles.setText(Integer.toString(dest.getSuperSaverMiles()));
    textfieldUpgradeCost.setText(Integer.toString(dest.getAdditionalMilesForUpgrade()));
    textfieldSuperSaverDates.setText(getMonthsAsWords(dest));
  }
  
  //update the right text field with the results of the redeemed mile combo
  private void viewRedeemedMiles(int miles, int month)
  {
    //System.out.println("miles: "+ miles);
    //System.out.println("months: " + month);
    String temp = "";
    for(String str: redeemer.redeemMiles(miles, month))
    {
      temp += str + "\n";
    }
    //System.out.println(temp);
    textAreaTicketDisplay.setText(temp);
    //textAreaTicketDisplay.setText("test");
    textfieldRemainingMiles.setText(Integer.toString(redeemer.getRemainingMiles()));
    
    
  }
}