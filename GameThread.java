package net.wereduck.o7planning2dgame;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    private boolean running;
    private GameSurface gameSurface;
    private SurfaceHolder surfaceHolder;
    private static final long targetTime = 130;

    public GameThread(GameSurface gameSurface, SurfaceHolder surfaceHolder) {
        this.gameSurface = gameSurface;
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();

        while(running) {
            Canvas canvas = null;
            try {
                //Get Canvas from holder and lock it
                canvas = this.surfaceHolder.lockCanvas();

                //Synchronized
                synchronized (canvas) {
                    this.gameSurface.update();
                    this.gameSurface.draw(canvas);
                }
            }catch(Exception e) {
                //do nothing
            }finally {
                if(canvas != null) {
                    //unlock canvas
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            long now = System.nanoTime();
            //Interval to redraw game
            //(Change nanoseconds to milliseconds)
            long passedTime = (now - startTime)/1000000;
            long waitTime = 0;
            if(passedTime < targetTime) {
               waitTime = targetTime - passedTime; //milliseconds
            }

            try{
                //Sleep.
                this.sleep(waitTime);
            }catch (Exception e){
                //do nothing
            }
            startTime = System.nanoTime();
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
