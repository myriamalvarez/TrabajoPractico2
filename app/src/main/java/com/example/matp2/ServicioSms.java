package com.example.matp2;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Telephony;
import android.util.Log;

import java.util.Date;

public class ServicioSms extends Service {
    private ContentResolver contenedor;
    private Uri mensajes;

    public ServicioSms() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mensajes = Uri.parse("content://sms");
        contenedor = getContentResolver();

        while (true) {
            ultimosMensajes();
            try{
                Thread.sleep(9000);
            } catch (InterruptedException e){
                e.printStackTrace();
                return super.onStartCommand(intent, flags, startId);
            }
        }
    }
    private void ultimosMensajes(){

        Uri mensajes = Uri.parse("content://sms");
        ContentResolver contenedor = getContentResolver();
        Cursor cursor = contenedor.query(mensajes, null, null, null, null);


        if(cursor.getCount() == 0) Log.d("Mensaje", "Sin mensajes");

            while (cursor.moveToNext() && cursor.getPosition() < 5){

                Log.d("Mensaje", " " +"\n nro: "+ cursor.getString(2)
                                                +"\n fecha:"+ cursor.getString(4)
                                                +"\n sms: " + cursor.getString(12));
                }
                cursor.close();
            }
        }

