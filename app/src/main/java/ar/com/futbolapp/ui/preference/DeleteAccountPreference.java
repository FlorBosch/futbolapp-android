package ar.com.futbolapp.ui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.widget.Toast;

public class DeleteAccountPreference extends DialogPreference {

    public DeleteAccountPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DeleteAccountPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void onClick(DialogInterface dialog, int which) {
        super.onClick(dialog, which);
        if (which == -1) {
            Toast.makeText(getContext(), "Delete account", Toast.LENGTH_SHORT).show();
        }
    }

}