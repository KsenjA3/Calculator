package face;

import fitting.MyFonts;
import fitting.MySizePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculateFace extends JFrame {

    /**
     * Components
     */
    private JFrame frame;
    private CardLayout cardTypeCalc;
    private JPanel cardPanel;
    private PanelKeyBasic keyPanelBasic;
    private PanelKeyEngineer keyPanelEngineer;
    private PanelKeyIT keyPanelIT;
    private PanelTextLog textPanel;

    /**
     * MENU
     */
    private JMenuBar jmb;
    private JPopupMenu jpu;
    private JCheckBoxMenuItem jchbLog;
    private JMenuItem jmiShowLogPopup, jmiHideLogPopup, jmiClearLogPopup, jmiCopyLogPopup,
            jmiClearLog, jmiCopyLog;
    private MakeMenuItem actionCopy, actionPaste, actionClearLog, actionCopyLog;
    int widthSize, hieghtSize;


    public CalculateFace () {
            //create frame
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame();
        frame.setTitle("КАЛЬКУЛЯТОР");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //create Content Pane
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        frame.add(Box.createVerticalGlue());
        frame.setContentPane(container);

            // create Panels
        textPanel = new PanelTextLog();
        keyPanelBasic = new PanelKeyBasic(textPanel);
        keyPanelEngineer = new PanelKeyEngineer(textPanel);
        keyPanelIT= new PanelKeyIT(textPanel);


        cardTypeCalc = new CardLayout();            //компоновка
        cardPanel = new JPanel(new CardLayout());   //колода
        cardPanel.setLayout(cardTypeCalc);          //компоновка колоды
            cardPanel.add(keyPanelBasic.getKeyPanel(), "Basic");
            cardPanel.add(keyPanelEngineer.getKeyPanel(),"Engineer");
            cardPanel.add(keyPanelIT.getKeyPanel(),"IT");

          new KeyboardInput(textPanel);


        container.add(textPanel.getTextPanel(widthSize));
        container.add(cardPanel);
        
        //MENU
        jmb = new JMenuBar();
        makeViewMenu();
        makeCorrectMenu();
        makeBriefMenu();
        frame.setJMenuBar(jmb);

        //make and set PopupMenu
        makePopupMenu();
        mouseListenerPopupMenu(textPanel.getTextLog(),textPanel.getTextInput(),textPanel.getTextResult());


        /*
         INITIAL calculation
         chose card to init calculator
         widthSizeText = width frame and other components
         setting height textPanel (height keyPanel = const)
         */
        cardTypeCalc.show(cardPanel, "Basic");
        widthSize=keyPanelBasic.getWidthKeyPanel();
        repack();
        frame.setVisible(true);
    }

//MENU
    /**
     * behavior MenuItem
     */
    class MakeMenuItem extends AbstractAction {
        MakeMenuItem(String name, KeyStroke accel) {
            super(name);
            putValue(ACCELERATOR_KEY, accel);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Обычный" -> {
                    if (textPanel.getTextResult().equals("0.0")) {
                        textPanel.setTextInput(" ");
                    }else {
                        textPanel.setTextInput(textPanel.getTextInput().getText());
                        textPanel.setTextResult(textPanel.getTextResult().getText());
                    }
                    cardTypeCalc.show(cardPanel, "Basic");
                    widthSize=keyPanelBasic.getWidthKeyPanel();
                    repack();
                }
                case "Инженерный" -> {
                    if (textPanel.getTextResult().equals("0.0")) {
                        textPanel.setTextInput(" ");
                    }else {
                        textPanel.setTextInput(textPanel.getTextInput().getText());
                        textPanel.setTextResult(textPanel.getTextResult().getText());
                    }
                    cardTypeCalc.show(cardPanel, "Engineer");
                    widthSize = keyPanelEngineer.getWidthKeyPanel();
                    repack();
                }
                case "IT" -> {
                    if (textPanel.getTextResult().equals("0.0")) {
                        textPanel.setTextInput(" ");
                    }else {
                        textPanel.setTextInput(textPanel.getTextInput().getText());
                        textPanel.setTextResult(textPanel.getTextResult().getText());
                    }
                    cardTypeCalc.show(cardPanel, "IT");
                    widthSize = keyPanelIT.getWidthKeyPanel();
                    repack();
                }
                case "Копировать" -> {

                }
                case "Вставить" -> {

                }
                case "Очистить журнал" -> {

                }
                case "Копировать журнал" -> {

                }
                case "Числовые разряды" -> {

                }
                case "Посмотреть справку" -> {

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

            if(jchbLog.isSelected()) {
                jmiClearLog.setEnabled(true);
                jmiCopyLog.setEnabled(true);
                jmiShowLogPopup.setVisible(false);
                jmiHideLogPopup.setVisible(true);
                jmiClearLogPopup.setVisible(true);
                jmiCopyLogPopup.setVisible(true);

                textPanel.getScrollLog().setVisible(true);
                repack();
            } else{
                jmiClearLog.setEnabled(false);
                jmiCopyLog.setEnabled(false);
                jmiShowLogPopup.setVisible(true);
                jmiHideLogPopup.setVisible(false);
                jmiClearLogPopup.setVisible(false);
                jmiCopyLogPopup.setVisible(false);

                textPanel.getScrollLog().setVisible(false);
                repack();
            }
        }
    }

    /**
     * make View Menu
     */
    private void makeViewMenu() {
        JMenu jmView = new JMenu("Вид");
        jmView.setFont(MyFonts.FONT_MENU.get());

        MakeMenuItem actionSimple = new MakeMenuItem("Обычный", KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_DOWN_MASK));
        JRadioButtonMenuItem jmiSimple = new JRadioButtonMenuItem(actionSimple);
        jmiSimple.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmiSimple.setSelected(true);
        jmView.add(jmiSimple);

        MakeMenuItem actionEngineer = new MakeMenuItem("Инженерный", KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.ALT_DOWN_MASK));
        JRadioButtonMenuItem jmiEngineer = new JRadioButtonMenuItem(actionEngineer);
        jmiEngineer.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmView.add(jmiEngineer);

        MakeMenuItem actionIT = new MakeMenuItem("IT", KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.ALT_DOWN_MASK));
        JRadioButtonMenuItem jmiIT = new JRadioButtonMenuItem(actionIT);
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

        var jchbGroupDigit = new JCheckBoxMenuItem("Числовые разряды");
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

        actionCopy = new MakeMenuItem("Копировать", KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        var jmiCopy = new JMenuItem(actionCopy);
        jmiCopy.setFont(MyFonts.FONT_MENU_ITEM.get());
        jmCorrect.add(jmiCopy);

        actionPaste = new MakeMenuItem("Вставить", KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
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
        actionCopyLog = new MakeMenuItem("Копировать журнал", KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
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
        hieghtSize = textPanel.setVisibleTextPanelLog (jchbLog.isSelected(), frame, widthSize)
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
}
