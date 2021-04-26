package mx.tecnm.tepic.ladm_u2_p1_semafoto

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import java.util.concurrent.Semaphore

class lienzo(activity:MainActivity): View(activity) {
    var semaphore = Semaphore(2)
    var contadorVerde=0
    var contadorNaranja=0
    var aumento=0
    var aumento2=0
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        val Thread1=Threads(this)

        Thread1.start()
        invalidate()
        canvas.drawColor(ContextCompat.getColor(context, R.color.gray))

        paint.color= Color.BLUE

        canvas.drawRect(Rect(400,0,700,3200),paint)

        canvas.drawRect(Rect(0,700,1200,1200),paint)



        //---------------- SEMAFORO 1-------------------
        //semaforos
        canvas.drawRect(Rect(50,100,250,650),paint)
        //circulos
        paint.color=ContextCompat.getColor(context,R.color.red2)
        canvas.drawCircle(150f,200f, 75f, paint)
        paint.color=ContextCompat.getColor(context,R.color.orange2)
        canvas.drawCircle(150f,375f, 75f, paint)
        paint.color=ContextCompat.getColor(context,R.color.green1)
        canvas.drawCircle(150f,550f, 75f, paint)


        //---------------- SEMAFORO 2-------------------
        //semaforos
        paint.color=Color.BLUE
        canvas.drawRect(Rect(800,1300,1000,1850),paint)
        //circulos
        paint.color=ContextCompat.getColor(context,R.color.red1)
        canvas.drawCircle(900f,1400f, 75f, paint)

        paint.color=ContextCompat.getColor(context,R.color.orange2)
        canvas.drawCircle(900f,1575f, 75f, paint)

        paint.color=ContextCompat.getColor(context,R.color.green2)
        canvas.drawCircle(900f,1750f, 75f, paint)


            if(contadorVerde>100){
                paint.color=ContextCompat.getColor(context,R.color.green2)
                canvas.drawCircle(150f,550f, 75f, paint)
                paint.color=ContextCompat.getColor(context,R.color.orange1)
                canvas.drawCircle(150f,375f, 75f, paint)


            }
            if(contadorVerde>175){
            paint.color=ContextCompat.getColor(context,R.color.orange1)
            canvas.drawCircle(150f,375f, 75f, paint)
                paint.color=ContextCompat.getColor(context,R.color.red2)

                canvas.drawCircle(150f,200f, 75f, paint)

            }
            if(contadorVerde>225){
                paint.color=ContextCompat.getColor(context,R.color.orange2)
                canvas.drawCircle(150f,375f, 75f, paint)
            paint.color=ContextCompat.getColor(context,R.color.red1)
            canvas.drawCircle(150f,200f, 75f, paint)

                paint.color=ContextCompat.getColor(context,R.color.green1)
                canvas.drawCircle(900f,1750f, 75f, paint)
                paint.color=ContextCompat.getColor(context,R.color.red2)
                canvas.drawCircle(900f,1400f, 75f, paint)
            }


            if(contadorVerde>700) {
                paint.color = ContextCompat.getColor(context, R.color.green2)
                canvas.drawCircle(900f, 1750f, 75f, paint)

                paint.color = ContextCompat.getColor(context, R.color.orange1)
                canvas.drawCircle(900f, 1575f, 75f, paint)

            }

        if(contadorVerde>775) {
            paint.color = ContextCompat.getColor(context, R.color.orange2)
            canvas.drawCircle(900f, 1575f, 75f, paint)

            paint.color = ContextCompat.getColor(context, R.color.orange1)
            canvas.drawCircle(900f, 1575f, 75f, paint)

        }

        if(contadorVerde>825){
            paint.color=ContextCompat.getColor(context,R.color.orange2)
            canvas.drawCircle(900f,1575f, 75f, paint)
            paint.color=ContextCompat.getColor(context,R.color.red1)
            canvas.drawCircle(900f,1400f, 75f, paint)

            paint.color=ContextCompat.getColor(context,R.color.green1)
            canvas.drawCircle(150f,550f, 75f, paint)

            paint.color=ContextCompat.getColor(context,R.color.red2)
            canvas.drawCircle(150f,200f, 75f, paint)
        }

            paint.color=Color.GREEN
            canvas.drawCircle(100f+aumento,900f, 50f, paint)
            canvas.drawCircle(1000f-aumento,1050f, 50f, paint)

            canvas.drawCircle(500f,350f+aumento2, 50f, paint)
            canvas.drawCircle(600f,1500f-aumento2, 50f, paint)


    }
}


class Threads(activity: lienzo):Thread(){
    val act=activity
    override fun run(){
        super.run()
        while(true){
            try {
                act.contadorVerde++
                if(act.contadorVerde<225){
                    act.aumento++
                    act.aumento2++
                }
                else{
                    act.aumento2++
                    if(act.contadorVerde>825){
                        act.aumento++
                    }
                }

                if(act.contadorVerde==1200){
                    act.contadorVerde=0
                    act.aumento=0
                    act.aumento2=0
                }
                sleep(20000)

            }
            catch (e: InterruptedException){
                System.out.println(e)
            }
        }

    }
}