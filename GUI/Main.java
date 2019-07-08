package GUI;

import BackupHelper.Schedule;
import Save.Config;
import Save.Log;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

    private Button bt1;
    private Button bt2;

    private Label  lb1;
    public static Label  lb2;

    public static void main(String[] args) {
        Schedule s =new Schedule(Config.getPfad(),Config.getTarget());
        Log.w("Start Application");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AcronisBackupHelper");

        bt1=new Button();
        bt1.setText("Stunden bis Check");
        bt1.setLayoutX(0);
        bt1.setLayoutY(10);
        bt1.resize(60,60);
        bt1.setOnAction(e->{
            lb1.setText(new Integer(Schedule.getHoursUntilTarget(23)).toString()+"Stunden");
        });

        bt2=new Button();
        bt2.setText("Read Log");
        bt2.setLayoutY(10);
        bt2.setLayoutX(280);
        bt2.setOnAction(e->{
            System.out.println(Log.r());
            lb2.setText("Log:\n"+Log.r());
        });


        lb1=new Label();
        lb1.setText("");
        lb1.setLayoutX(150);
        lb1.setLayoutY(10);
        lb1.resize(100,100);

        lb2=new Label();
        lb2.setText("Log:\n");
        lb2.setLayoutX(0);
        lb2.setLayoutY(120);
        lb2.resize(300,180);

        Pane layout= new Pane();
        layout.getChildren().add(bt1);
        layout.getChildren().add(lb1);
        layout.getChildren().add(lb2);
        layout.getChildren().add(bt2);
        Scene scene= new Scene(layout,350,300);
        primaryStage.setScene(scene);
        primaryStage.show();
        Platform.runLater( new Refresh());
    }


}
