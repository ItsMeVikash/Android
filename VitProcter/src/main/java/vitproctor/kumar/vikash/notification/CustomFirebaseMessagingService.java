package vitproctor.kumar.vikash.notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import vitproctor.kumar.vikash.MainActivity;
import vitproctor.kumar.vikash.R;
import vitproctor.kumar.vikash.splash.Splash;

/**
 * Created by vikash kumar on 27-03-2018.
 */


public class CustomFirebaseMessagingService extends FirebaseMessagingService {
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //Calling method to generate notification
        sendNotification(remoteMessage.getData().get("key"), remoteMessage.getNotification().getBody());
    }

    private void sendNotification(String title, String messageBody) {
        Intent intent = new Intent().setClass(this, Notification.class);
        intent.putExtra("lat", title);
        intent.setAction(title);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP );
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.logo)
                .setContentTitle("Vit Proctor")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
        putSmsToFirebase(title);
        //getApplicationContext().startActivity(intent);
    }

    public void putSmsToFirebase(String sms) {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("Notification");
        DatabaseReference messageRef = mFirebaseDatabase.push();
        messageRef.child("MESSAGE").setValue(sms);
        messageRef.child("timestamp").setValue(ServerValue.TIMESTAMP);

    }
}