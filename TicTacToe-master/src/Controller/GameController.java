package Controller;

import Modell.GameModell;
import View.View;
import sun.invoke.empty.Empty;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private View view;
    private GameModell modell;

    public GameController() {
        view = new View();
        modell = new GameModell();
        view.setGameListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("start")) {
            view.getjLabel4().setText("Spiel läuft");
            view.getStatusOPanel().setBackground(Color.RED);
            view.getStatusXPanel().setBackground(Color.GREEN);
            view.getStatusXPanel().setVisible(true);
            view.getStatusOPanel().setVisible(true);
            view.getSpielernameO().setText(view.gettNameO().getText());
            view.getSpielernameX().setText(view.gettNameX().getText());
            System.out.println(view.gettNameX().getText());
            System.out.println("Spiel läuft");
            view.getBtnStart().setEnabled(false);
            if (e.getActionCommand().equals("P2"))
            modell.newGame();

        }
        if (e.getActionCommand().equals("abbruch")) {
            view.getjLabel4().setText("");
            view.getjLabel4().setText("Spiel wurde Abgebrochen");
            modell.stoppgame();

        }
        if (e.getActionCommand().equals("reset")) {
            //view.getjLabel4().setText("");
            //view.getjLabel4().setText(view.gettNameO().getText()+" Hat gewonnen");
            view.getjLabel4().setText("");
            view.getBtnStart().setEnabled(true);
            view.getStatusXPanel().setVisible(false);
            view.getStatusOPanel().setVisible(false);
            view.gettNameO().setText("");
            view.gettNameX().setText("");
            view.getStatusSiegeO().setText("");
            view.getStatusSiegeX().setText("");


        }







    }
    public void gameEnded(char c) {
        String textmessage = c == 'D' ? "Spiel Beendet. Draw" : "Spiel Beendet. " + c + " hat  gewonnen";
    }


}
