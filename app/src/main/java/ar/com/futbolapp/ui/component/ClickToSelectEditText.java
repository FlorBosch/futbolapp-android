package ar.com.futbolapp.ui.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import ar.com.futbolapp.R;

public class ClickToSelectEditText<T extends ClickToSelectEditText.Listable> extends EditText {

    List<T> mItems;
    String[] mListableItems;
    CharSequence mHint;

    OnItemSelectedListener<T> onItemSelectedListener;

    public ClickToSelectEditText(Context context) {
        super(context);

        mHint = getHint();
    }

    public ClickToSelectEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        mHint = getHint();
    }

    public ClickToSelectEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mHint = getHint();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ClickToSelectEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        mHint = getHint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setFocusable(false);
        setClickable(true);
    }

    public void setItems(List<T> items) {
        this.mItems = items;
        this.mListableItems = new String[items.size()];

        int i = 0;

        for (T item : mItems) {
            mListableItems[i++] = getContext().getString(item.getLabel());
        }

        configureOnClickListener();
    }

    private void configureOnClickListener() {
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClickToSelectEditText.this.onClick(v);
                return true ;
            }
        });
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickToSelectEditText.this.onClick(view);
            }
        });
    }

    private void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(mHint);
        builder.setItems(mListableItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int selectedIndex) {
                setText(mListableItems[selectedIndex]);

                if (onItemSelectedListener != null) {
                    onItemSelectedListener.onItemSelectedListener(mItems.get(selectedIndex), selectedIndex);
                }
            }
        });
        builder.setPositiveButton(R.string.dialog_close_button, null);
        builder.create().show();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener<T> onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public interface OnItemSelectedListener<T> {
        void onItemSelectedListener(T item, int selectedIndex);
    }

    public interface Listable {
        @StringRes int getLabel();
    }
}