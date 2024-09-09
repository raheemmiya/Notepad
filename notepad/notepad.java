package notepad;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class notepad extends JFrame implements ActionListener {
    JTextArea textArea;

    JMenuItem newDocs;
    JMenuItem opendocs;
    JMenuItem savedocs;
    JMenuItem printDocs;
    JMenuItem exit;
    JMenuItem about;

    notepad() {
        this.setTitle("NotePad");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");
        JMenu help = new JMenu("Help");

        ImageIcon icon = new ImageIcon(getClass().getResource("wish-list.png"));
        Image icon2 = icon.getImage();
    
        this.setIconImage(icon2);
        menu.add(file);
        opendocs = new JMenuItem("Open");
        opendocs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        opendocs.addActionListener(this);

        newDocs = new JMenuItem("New");
        newDocs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newDocs.addActionListener(this);

        savedocs = new JMenuItem("Save");
        savedocs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        savedocs.addActionListener(this);

        exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_ESCAPE));
        exit.addActionListener(this);

        printDocs = new JMenuItem("Print");
        printDocs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        printDocs.addActionListener(this);

        file.add(opendocs);
        file.add(newDocs);
        file.add(savedocs);
        file.add(printDocs);
        file.add(exit);

        menu.add(edit);
        JMenuItem selectALL = new JMenuItem("Select All");
        selectALL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        JMenuItem copyall = new JMenuItem("Copy All");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        edit.add(selectALL);
        edit.add(paste);
        edit.add(copyall);

        menu.add(view);

        about = new JMenuItem("About");
        about.addActionListener(this);
        help.add(about);
        menu.add(help);
        this.setJMenuBar(menu);

        textArea = new JTextArea();
        textArea.setFont(new Font("Comic Sans", Font.PLAIN, 25));
        textArea.setLineWrap(true); // changes paragraph when the end of a line is meet
        textArea.setWrapStyleWord(true); // drops the whole word down if there is not enough space at the end of the
                                         // line wrap

        JScrollPane pane = new JScrollPane(textArea);
        pane.setBorder(BorderFactory.createEmptyBorder()); // removes the border of the scroll bar
        this.add(pane);

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newDocs) {
            textArea.setText("");
        } else if (e.getSource() == opendocs) {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("text files", "txt");
            chooser.addChoosableFileFilter(restrict); // restrict the only text file filter
            int actionTaken = chooser.showOpenDialog(this); // opens up the open dialogue

            if (actionTaken != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File file = chooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file)); // passing a reader type object in the
                textArea.read(reader, null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==savedocs){  
            JFileChooser saveAs = new JFileChooser();
            saveAs.setDialogTitle("Save a file bitch..!!");
            saveAs.setApproveButtonText("Save bitch..!");
            int actionTaken = saveAs.showOpenDialog(this); // opens up the open dialogue

            if (actionTaken != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File filename = new File(saveAs.getSelectedFile()+".txt");

            BufferedWriter outFile = null;
            try {   
                outFile = new BufferedWriter(new FileWriter(filename));
                textArea.write(outFile);                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==printDocs){
            try {
                textArea.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==exit){
            System.exit(0);  //it shuts any program immediately
        }else if(e.getSource()==about){
            new about();
        }

    }

    public static void main(String[] args) {
        new notepad();
    }

}