package prakhar.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,reset;
    int chance=0;
    int board[][]=new int[][]{
            {-1,-1,-1},{-1,-1,-1},{-1,-1,-1}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initiallizing the buttons
        initialize();
        //setting on click listeners
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        reset.setOnClickListener(this);
    }
    void initialize(){
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        reset=(Button)findViewById(R.id.reset);
    }

    @Override
    public void onClick(View view) {
        //creating object of the game class
        Game obj=new Game();
        int pos=-1;
        Intent i;
        int result=0;
        switch(view.getId()){
            //to reset
            case R.id.reset:
                 i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;
            case R.id.button1:
                b1.setText("X");
                b1.setTextSize(40);
                b1.setClickable(false);
                ++chance;
                board[0][0]=1;
                result=obj.output(board);
                if(result==0 && obj.moveLeft(board))
                pos=obj.findBestMove(board);
                if(result==-10)
                    lose();
                if(obj.moveLeft(board))
                    assign(pos);
                else
                    draw();
                break;
            case R.id.button2:
                b2.setText("X");
                b2.setTextSize(40);
                b2.setClickable(false);
                ++chance;
                board[0][1]=1;
                result=obj.output(board);
                if(result==0 && obj.moveLeft(board))
                pos=obj.findBestMove(board);
                if(result==-10)
                    lose();
                if(obj.moveLeft(board))
                    assign(pos);
                else
                    draw();
                break;
            case R.id.button3:
                b3.setText("X");
                b3.setClickable(false);
                b3.setTextSize(40);
                ++chance;
                board[0][2]=1;
                result=obj.output(board);
                if(result==0 && obj.moveLeft(board))
                pos=obj.findBestMove(board);
                if(result==-10)
                    lose();
                if(obj.moveLeft(board))
                    assign(pos);
                else
                    draw();
                break;
            case R.id.button4:
                b4.setText("X");
                b4.setTextSize(40);
                b4.setClickable(false);
                ++chance;
                board[1][0]=1;
                result=obj.output(board);
                if(result==0 && obj.moveLeft(board))
                pos=obj.findBestMove(board);
                if(result==-10)
                    lose();
                if(obj.moveLeft(board))
                    assign(pos);
                else
                    draw();
                break;
            case R.id.button5:
                b5.setText("X");
                b5.setTextSize(40);
                b5.setClickable(false);
                ++chance;
                board[1][1]=1;
                result=obj.output(board);
                if(result==0 && obj.moveLeft(board))
                pos=obj.findBestMove(board);
                if(result==-10)
                    lose();
                if(obj.moveLeft(board))
                    assign(pos);
                else
                    draw();
                break;
            case R.id.button6:
                b6.setText("X");
                b6.setClickable(false);
                b6.setTextSize(40);
                ++chance;
                board[1][2]=1;
                result=obj.output(board);
                if(result==0 && obj.moveLeft(board))
                pos=obj.findBestMove(board);
                if(result==-10)
                    lose();
                if(obj.moveLeft(board))
                    assign(pos);
                else
                    draw();
                break;
            case R.id.button7:
                b7.setTextSize(40);
                b7.setText("X");
                b7.setClickable(false);
                ++chance;
                board[2][0]=1;
                result=obj.output(board);
                if(result==0 && obj.moveLeft(board))
                pos=obj.findBestMove(board);
                if(result==-10)
                    lose();
                if(obj.moveLeft(board))
                    assign(pos);
                else
                    draw();
                break;
            case R.id.button8:
                ++chance;
                b8.setTextSize(40);
                b8.setText("X");
                b8.setClickable(false);
                board[2][1]=1;
                result=obj.output(board);
                if(result==0 && obj.moveLeft(board))
                pos=obj.findBestMove(board);
                if(result==-10)
                    lose();
                if(obj.moveLeft(board))
                    assign(pos);
                else
                    draw();
                break;
            case R.id.button9:
                ++chance;
                b9.setTextSize(40);
                b9.setText("X");
                b9.setClickable(false);
                board[2][2]=1;
                result=obj.output(board);
                if(result==0 && obj.moveLeft(board))
                pos=obj.findBestMove(board);
                if(result==-10)
                    lose();
                if(obj.moveLeft(board))
                    assign(pos);
                else
                    draw();
                break;

        }


    }

    public void assign(int pos)  {
        //Toast.makeText(this,Integer.toString(pos),Toast.LENGTH_SHORT).show();
        int y=pos%10;
        int x=pos/10;
        board[x][y]=0;
        Game obj=new Game();
        int result=obj.output(board);
        if(x==0 && y==0){
            //Thread.sleep(500);
            b1.setText("O");
            b1.setTextSize(40);
            b1.setClickable(false);
        }
        if(x==0 && y==1){
           // Thread.sleep(500);
            b2.setText("O");
            b2.setTextSize(40);
            b2.setClickable(false);
        }
        if(x==0 && y==2){
           // Thread.sleep(250);
            b3.setText("O");
            b3.setTextSize(40);
            b3.setClickable(false);
        }
        if(x==1 && y==0){
            //Thread.sleep(500);
            b4.setText("O");
            b4.setTextSize(40);
            b4.setClickable(false);
        }
        if(x==1 && y==1){
            b5.setText("O");
            b5.setTextSize(40);
            b5.setClickable(false);
        }
        if(x==1 && y==2){
            //Thread.sleep(500);
            b6.setText("O");
            b6.setClickable(false);
            b6.setTextSize(40);
        }
        if(x==2 && y==0){
            //Thread.sleep(500);
            b7.setText("O");
            b7.setTextSize(40);
            b7.setClickable(false);
        }
        if(x==2 && y==1){
            //Thread.sleep(500);
            b8.setText("O");
            b8.setClickable(false);
            b8.setTextSize(40);
        }
        if(x==2 && y==2){
           // Thread.sleep(500);
            b9.setClickable(false);
            b9.setTextSize(40);
            b9.setText("O");
        }
        if(result==10){
            win();
        }
    }
    public void win(){
        Toast.makeText(this,"I Won",Toast.LENGTH_SHORT).show();

        setButton();

    }
    public void lose(){
        Toast.makeText(this,"You Won",Toast.LENGTH_SHORT).show();

        setButton();
    }
    public void draw(){
        Toast.makeText(this,"DRAW!!",Toast.LENGTH_SHORT).show();
    }
    public void setButton(){
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        b4.setClickable(false);
        b5.setClickable(false);
        b6.setClickable(false);
        b7.setClickable(false);
        b8.setClickable(false);
        b9.setClickable(false);

        //for diagonal
        if(board[0][0]==board[1][1] && board[1][1]==board[2][2]){
            b1.setBackgroundColor(Color.RED);
            b5.setBackgroundColor(Color.RED);
            b9.setBackgroundColor(Color.RED);
        }
        if(board[0][2]==board[1][1] && board[2][0]==board[1][1]){
            b3.setBackgroundColor(Color.RED);
            b5.setBackgroundColor(Color.RED);
            b7.setBackgroundColor(Color.RED);
        }
        //rows
        if(board[0][0]==board[0][1] && board[0][1]==board[0][2]){
            b1.setBackgroundColor(Color.RED);
            b2.setBackgroundColor(Color.RED);
            b3.setBackgroundColor(Color.RED);
        }
        if(board[1][0]==board[1][1] && board[1][1]==board[1][2]){
            b4.setBackgroundColor(Color.RED);
            b5.setBackgroundColor(Color.RED);
            b6.setBackgroundColor(Color.RED);
        }
        if(board[2][0]==board[2][1] && board[2][1]==board[2][2]){
            b7.setBackgroundColor(Color.RED);
            b8.setBackgroundColor(Color.RED);
            b9.setBackgroundColor(Color.RED);
        }
        //column
        if(board[0][0]==board[1][0] && board[1][0]==board[2][0]){
            b1.setBackgroundColor(Color.RED);
            b4.setBackgroundColor(Color.RED);
            b7.setBackgroundColor(Color.RED);
        }
        if(board[0][1]==board[1][1] && board[1][1]==board[2][1]){
            b2.setBackgroundColor(Color.RED);
            b5.setBackgroundColor(Color.RED);
            b8.setBackgroundColor(Color.RED);
        }
        if(board[0][2]==board[1][2] && board[1][2]==board[2][2]){
            b3.setBackgroundColor(Color.RED);
            b6.setBackgroundColor(Color.RED);
            b9.setBackgroundColor(Color.RED);
        }
    }

}
