package net.wasnot.wifitracker.view;

import net.wasnot.wifitracker.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by akihiroaida on 2014/07/18.
 */
public class TrackLayout extends ViewGroup {
    private final static int TYPE_NORMAL = 0;
    private final static int TYPE_STYLISH = 1;

    private final int mType;
    private boolean mEditable;

    public TrackLayout(Context context) {
        super(context);
        mType = TYPE_NORMAL;
    }

    public TrackLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // attrs.xmlに定義したスタイルのインスタンスを作成
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.home);
        String type = a.getString(0);
        a.recycle();
        if (type != null && type.equals("stylish")) {
            mType = TYPE_STYLISH;
        } else {
            mType = TYPE_NORMAL;
        }
    }

    public TrackLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // attrs.xmlに定義したスタイルのインスタンスを作成
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.home);
        String type = a.getString(0);
        a.recycle();
        if (type != null && type.equals("stylish")) {
            mType = TYPE_STYLISH;
        } else {
            mType = TYPE_NORMAL;
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mType == TYPE_STYLISH) {
            setLayoutStylish();
        } else {
            setLayoutNormal();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int width = View.resolveSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int height = View.resolveSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        this.setMeasuredDimension(width, height);

        int childWidthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.UNSPECIFIED);
        int childWidthSpecMatch = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        int childHeightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.UNSPECIFIED);

        int childCount = getChildCount();
        View child;
        for (int i = 0; i < childCount; i++) {
            child = getChildAt(i);
            if (child.getLayoutParams().width == LayoutParams.MATCH_PARENT) {
                child.measure(childWidthSpecMatch, childHeightSpec);
            } else {
                child.measure(childWidthSpec, childHeightSpec);
            }
        }
    }

    private void setLayoutStylish() {
        int count = this.getChildCount();
        final int maxWidth = this.getWidth();
        final int maxHeight = this.getHeight();

        int x = 0;
        int y = 0;
        for (int i = 0; i < count; i++) {
            View child = this.getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                int childWidth = (int) (child.getMeasuredWidth() / 2f);
                int childHeight = (int) (child.getMeasuredHeight() / 2f);
                if (i < 3) {
                    x = (int) (maxWidth / 6f);
                    switch (i) {
                        case 0:
                            y = (int) (maxHeight / 6f);
                            break;
                        case 1:
                            y = (int) (maxHeight / 6f) * 3;
                            break;
                        case 2:
                            y = (int) (maxHeight / 6f) * 5;
                            break;
                    }
                } else if (i < 5) {
                    x = (int) (maxWidth / 6f) * 3;
                    switch (i) {
                        case 3:
                            y = (int) (maxHeight / 6f) * 2;
                            break;
                        case 4:
                            y = (int) (maxHeight / 6f) * 4;
                            break;
                    }
                } else if (i < 8) {
                    x = (int) (maxWidth / 6f) * 5;
                    switch (i) {
                        case 5:
                            y = (int) (maxHeight / 6f);
                            break;
                        case 6:
                            y = (int) (maxHeight / 6f) * 3;
                            break;
                        case 7:
                            y = (int) (maxHeight / 6f) * 5;
                            break;
                    }
                }
                // コントロールを適切な位置に配置
                child.layout(x - childWidth, y - childHeight, x + childWidth, y + childHeight);
            }
        }
    }

    private void setLayoutNormal() {
        int count = this.getChildCount();
        final int maxWidth = this.getWidth();
        final int maxHeight = this.getHeight();

        int x = 0;
        int y = 0;
        for (int i = 0; i < count; i++) {
            View child = this.getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                int childWidth = (int) (child.getMeasuredWidth() / 2f);
                int childHeight = (int) (child.getMeasuredHeight() / 2f);
                if (i < 2) {
                    y = (int) (maxHeight / 8f) * 1;
                    switch (i) {
                        case 0:
                            x = (int) (maxWidth / 4f) * 1;
                            break;
                        case 1:
                            x = (int) (maxWidth / 4f) * 3;
                            break;
                    }
                } else if (i < 4) {
                    y = (int) (maxHeight / 8f) * 3;
                    switch (i) {
                        case 2:
                            x = (int) (maxWidth / 4f) * 1;
                            break;
                        case 3:
                            x = (int) (maxWidth / 4f) * 3;
                            break;
                    }
                } else if (i < 6) {
                    y = (int) (maxHeight / 8f) * 5;
                    switch (i) {
                        case 4:
                            x = (int) (maxWidth / 4f) * 1;
                            break;
                        case 5:
                            x = (int) (maxWidth / 4f) * 3;
                            break;
                    }
                } else if (i < 8) {
                    y = (int) (maxHeight / 8f) * 7;
                    switch (i) {
                        case 6:
                            x = (int) (maxWidth / 4f) * 2;
                            break;
                        case 7:
                            x = (int) (maxWidth / 4f) * 2;
                            break;
                    }
                } else {
                    y = (int) (maxHeight / 8f) * 7;
                    switch (i) {
                        case 8:
                            x = (int) (maxWidth / 4f) * 2;
                            break;
                    }
                }
                // コントロールを適切な位置に配置
                child.layout(x - childWidth, y - childHeight, x + childWidth, y + childHeight);
            }
        }
    }



    public boolean isEditable() {
        return mEditable;
    }

    public void setEditable(boolean editable) {
        mEditable = editable;
    }
}
