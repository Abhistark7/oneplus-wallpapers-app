package com.whiteturtlestudio.oneplus5twalls;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.kobakei.ratethisapp.RateThisApp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.github.yavski.fabspeeddial.FabSpeedDial;

import static java.lang.System.out;


public class SetWallpaper extends AppCompatActivity {
    AdView mAdview;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_set_wallpaper);
        RateThisApp.showRateDialogIfNeeded(this);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //Display Banner Ad in HomeScreen
        mAdview = (AdView) findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        //Displaying Interstitial Ad
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener()

                                     {
                                         @Override
                                         public void onAdClosed() {

                                             interstitialAd.loadAd(new AdRequest.Builder().build());


                                         }
                                     }





        );

        //Importing image from imageAdapter to Display
        Intent i = getIntent();
        final int position = i.getExtras().getInt("id");
        final ImageAdapter adapter = new ImageAdapter(this);

        final ImageView imageView = (ImageView) findViewById(R.id.imgView);
        imageView.setImageResource(adapter.images[position]);


        FabSpeedDial fabSpeedDial = (FabSpeedDial) findViewById(R.id.fabSpeedDial);
        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();

                /*if (id == R.id.action_set) {
                    WallpaperManager myWallpaperManager
                            = WallpaperManager.getInstance(getApplicationContext());
                    try {
                        myWallpaperManager.setResource(adapter.images[position]);
                        
                        Toast.makeText(getBaseContext(),
                                "Wallpaper Set!",
                                Toast.LENGTH_SHORT).show();




                        if(interstitialAd.isLoaded())
                        {
                            interstitialAd.show();
                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }*/
                if (id == R.id.action_set) {
                    setAs();
                }

                if (id == R.id.action_back) {



                    Intent i = new Intent(getApplicationContext(), MainActivity.class);

                    startActivity(i);

                }


                if (id == R.id.action_save) {
                    startSave();

                    if(interstitialAd.isLoaded())
                    {
                        interstitialAd.show();
                    }

                }


                return true;
            }

            @Override
            public void onMenuClosed() {

            }
        });
    }

    public class SingleMediaScanner implements MediaScannerConnection.MediaScannerConnectionClient {

        private MediaScannerConnection mMs;
        private File mFile;

        public SingleMediaScanner(Context context, File f) {
            mFile = f;
            mMs = new MediaScannerConnection(context, this);
            mMs.connect();
        }

        @Override
        public void onMediaScannerConnected() {
            mMs.scanFile(mFile.getAbsolutePath(), null);
        }

        @Override
        public void onScanCompleted(String path, Uri uri) {
            mMs.disconnect();
        }

    }

    public void setAs()
    {
        /*Intent i = getIntent();
        final int position = i.getExtras().getInt("id");
        String myimage = new String("image"+position);
        Uri imgUri=Uri.parse("android.resource://your.package.name/"+"R.drawable."+ myimage);
        try {
            InputStream stream = getContentResolver().openInputStream(imgUri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
        intent.addCategory(Intent.CATEGORY_APP_GALLERY);
        intent.setDataAndType(imgUri, "image/jpg");
        intent.putExtra("mimeType", "image/jpg");
        this.startActivity(Intent.createChooser(intent, "Set as:"));*/

        /*Intent i = getIntent();
        final int position = i.getExtras().getInt("id");
        final ImageAdapter adapter = new ImageAdapter(this);
        Bitmap finalBitmap;

        finalBitmap = BitmapFactory.decodeResource(getResources(),
                adapter.images[position]);
        try {
            String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/OnePlus5TWalls/" + position;
            if (!new File(str2).exists()) {
                OutputStream fileOutputStream = new FileOutputStream(str2);
                finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                fileOutputStream.close();
                fileOutputStream.flush();
            }
            Uri a = Uri.parse("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/OnePlus5TWalls/" + position);
            Intent intent = new Intent("android.intent.action.ATTACH_DATA");
            intent.addCategory(Intent.CATEGORY_APP_GALLERY);
            intent.setDataAndType(a, "image/*");
            intent.putExtra("mimeType", "image");
            this.startActivity(Intent.createChooser(intent, "Set as:"));
        } catch (Exception e) {
        }*/


        /*try {
            WallpaperManager.getInstance(this.getApplicationContext()).setBitmap(this.f4841a);
            Toast.makeText(this.f4842b, "Wallpaper set successfully", 0).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f4844d.dismiss();
        this.f4842b.setResult(-1);*/















        /*Intent i = getIntent();
        final ImageAdapter adapter = new ImageAdapter(this);
        final int position = i.getExtras().getInt("id");
        Bitmap finalbitmap;

        finalbitmap = BitmapFactory.decodeResource(getResources(),
                adapter.images[position]);
        Intent setAs = new Intent(Intent.ACTION_ATTACH_DATA);
        setAs.setType("image/*");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        finalbitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        File f = new File(Environment.getExternalStorageDirectory()
                + File.separator + "/my_tmp_file.jpg");
        try {
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        setAs.setDataAndType(Uri.parse("file://" + Environment.getExternalStorageDirectory()+ File.separator + "/my_tmp_file.jpg"),
                "image/*");
        setAs.putExtra("mimeType", "image/*");
        startActivity(Intent.createChooser(setAs, "Set Image As"));*/






        Intent i = getIntent();
        final ImageAdapter adapter = new ImageAdapter(this);
        final int position = i.getExtras().getInt("id");
        Bitmap finalbitmap;

        finalbitmap = BitmapFactory.decodeResource(getResources(),
                adapter.images[position]);
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root);
        myDir.mkdirs();
        String fname = "wall.jpg";
        final File file = new File (myDir, fname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalbitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            out.flush();
            out.close();
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(root + "/OnePlus 5T Walls"))));

        } catch (Exception e) {
            e.printStackTrace();
        }
        new SingleMediaScanner(this, myDir);
        /*Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString(), "Wallpaper.jpg"));
        Intent setAs = new Intent(Intent.ACTION_ATTACH_DATA);
        setAs.setType("image/*");
        setAs.setDataAndType(uri,
            "image/*");
        setAs.putExtra("mimeType", "image/*");
        startActivity(Intent.createChooser(setAs, "Set Image As"));*/
        Uri picUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString(), "wall.jpg"));
        Intent setAs = new Intent("android.intent.action.ATTACH_DATA");
        setAs.setDataAndType(picUri, "image/*");
        setAs.putExtra("android.intent.extra.STREAM", picUri);
        startActivityForResult(Intent.createChooser(setAs, "Set As"), 0);


    }




    public void startSave()
    {

        Intent i = getIntent();
        final ImageAdapter adapter = new ImageAdapter(this);
        final int position = i.getExtras().getInt("id");
        Bitmap finalbitmap;

        finalbitmap = BitmapFactory.decodeResource(getResources(),
                adapter.images[position]);
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/OnePlus 5T Walls");
        myDir.mkdirs();
        String fname = "Wallpaper"+ position +".jpg";
        File file = new File (myDir, fname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalbitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            //sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            out.flush();
            out.close();
            //sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(root + "/OnePlus 5T Walls"))));

        } catch (Exception e) {
            e.printStackTrace();
        }
        new SingleMediaScanner(this, myDir);
        Toast.makeText(getBaseContext(),
                "Wallpaper Saved to /OnePlus 5T Walls Folder",
                Toast.LENGTH_LONG).show();

    }


}
