package com.kejriwalpratick.reflyex;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;


public class gameplay extends AppCompatActivity {
    ArrayList<flyingObject> objS;
    CountDownTimer mCountDownTimer;
    long countdownPeriod;
    int Score = 0;
    int flag = -1;
    ConstraintLayout layout;
    int index = -1;
    TextView scoreTextView;
    int level = 1;
    long timerTime = 2200;
    int k = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        final Handler handler = new Handler();
        final TextView textView1 = (TextView) findViewById(R.id.textView8);
        final java.util.concurrent.atomic.AtomicInteger n = new AtomicInteger(4);
        final Runnable counter = new Runnable() {
            @Override
            public void run() {
                if (n.get() >= 2)
                    textView1.setText(Integer.toString(n.get() - 1));
                else
                    textView1.setText("" + "GO !");
                if (n.getAndDecrement() >= 1)
                    handler.postDelayed(this, 1000);
                else {
                    createShuffle();
                    startGame();
                }
            }
        };
        handler.postDelayed(counter, 1000);

        scoreTextView = (TextView) findViewById(R.id.textView7);
        layout = (ConstraintLayout) findViewById(R.id.constraintLayout1);
        layout.setOnTouchListener(new onSwipeListener(this) {
            public void onSwipeTop() {
                if (objS.get(index).getFv() == 'Y') {
                    cancelTimer();
                    if (flag != 0) {
                        toastRight();
                        scoreTextView.setText("" + ++Score);
                        startGame();
                    }
                }
                else {
                    if (flag != 0) {
                        cancelTimer();
                        toastWrong();
                        endDialog(objS.get(index).getMessage());
                    }
                }
            }

            public void onSwipeBottom() {
                if (objS.get(index).getFv() == 'N') {
                    cancelTimer();
                    if (flag != 0) {
                        toastRight();
                        scoreTextView.setText("" + ++Score);
                        startGame();
                    }
                }
                else {
                    if(flag != 0) {
                        cancelTimer();
                        toastWrong();
                        endDialog(objS.get(index).getMessage());
                    }
                }
            }
        });
    }


    public void createList() {
        objS = new ArrayList<flyingObject>();
        objS.add(new flyingObject("Crow", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Parrot", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Cow", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Human", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Rocket", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Dog", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Jeans", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Parachuted Man", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Kite", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Starfish", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Stick", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Superman", 'Y',"Don't you know Superman?"));

        objS.add(new flyingObject("Drone", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Penguin", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Owl", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Snake", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Sparrow", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Ostrich", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Flying  Squirrel", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Air Balloon", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Car", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Kingfisher", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Bull", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Computer", 'N',"Sorry, Incorrect Choice"));

        objS.add(new flyingObject("Kiwi", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Ball", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Missile", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("T-rex", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Meteor", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Gold", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Sun", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Eagle", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Mosquito", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Thor", 'Y',"Don't you know Thor? Google him"));
        objS.add(new flyingObject("Telephone", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Cheetah", 'N',"Sorry, Incorrect Choice"));

        objS.add(new flyingObject("Spaceship", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Pencil", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Iphone", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Ice cream", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Lion", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Apple", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Interstellar", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("A Bat", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Ant", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Pizza", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Cockroach", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("UFO", 'Y',"Sorry, Incorrect Choice"));

        objS.add(new flyingObject("Myna", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Chicken", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Donkey", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Peacock", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Jets", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Duck", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Android", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Satellite", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Falcon", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Bugs", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("tree", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Monkey", 'N',"Sorry, Incorrect Choice"));

        objS.add(new flyingObject("Unicorn", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Mongoose", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Horse", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Books", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Vulture", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Grasshopper", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Spiders", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Iron Man", 'Y',"Tony Stark will kill you"));
        objS.add(new flyingObject("Woodpecker", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Power Rangers", 'N',"Most Power Rangers do not fly"));
        objS.add(new flyingObject("Bulldog", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Clock", 'N',"Sorry, Incorrect Choice"));

        objS.add(new flyingObject("Kangaroo", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Milkha Singh", 'Y',"Indian Sprinter Milkha Singh is known as \"The Flying Sikh\""));
        objS.add(new flyingObject("Time", 'Y',"You must have heard \"Time Flies\""));
        objS.add(new flyingObject("Phoenix", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Dust", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Smoke", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Helicopter", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Harry Potter on Firebolt", 'Y',"Harry Potter is a wizard"));
        objS.add(new flyingObject("Wind", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Bee", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Hyena", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Jaguar", 'N',"Sorry, Incorrect Choice"));

        objS.add(new flyingObject("Sheep", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Dragon fly", 'Y',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Burj Khalifa", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Bus", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("GOKU", 'Y',"Please google GOKU"));
        objS.add(new flyingObject("Pikachu", 'N',"Pikachu is a famous pokemon. It does'nt fly"));
        objS.add(new flyingObject("Rajnikanth", 'Y',"Rajnikanth can do anything"));
        objS.add(new flyingObject("Cricket Bat", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Tiger", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Beyblade", 'N',"Beyblade is a famous manga series. Google it."));
        objS.add(new flyingObject("Ferrari", 'N',"Sorry, Incorrect Choice"));
        objS.add(new flyingObject("Cat", 'N',"Sorry, Incorrect Choice"));
    }

    public void startGame() {
        if(index < 96){
            if (index == k && timerTime > 1200) {
                k += 3;
                timerTime = timerTime - 50;
                level++;

            }
            TextView levelTextView = (TextView) findViewById(R.id.textView12);
            TextView textView = (TextView) findViewById(R.id.textView8);
            cancelTimer();
            levelTextView.setText("" + level);
            textView.setText("" + objS.get(++index).getObj());
            createCountDownTimer(timerTime);
        }
        else {
            endDialog("You Win.");
        }
    }

    public void createShuffle() {
        createList();
        Collections.shuffle(objS);
    }

    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onStop() {
        super.onStop();
        cancelTimer();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(countdownPeriod>0)
        restartDialog();
    }

    public void createCountDownTimer(long timerTime) {
        final TextView timerTextView = (TextView) findViewById(R.id.textView5);
        mCountDownTimer = new CountDownTimer(timerTime, 10) {
            @Override
            public void onTick(long millisUntilFinished)
            {   if(countdownPeriod>500)
                timerTextView.setTextColor(Color.GREEN);
                else{
                timerTextView.setTextColor(Color.RED);
                }
                timerTextView.setText("" + (millisUntilFinished / 10));
                countdownPeriod = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                flag = 0;
                endDialog("Time's Up");
            }
        }.start();
    }

    public void cancelTimer() {
        if (mCountDownTimer != null)
            mCountDownTimer.cancel();
    }

    public void toastRight() {
        final Toast toast = new Toast(gameplay.this);
        ImageView view2 = new ImageView(gameplay.this);
        view2.setImageResource(R.drawable.icons8checkmark48);
        toast.setView(view2);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 100);
    }

    public void toastWrong() {
        final Toast toast = new Toast(gameplay.this);
        ImageView view2 = new ImageView(gameplay.this);
        view2.setImageResource(R.drawable.icons8wrong48);
        toast.setView(view2);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 100);
    }


    public void endDialog(String message) {
        Dialog dialog = new Dialog(gameplay.this);
        dialog.setContentView(R.layout.enddailog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("Game Over");
        dialog.setCancelable(false);
        TextView text = dialog.findViewById(R.id.textView9);
        text.setText(message);
        TextView scoreText = dialog.findViewById(R.id.textView14);
        scoreText.setText("" + Score);

        Button button = dialog.findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(gameplay.this, MainActivity.class));
            }
        });
        Button button2 = dialog.findViewById(R.id.button10);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(gameplay.this, gameplay.class));
            }
        });
        dialog.show();
    }
    public void restartDialog() {
        final Dialog dialog = new Dialog(gameplay.this);
        dialog.setContentView(R.layout.restart);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("Game Paused");
        dialog.setCancelable(false);

        Button button = dialog.findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                createCountDownTimer(countdownPeriod);
            }
        });
        dialog.show();
    }
}
