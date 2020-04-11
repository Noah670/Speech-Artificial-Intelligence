import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextToSpeech implements ActionListener {
    JFrame frame;
    JTextArea textArea = new JTextArea();
    JButton speakButton = new JButton("Speak");
    JButton clearButton = new JButton("Clear");

    TextToSpeech() {
        prepareGUI();
        addComponents();
        addActionEvents();
    }

    public void prepareGUI() {
        frame = new JFrame();
        frame.setTitle("Text to Speech");
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponents() {
        textArea.setBounds(20, 40, 300, 150);
        textArea.setFont(new Font("Arial", Font.BOLD, 20));
        textArea.setBackground(new Color(229, 199, 229));
        textArea.setForeground(Color.black);
        frame.add(textArea);

        speakButton.setBounds(70, 220, 100, 30);
        speakButton.setBackground(new Color(244, 101, 65));
        speakButton.setForeground(Color.black);
        speakButton.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(speakButton);

        clearButton.setBounds(180, 220, 100, 30);
        clearButton.setBackground(new Color(244, 101, 65));
        clearButton.setForeground(Color.black);
        clearButton.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(clearButton);
    }

    public void addActionEvents() {
        speakButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            textArea.setText("");
        }
        if (e.getSource() == speakButton) {
            Voice voice;
            voice = VoiceManager.getInstance().getVoice("kevin");
            if (voice != null) {
                voice.allocate();
            }
            try {
                voice.setRate(190);
                voice.setPitch(150);
                voice.setVolume(3);
                voice.speak(textArea.getText());


            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }

    }
}
