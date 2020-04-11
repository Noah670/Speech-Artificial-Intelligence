import com.sun.speech.freetts.VoiceManager;
//import com.sun.speech.freetts.Voice;

import com.sun.speech.freetts.Gender;


public class Voice {



    private String name; // name of voice to use

    private com.sun.speech.freetts.Voice voice; // empty instance of voice class inside sun.speech

    public Voice(String name) {

        // set default voice for kevin
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");


        this.name = name;

        this.voice = VoiceManager.getInstance().getVoice(this.name); // gets the voice to the "name" variable

        this.voice.allocate();

    }


    public void say(String something) {
        this.voice.speak(something);

    }

    public void sayMultipleLines(String[] multipleLines){

        for(int i = 0; i < multipleLines.length; i++){

            this.say(multipleLines[i]);

        }


    }


}


