package org.example.face;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.jackson.Log4jJsonObjectMapper;
import org.example.fitting.MyFonts;
import org.example.fitting.MyFormatNumbers;
import org.example.fitting.MySizePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

@Log4j2
public class CalculateFace extends JFrame {
    private String format;
    private String stRes;

    /**Components
     *
     */
    private final  JFrame frame;
    private final CardLayout cardTypeCalc;
    private final JPanel cardPanel;
    private final PanelKeyBasic keyPanelBasic;
    private final PanelKeyEngineer keyPanelEngineer;
    private final PanelKeyIT keyPanelIT;
    private final PanelTextLog textPanel;

    /**MENU
     *
     */
    private final JMenuBar jmb;
    private JPopupMenu jpu;
    private JCheckBoxMenuItem jchbLog;
    private JMenuItem jmiShowLogPopup, jmiHideLogPopup, jmiClearLogPopup, jmiCopyLogPopup,
            jmiClearLog, jmiCopyLog;
    private JRadioButtonMenuItem jmiSimple,jmiEngineer,jmiIT;
    private JCheckBoxMenuItem jchbGroupDigit;
    private MakeMenuItem actionCopy, actionPaste, actionClearLog, actionCopyLog;
    int widthSize, highSize;
    String  nameKeyPanel;
    File file;



    public CalculateFace () {

        /**create frame

         */
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame();
        frame.setTitle("КАЛЬКУЛЯТОР");
        file=new File("src/test/resources/calculateFaceData.json");

        /**serialize when windowClosing
 *
  */
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                try (var fileOut =new FileOutputStream("calculator.dat");
                     var out = new ObjectOutputStream (fileOut)
                ){
                    switch (nameKeyPanel){
                        case "Basic", "Engineer" -> {
                            format=MyFormatNumbers.FORMAT_DOUBLE.get();
                        }
                        case "IT"->{
                            format=keyPanelIT.buttonsIT.calculateCurrent.getFormat();
                        }
                    }


                    CalculateFaceData cfData =CalculateFaceData.builder()
                        .x(frame.getLocation().x)
                        .y(frame.getLocation().y)
                        .nameKeyPanel( nameKeyPanel)
                        .panelLog_isOpen( jchbLog.isSelected())
                        .textLog (textPanel.getTextLog().getText())
                        .textInput(textPanel.getTextInput().getText())
                        .textResult (textPanel.getTextResult().getText())
                        .formatNumber(format)
                        .build();

                    log.info(nameKeyPanel);
                    log.info(jchbLog.isSelected());
                    log.info(cfData.textInput);
                    log.info(cfData.textResult);

                    out.writeObject(cfData);

                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.writeValue(file,cfData);

                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                setVisible(false);
                dispose();
                System.exit(0); //calling the method is a must
            }
        });

        /**create Content Pane
         *
         */
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        frame.add(Box.createVerticalGlue());
        frame.setContentPane(container);

        /**create Panels
         *
          */
        textPanel = new PanelTextLog();
        new KeyboardInput(textPanel);

        keyPanelBasic = new PanelKeyBasic(textPanel);
            keyPanelBasic.setName("Basic");
        keyPanelEngineer = new PanelKeyEngineer(textPanel);
            keyPanelEngineer.setName("Engineer");
        keyPanelIT= new PanelKeyIT(textPanel);
            keyPanelIT.setName("IT");

        cardTypeCalc = new CardLayout();            //компоновка
        cardPanel = new JPanel();   //колода
        cardPanel.setLayout(cardTypeCalc);          //компоновка колоды
            cardPanel.add(keyPanelBasic.getKeyPanel(), keyPanelBasic.getName());
            cardPanel.add(keyPanelEngineer.getKeyPanel(),keyPanelEngineer.getName());
            cardPanel.add(keyPanelIT.getKeyPanel(),keyPanelIT.getName());
        container.add(textPanel.getTextPanel(widthSize));
        container.add(cardPanel);

        /**MENU
         *
         */
        jmb = new JMenuBar();
        makeViewMenu();
        makeCorrectMenu();
        makeBriefMenu();
        frame.setJMenuBar(jmb);

        //make and set PopupMenu
        makePopupMenu();
        mouseListenerPopupMenu(textPanel.getTextLog(),textPanel.getTextInput(),textPanel.getTextResult());


        /** INITIAL calculation
         chose card to init calculator
         widthSizeText = width frame and other components
         setting height textPanel (height keyPanel = const)
         */
        try (var fileIn =new FileInputStream("calculator.dat");
             var in = new ObjectInputStream (fileIn))
        {
//            CalculateFaceData cfData = (CalculateFaceData) in.readObject();
            ObjectMapper objectMapper = new ObjectMapper();
            CalculateFaceData cfData = objectMapper.readValue(file, CalculateFaceData.class);

//            frame.setLocation(100,100);
            frame.setLocation(cfData.x,cfData.y);
            cardTypeCalc.show(cardPanel, cfData.nameKeyPanel);
            nameKeyPanel=cfData.nameKeyPanel;
            switch (nameKeyPanel){
                case "Basic"-> {
                    widthSize=keyPanelBasic.getWidthKeyPanel();
                    jmiSimple.setSelected(true);
                    format=MyFormatNumbers.FORMAT_DOUBLE.get();
                }
                case "Engineer"-> {
                    widthSize=keyPanelEngineer.getWidthKeyPanel();
                    jmiEngineer.setSelected(true);
                    format=MyFormatNumbers.FORMAT_DOUBLE.get();
                }
                case "IT"->{
                    widthSize=keyPanelIT.getWidthKeyPanel();
                    jmiIT.setSelected(true);

                    format=cfData.formatNumber;
                    switch(format){
                        case "hex"-> {
                            keyPanelIT.buttonsIT.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_HEX.get());
                            keyPanelIT.bHex.setSelected(true);
                        }
                        case "dec"->{
                            keyPanelIT.buttonsIT.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_DEC.get());
                            keyPanelIT.bDec.setSelected(true);
                        }
                        case "bin"->{
                            keyPanelIT.buttonsIT.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_BIN.get());
                            keyPanelIT.bBin.setSelected(true);
                        }
                    }
                }
            }

            if (cfData.panelLog_isOpen){
                jchbLog.setSelected(true);
            }else{
                jchbLog.setSelected(false);
            }
            panelLog_isShown();

            textPanel.getSbLog().append(cfData.textLog);
            textPanel.setTextLog(format,cfData.textLog);
            textPanel.getTextInput().setText(cfData.textInput);
            textPanel.getTextResult().setText(cfData.textResult);
        }
        catch (NullPointerException nullPointerException) {
            frame.setLocation(100,100);
            cardTypeCalc.show(cardPanel,  "Basic");
            widthSize=keyPanelBasic.getWidthKeyPanel();
            nullPointerException.printStackTrace();
        }
        catch (Exception exception) {
            frame.setLocation(100,100);
            cardTypeCalc.show(cardPanel,  "Basic");
            widthSize=keyPanelBasic.getWidthKeyPanel();
            exception.printStackTrace();}
        repack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

//MENU
    /**
     * behavior MenuItem
     */
    class MakeMenuItem extends AbstractAction {
        MakeMenuItem(String name) {
            super(name);
        }

        MakeMenuItem(String name, KeyStroke accel) {
            super(name);
            putValue(ACCELERATOR_KEY, accel);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Простой" -> {
                    format= keyPanelBasic.buttonsBasic.calculateCurrent.getFormat();
                    if (textPanel.getTextResult().equals("0.0")) {
                        textPanel.setTextInput(format, " ");
                    }else {
                        textPanel.setTextInput(format,textPanel.getTextInput().getText());
                        textPanel.setTextResult(format,textPanel.getTextResult().getText());
                    }

                    keyPanelBasic.buttonsBasic.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_DOUBLE.get());
                    cardTypeCalc.show(cardPanel, keyPanelBasic.getName());
                    widthSize=keyPanelBasic.getWidthKeyPanel();
                    nameKeyPanel=keyPanelBasic.getName();
                    repack();
                }
                case "Инженерный" -> {
                    format= keyPanelEngineer.buttonsEngineer.calculateCurrent.getFormat();
                    if (textPanel.getTextResult().equals("0.0")) {
                        textPanel.setTextInput(format, " ");
                    }else {
                        textPanel.setTextInput(format, textPanel.getTextInput().getText());
                        textPanel.setTextResult(format, textPanel.getTextResult().getText());
                    }

                    keyPanelEngineer.buttonsEngineer.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_DOUBLE.get());
                    cardTypeCalc.show(cardPanel, keyPanelEngineer.getName());
                    widthSize = keyPanelEngineer.getWidthKeyPanel();
                    nameKeyPanel=keyPanelEngineer.getName();
                    repack();
                }
                case "IT" -> {
                    format= keyPanelIT.buttonsIT.calculateCurrent.getFormat();
                    textPanel.setTextInput(format,"   ");
                    textPanel.setTextResult(format,"   ");

                    keyPanelIT.bDec.setSelected(true);

                    keyPanelIT.buttonsIT.blockedAll(
                                keyPanelIT.listButtons.get(".")
                            ,keyPanelIT.listButtons.get("AA"), keyPanelIT.listButtons.get("BB"),keyPanelIT.listButtons.get("CC")
                            ,keyPanelIT.listButtons.get("DD"), keyPanelIT.listButtons.get("EE"), keyPanelIT.listButtons.get("FF")

                    );
                    keyPanelIT.buttonsIT.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_DEC.get());
                    cardTypeCalc.show(cardPanel, keyPanelIT.getName());
                    widthSize = keyPanelIT.getWidthKeyPanel();
                    nameKeyPanel=keyPanelIT.getName();
                    keyPanelIT.buttonsIT.N=0;                   // length number after shift keyPanel
                    repack();
                }
                case "Копировать" -> {
                    stRes=textPanel.getTextResult().getText().substring(1);
                    copy_toSystem( stRes);
                }
                case "Вставить" -> {
                    if (jmiSimple.isSelected()){
                        textPanel.setTextInput(keyPanelBasic.buttonsBasic.calculateCurrent.getFormat(),stRes);
                        textPanel.setTextResult(keyPanelBasic.buttonsBasic.calculateCurrent.getFormat(),"="+stRes);
                    } else if (jmiEngineer.isSelected()) {
                        textPanel.setTextInput(keyPanelEngineer.buttonsEngineer.calculateCurrent.getFormat(),stRes);
                        textPanel.setTextResult(keyPanelEngineer.buttonsEngineer.calculateCurrent.getFormat(),"="+stRes);
                    } else if (jmiIT.isSelected()) {
                        textPanel.setTextInput(keyPanelIT.buttonsIT.calculateCurrent.getFormat(),stRes);
                        textPanel.setTextResult(keyPanelIT.buttonsIT.calculateCurrent.getFormat(),"="+stRes);
                    }
                }
                case "Очистить журнал" -> {
                    textPanel.getSbLog().delete(0,textPanel.getSbLog().length());
                    textPanel.setTextLog(format, new String());
                }
                case "Копировать журнал" -> {
                    String strLog=textPanel.getTextLog().getText();
                    copy_toSystem( strLog);
                }
                case "Числовые разряды" -> {
                    textPanel.setDigitNumber(jchbGroupDigit.isSelected());
                    if (jmiSimple.isSelected()){
                        textPanel.setTextLog(keyPanelBasic.buttonsBasic.calculateCurrent.getFormat(), textPanel.getTextLog().getText());
                        textPanel.setTextInput(keyPanelBasic.buttonsBasic.calculateCurrent.getFormat(),textPanel.getTextInput().getText());
                        textPanel.setTextResult(keyPanelBasic.buttonsBasic.calculateCurrent.getFormat(),textPanel.getTextResult().getText());
                    } else if (jmiEngineer.isSelected()) {
                        textPanel.setTextLog(keyPanelEngineer.buttonsEngineer.calculateCurrent.getFormat(), textPanel.getTextLog().getText());
                        textPanel.setTextInput(keyPanelEngineer.buttonsEngineer.calculateCurrent.getFormat(),textPanel.getTextInput().getText());
                        textPanel.setTextResult(keyPanelEngineer.buttonsEngineer.calculateCurrent.getFormat(),textPanel.getTextResult().getText());
                    } else if (jmiIT.isSelected()) {
                        textPanel.setTextLog(keyPanelIT.buttonsIT.calculateCurrent.getFormat(), textPanel.getTextLog().getText());
                        textPanel.setTextInput(keyPanelIT.buttonsIT.calculateCurrent.getFormat(),textPanel.getTextInput().getText());
                        textPanel.setTextResult(keyPanelIT.buttonsIT.calculateCurrent.getFormat(),textPanel.getTextResult().getText());
                    }
                }
                case "Посмотреть справку"->{
                    try {
                        Desktop.getDesktop().browse(new URI("Brief.html"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        }
    }

    /**
     * behavior log MenuItem
     */
    class MakeLogMenuItem extends AbstractAction {
        MakeLogMenuItem(String name, KeyStroke accel) {
            super(name);
            putValue(ACCELERATOR_KEY, accel);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Показать журнал" -> jchbLog.setSelected(true);
                case "Скрыть журнал" -> jchbLog.setSelected(false);

            }
            panelLog_isShown();
            repack();
        }
    }


    /**
     * make View Menu
     */
    private void makeViewMenu() {
        JMenu jmView = new JMenu("Вид");
        jmView.setFont(MyFonts.FONT_MENU.get());

        MakeMenuItem actionSimple = new MakeMenuItem("Простой", KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_DOWN_MASK));
        jmiSimple = new JRadioButtonMenuItem(actionSimple);
        jmiSimple.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmiSimple.setSelected(true);
        jmView.add(jmiSimple);

        MakeMenuItem actionEngineer = new MakeMenuItem("Инженерный", KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.ALT_DOWN_MASK));
        jmiEngineer = new JRadioButtonMenuItem(actionEngineer);
        jmiEngineer.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmView.add(jmiEngineer);

        MakeMenuItem actionIT = new MakeMenuItem("IT", KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.ALT_DOWN_MASK));
        jmiIT = new JRadioButtonMenuItem(actionIT);
        jmiIT.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmView.add(jmiIT);
        jmView.addSeparator();

        var bg = new ButtonGroup();
        bg.add(jmiSimple);
        bg.add(jmiEngineer);
        bg.add(jmiIT);


        MakeLogMenuItem actionLog = new MakeLogMenuItem("Журнал", KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_DOWN_MASK));
        jchbLog = new JCheckBoxMenuItem(actionLog);
        jchbLog.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmView.add(jchbLog);

        MakeMenuItem actionDigit = new MakeMenuItem("Числовые разряды");
        jchbGroupDigit = new JCheckBoxMenuItem(actionDigit);
        jchbGroupDigit.setFont(MyFonts.FONT_MENU_ITEM.get());
        jchbGroupDigit.setToolTipText("Группировка цифр по разрядам");
        jmView.add(jchbGroupDigit);

        jmb.add(jmView);
    }

    /**
     * make Correct Menu
     */
    private void makeCorrectMenu() {
        JMenu jmCorrect = new JMenu("Правка");
        jmCorrect.setFont(MyFonts.FONT_MENU.get());

        actionCopy = new MakeMenuItem("Копировать", KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
        var jmiCopy = new JMenuItem(actionCopy);
        jmiCopy.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmCorrect.add(jmiCopy);

        actionPaste = new MakeMenuItem("Вставить", KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_DOWN_MASK));
        var jmiPaste = new JMenuItem(actionPaste);
        jmiPaste.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmCorrect.add(jmiPaste);
        jmCorrect.addSeparator();

        var jmiLog = new JMenu("Журнал");
        jmiLog.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmCorrect.add(jmiLog);

        actionClearLog = new MakeMenuItem("Очистить журнал", KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, InputEvent.ALT_DOWN_MASK));
        jmiClearLog = new JMenuItem(actionClearLog);
        jmiClearLog.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmiLog.add(jmiClearLog) ;

        actionCopyLog = new MakeMenuItem("Копировать журнал", KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_DOWN_MASK));
        jmiCopyLog = new JMenuItem(actionCopyLog);
        jmiCopyLog.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmiLog.add(jmiCopyLog) ;

        jmb.add(jmCorrect);
    }

    /**
     * make Brief Menu
     */
    private void makeBriefMenu() {
        JMenu jmbrief = new JMenu("Справка");
        jmbrief.setFont(MyFonts.FONT_MENU.get());

        MakeMenuItem actionBrief = new MakeMenuItem("Посмотреть справку", KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        var jmiBrief = new JMenuItem(actionBrief);
        jmbrief.add(jmiBrief);
        jmiBrief.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmb.add(jmbrief);
    }

    /**
     * make Popup Menu
     */
    private void makePopupMenu() {
        jpu = new JPopupMenu(); 
        var jmiCopy = new JMenuItem(actionCopy);
        var jmiPaste = new JMenuItem(actionPaste);

        MakeLogMenuItem actionShowLogPopup = new MakeLogMenuItem("Показать журнал", KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
        jmiShowLogPopup = new JMenuItem(actionShowLogPopup);
        MakeLogMenuItem actionHideLogPopup = new MakeLogMenuItem("Скрыть журнал", KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_DOWN_MASK));
        jmiHideLogPopup = new JMenuItem(actionHideLogPopup);
        jmiClearLogPopup = new JMenuItem(actionClearLog);
        jmiCopyLogPopup = new JMenuItem(actionCopyLog);

        jpu.add (jmiCopy);
        jpu.add (jmiPaste);
        jpu.addSeparator();
        jpu.add (jmiShowLogPopup);
        jpu.add (jmiHideLogPopup);
        jpu.add (jmiClearLogPopup);
        jpu.add (jmiCopyLogPopup);
    }

    /**
     * mouseListener for PopupMenu
     * @param compVal list of components with PopupMenu
     */
    private void mouseListenerPopupMenu (JComponent ... compVal){
        for (JComponent comp :compVal) {
            comp.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if(e.isPopupTrigger())
                        jpu.show(e.getComponent(),e.getX(), e.getY());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if(e.isPopupTrigger())
                        jpu.show(e.getComponent(),e.getX(), e.getY());
                }
            });
        }

    }

    void repack() {
        highSize = textPanel.setVisibleTextPanelLog (jchbLog.isSelected(), frame, widthSize)
                + MySizePanel.HIEGHT_SIZE_KEY.get();
  //      frame.setPreferredSize(new Dimension(widthSize, hieghtSize));
        frame.pack();

        //focus necessary panel
        for (Component comp : cardPanel.getComponents()) {
            if (comp.isVisible()) {
                comp.requestFocusInWindow();
            }
        }
    }

    void panelLog_isShown() {
        if (jchbLog.isSelected()) {
            jmiClearLog.setEnabled(true);
            jmiCopyLog.setEnabled(true);
            jmiShowLogPopup.setVisible(false);
            jmiHideLogPopup.setVisible(true);
            jmiClearLogPopup.setVisible(true);
            jmiCopyLogPopup.setVisible(true);

            textPanel.getScrollLog().setVisible(true);
        } else {
            jmiClearLog.setEnabled(false);
            jmiCopyLog.setEnabled(false);
            jmiShowLogPopup.setVisible(true);
            jmiHideLogPopup.setVisible(false);
            jmiClearLogPopup.setVisible(false);
            jmiCopyLogPopup.setVisible(false);

            textPanel.getScrollLog().setVisible(false);
        }
    }

    void copy_toSystem(String strCopy){
        StringSelection stringSelection = new StringSelection (strCopy);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
    }

    void set_IT_formatNumber(String formatIT) {
        switch (formatIT){

        }
    }
}

