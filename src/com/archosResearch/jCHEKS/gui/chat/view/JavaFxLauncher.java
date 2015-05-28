package com.archosResearch.jCHEKS.gui.chat.view;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class JavaFxLauncher {
    public JavaFxLauncher(){
        new Thread(){
            @Override
            public void run(){
                javafx.application.Application.launch(ChatController.class);
             }
        }.start();
    }
}

